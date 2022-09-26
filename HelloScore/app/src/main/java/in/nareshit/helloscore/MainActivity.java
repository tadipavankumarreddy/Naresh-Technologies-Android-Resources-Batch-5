package in.nareshit.helloscore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    TextView r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = findViewById(R.id.result);

        if(savedInstanceState!=null && savedInstanceState.containsKey("KEY")){
            count = savedInstanceState.getInt("KEY");
            r.setText(String.valueOf(count));
        }
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

    // onSaveInstanceState(..) that is useful to save the data for using it later when
    // the activity re-creates...

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // When you put data into a bundle object - always put it in key and value pairs
        // so every entry (Data) will have a key associated with it.
        outState.putInt("KEY",count);
        // You can store as many number of values as would like to
        // you can retrieve the data in onCreate(...) method as onCreate(...) is the firest
        // method that gets invoked as soon as an Activity is launched.
    }

    // How to attach the menu file to the Activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }

    // How to get the options work for us ?
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.first_option:
                Toast.makeText(this, "First", Toast.LENGTH_SHORT).show();
                break;
            case R.id.second_option:
                Toast.makeText(this, "Second", Toast.LENGTH_SHORT).show();
                break;
            case R.id.third_option:
                Toast.makeText(this, "Third", Toast.LENGTH_SHORT).show();
                break;
            case R.id.reset:
                count = 0;
                r.setText(String.valueOf(count));
                break;
        }
        return true;
    }
}