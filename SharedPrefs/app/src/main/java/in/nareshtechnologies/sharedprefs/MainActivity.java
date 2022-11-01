package in.nareshtechnologies.sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name_et, age_et; TextView result;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connecting the views
        name_et = findViewById(R.id.name_et); age_et = findViewById(R.id.age_et); result = findViewById(R.id.textView);
        sharedPreferences = getSharedPreferences("user_details",MODE_PRIVATE);
    }

    public void saveData(View view) {
        // logic for saving data goes here
        String name = name_et.getText().toString();
        int age = Integer.parseInt(age_et.getText().toString());
        // To store data - user Editor interface
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NAME",name);
        editor.putInt("AGE",age);
        editor.apply(); // commit() method also can be called.
    }

    public void loadData(View view) {
        // logic for retrieving data goes here
        if(sharedPreferences!=null && sharedPreferences.contains("NAME")){
            String n = sharedPreferences.getString("NAME","PAVANSSS");
            int a = sharedPreferences.getInt("AGE",0);
            result.setText(n+"\n"+a);
        }
    }
}

// sharedpreferences file can be created using getSharedPreferences(...)
