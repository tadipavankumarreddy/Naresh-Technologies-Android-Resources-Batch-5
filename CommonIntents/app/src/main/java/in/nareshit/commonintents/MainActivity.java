package in.nareshit.commonintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText url_et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url_et = findViewById(R.id.url_et);
    }

    public void openBrowser(View view) {
        String u = url_et.getText().toString();
        Uri data;
        if(u.contains("https://")) {
            data = Uri.parse(u);
        }else{
            data = Uri.parse("https://"+u);
        }

        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(data);
        startActivity(i);
    }
}