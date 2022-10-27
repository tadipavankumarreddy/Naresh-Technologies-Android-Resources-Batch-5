package in.nareshtechnologies.powerreceiver;

import static android.content.Intent.ACTION_POWER_CONNECTED;
import static android.content.Intent.ACTION_POWER_DISCONNECTED;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        IntentFilter intentFilter = new IntentFilter();
        // the broadcasts that you want to receive will be  written to this object
        intentFilter.addAction(ACTION_POWER_CONNECTED);
        intentFilter.addAction(ACTION_POWER_DISCONNECTED);

        //Register broadcast
        registerReceiver(new PowerReceiver(imageView),intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(new PowerReceiver(imageView));
    }
}


/*
* I want to receive
*   ACTION_POWER_CONNECTED
*   ACTION_POWER_DISCONNECTED Broadcasts
*
* Your broadcastreceiver class will have onReceive(..) method. This method is invoked only when there is a
* broadcast of our interest appears.
* */