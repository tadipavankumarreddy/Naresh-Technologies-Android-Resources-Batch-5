package in.nareshtechnologies.hydrationreminder;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class HydrationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // You need to create a notification Channel
            NotificationChannel channel = new NotificationChannel("channel_id","Hydration Reminder",NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"channel_id");
        builder.setSmallIcon(R.drawable.ic_twotone_water_drop_24);
        builder.setContentTitle("Drink Water!");
        builder.setContentText("Do not get dehydrated!");
        builder.setAutoCancel(true);

        // Notify the Notification (send)
        manager.notify(34,builder.build());
    }
}