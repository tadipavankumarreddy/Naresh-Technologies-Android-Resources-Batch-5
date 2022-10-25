package in.nareshtechnologies.fruityviceretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String link = "https://www.fruityvice.com/api/fruit/";
    TextView textView; ProgressBar progressBar;

    Retrofit retrofit;
    FruitService fs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(link)
                .build();

       fs = retrofit.create(FruitService.class);
    }

    public void fetchData(View view) {
        progressBar.setVisibility(View.VISIBLE);
        Call<List<Datum>> call = fs.getFruitsData();
        call.enqueue(new Callback<List<Datum>>() {
            @Override
            public void onResponse(Call<List<Datum>> call, Response<List<Datum>> response) {
                textView.setText("");
                Log.d("MAIN",""+response.body());
                List<Datum> dat = response.body();
                if(dat!=null){
                    for(Datum d : dat){
                        textView.append(d.getName()+"\n\n");
                        Toast.makeText(MainActivity.this, d.getName(), Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "DAta is null", Toast.LENGTH_SHORT).show();
                }

                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<Datum>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);
                t.printStackTrace();
            }
        });
    }
}