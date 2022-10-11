package in.nareshtechnologies.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MAIN","onCreate()");
        System.out.println("HELLO");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MAIN","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MAIN","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MAIN","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MAIN","onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MAIN","onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MAIN","onRestart()");
    }
}