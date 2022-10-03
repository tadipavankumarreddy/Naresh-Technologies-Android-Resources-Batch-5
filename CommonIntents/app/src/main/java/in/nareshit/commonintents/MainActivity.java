package in.nareshit.commonintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText url_et, address_et, phone_et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url_et = findViewById(R.id.url_et);
        address_et = findViewById(R.id.address_et);
        phone_et = findViewById(R.id.phone_et);
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

    public void openMaps(View view) {
        String address = address_et.getText().toString();
        Uri data = Uri.parse("geo:0,0?q="+address);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(data);
        // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+address));
        startActivity(intent);
    }

    public void openDailer(View view) {
        String pn = phone_et.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+pn));
        startActivity(intent);
    }

    public void openWifiSettings(View view) {
        Intent intent = new Intent(Settings.ACTION_SETTINGS);
        startActivity(intent);
    }
}