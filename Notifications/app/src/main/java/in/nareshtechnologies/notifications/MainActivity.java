package in.nareshtechnologies.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.style.BulletSpan;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //TODO 1: Create a notification channel for all the versions above API 26
    // TODO 2: Create a notification
    // TODO 3: Issue/Notify the notification with the help of NotificationManager

    NotificationManager manager;
    NotificationChannel channel;
    NotificationCompat.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            channel = new NotificationChannel("channel_id","FIRST CHANNEL",NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel); // Only by calling this you are officially creating a notification channel
        }

        builder = new NotificationCompat.Builder(this,"channel_id");

        // Set the small icon on the notificaiton channel
        builder.setSmallIcon(R.drawable.ic_baseline_add_chart_24);
        //set the title of the notification
        builder.setContentTitle("Sample Title for notification");
        //set the content of the notification
        builder.setContentText("This is some text to disply");
        //set the auto cancel to True
        builder.setAutoCancel(true);
        // Add an action for the notification - when the notification is touched, you should be taken to the main activity again
        // Pending Intent - Description of an action to be performed at a remote place.
        // PendingIntent.getBroastCast(), getActivity(), getService() -> 4 arguments
        PendingIntent pi = PendingIntent.getActivity(this,123,new Intent(this,MainActivity.class),PendingIntent.FLAG_IMMUTABLE);
        // set this pi on notificaiton using setContent Intent method
        builder.setContentIntent(pi);
        // How to show youtube kind of notifications ?
        // First convert the image format from anything to Bitmap.
        Bitmap taj_image = BitmapFactory.decodeResource(getResources(),R.drawable.taj);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(taj_image));
    }


    public void sendNotification(View view) {
        manager.notify(42,builder.build());
    }
}