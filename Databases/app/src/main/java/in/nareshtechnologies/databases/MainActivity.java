package in.nareshtechnologies.databases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name_et, age_et; TextView result;

    DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name_et = findViewById(R.id.name_et); age_et = findViewById(R.id.age_et); result = findViewById(R.id.textView);
        helper = new DBHelper(this);
    }

    public void saveData(View view) {
        String name = name_et.getText().toString();
        int age = Integer.parseInt(age_et.getText().toString());

        // The reason why we use content values is to map the table coloumn name with the value you want to update
        // in the row

        ContentValues values = new ContentValues();
        values.put(DBHelper.COL_1,name);
        values.put(DBHelper.COL_2,age);

        /**
         * INSERT INTO STUDENTS(students_name, students_age) VALUES("Pavan", 31);*/

        helper.insertData(values);

        Toast.makeText(this, "Data is inserted Successfully!", Toast.LENGTH_SHORT).show();
    }


    public void loadData(View view) {
        result.setText("");
        Cursor c = helper.getAllData();
        c.moveToFirst();
        do{
            result.append(c.getInt(0)+"\n");
            result.append(c.getString(1)+"\n");
            result.append(c.getInt(2)+"\n\n");
        }while(c.moveToNext());
    }

    /**
     * stu_id | stu_name | stu_age
     * ---------------------------
     * 1    | Pavan      | 30
     * 2    | Krishna    | 32
     *
     * In order to make SQLite transactions easy - We can have a helper cllass
     * that extends to SQLiteOpenHelper
     * */

}
