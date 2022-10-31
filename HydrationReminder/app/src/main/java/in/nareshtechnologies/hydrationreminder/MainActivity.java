package in.nareshtechnologies.hydrationreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    AlarmManager manager;
    PendingIntent pi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        pi = PendingIntent.getBroadcast(this, 45,new Intent(this,HydrationReceiver.class),PendingIntent.FLAG_IMMUTABLE);
    }

    public void sendAlarm(View view) {
        // when you set the alarm, use setInExactRepeating() method.
        long firstTriggertime = SystemClock.elapsedRealtime() + (60*1000);
        long intervalTime = 2* 60* 1000;

        manager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME, firstTriggertime, intervalTime, pi);

    }

    public void cancelAlarm(View view) {
        // This method would cancel the running alarm.
        manager.cancel(pi);
    }


    // You want to throw a notification at the user every 20 min or one hour to remind the user of drinking some water
    // You need to use broadcast receiver to process the notification and show it to the user.
}