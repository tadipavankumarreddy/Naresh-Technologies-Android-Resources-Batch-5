package in.nareshit.explicitintentsex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.person_name);
    }

    public void nextScreen(View view) {
        // TODO 1: We are going to take the user to the
        //  next screen as soon as this button is pressed
        // TODO 2: Create an Intent Object
        String data = editText.getText().toString();
        Intent i = new Intent(this,SecondActivity.class);
        i.putExtra("NAME",data);
        startActivity(i);
    }

    /**
     * Create a seperate activity
     *  1. Right click the app -> new
     *  2. select Activity -> choose any template
     *  3. then a pop up comes up
     *  4. fill the pop up and create the activity.*/
}