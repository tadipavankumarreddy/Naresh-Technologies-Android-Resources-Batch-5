package in.nareshtechnologies.fruityviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView results;
    ProgressBar progressBar;
    String link = "https://www.fruityvice.com/api/fruit/all";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        results = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
    }

    public void fetchData(View view) {
        progressBar.setVisibility(View.VISIBLE);
        FetchFruitsData ffd = new FetchFruitsData(results,this,progressBar);
        ffd.execute(link);
    }
}