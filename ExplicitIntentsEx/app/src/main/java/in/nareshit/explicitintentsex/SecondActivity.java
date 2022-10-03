package in.nareshit.explicitintentsex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        result = findViewById(R.id.results);

        Intent i = getIntent();
        String data = i.getStringExtra("NAME");

        result.setText(data);
    }
}