package in.svecw.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name_et, age_et; TextView result;

    StudentsDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name_et = findViewById(R.id.name_et); age_et = findViewById(R.id.age_et); result = findViewById(R.id.textView);
        database = Room.databaseBuilder(this,StudentsDatabase.class,"Name_here")
                .allowMainThreadQueries()
                .build();

    }

    public void saveData(View view) {
        String n = name_et.getText().toString();
        int a = Integer.parseInt(age_et.getText().toString());
        Students students = new Students(n,a);
        database.stuDao().insertData(students);
        Toast.makeText(this, "Insertion completed", Toast.LENGTH_SHORT).show();
    }

    public void loadData(View view) {
        List<Students> students = database.stuDao().getAllData();
        result.setText("");
        for(Students s : students){
            result.append(s.getS_id()+"\n"+s.getS_name()+"\n"+s.getS_age()+"\n\n");
        }
    }
}