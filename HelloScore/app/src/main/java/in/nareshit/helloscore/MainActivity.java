package in.nareshit.helloscore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    TextView r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = findViewById(R.id.result);
    }

    // Thiss method gets invoked as soon as the user clicks on the button
    public void increaseScore(View view) {
        count++;
        r.setText(String.valueOf(count));
    }

    // This method gets invoked as soon as the user clicks on minus button
    public void decreaseScore(View view) {
        count--;
        r.setText(String.valueOf(count));
    }
}