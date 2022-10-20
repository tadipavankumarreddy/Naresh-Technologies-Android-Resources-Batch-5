package in.nareshtechnologies.inshortnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    String link = "https://inshortsapi.vercel.app/news?category=";
    RecyclerView recyclerView;
    ProgressBar progressBar;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        recyclerView = findViewById(R.id.recyclerview);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                progressBar.setVisibility(View.VISIBLE);
                String category = adapterView.getItemAtPosition(i).toString();
                String actual_url = link+category;
                fetchNews(actual_url);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void fetchNews(String url) {

        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.INVISIBLE);
                Gson gson = new Gson();
                SourceData sourceData = gson.fromJson(response, SourceData.class);
                NewsAdapter na = new NewsAdapter(MainActivity.this,sourceData.getData());
                recyclerView.setAdapter(na);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                progressBar.setVisibility(View.GONE);
            }
        });

        queue.add(request);
    }
}