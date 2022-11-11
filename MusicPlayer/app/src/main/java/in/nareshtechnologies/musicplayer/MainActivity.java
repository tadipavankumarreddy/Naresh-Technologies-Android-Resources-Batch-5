package in.nareshtechnologies.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startMusic(View view) {
        startService(new Intent(this,MusicService.class));
    }

    public void stopMusic(View view) {
        stopService(new Intent(this,MusicService.class));
    }
}