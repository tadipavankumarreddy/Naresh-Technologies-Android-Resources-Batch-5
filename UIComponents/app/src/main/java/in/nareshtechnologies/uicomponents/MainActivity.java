package in.nareshtechnologies.uicomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup biological_sex;
    String sex, languages = "";
    CheckBox tel, hin, eng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        biological_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id = radioGroup.getCheckedRadioButtonId();
                switch (id){
                    case R.id.male:
                        sex = "Male";
                        Toast.makeText(MainActivity.this, sex+" selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.female:
                        sex = "female";
                        Toast.makeText(MainActivity.this, sex+" selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.neither:
                        sex = "Not to say";
                        Toast.makeText(MainActivity.this, sex+" selected", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        tel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    languages += "Telugu  ";
                }
            }
        });

        hin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    languages += "Hindi  ";
                }
            }
        });

        eng.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    languages += "English  ";
                }
            }
        });

    }


    public void showSelections(View view) {
        Toast.makeText(this, languages, Toast.LENGTH_SHORT).show();
    }

    private void initViews() {
        biological_sex = findViewById(R.id.biological_sex);
        tel = findViewById(R.id.tel);
        hin = findViewById(R.id.hin);
        eng = findViewById(R.id.eng);
    }
}

/**
 * EditText -> Take input in Text format from user
 * TextView -> To Display Text data to the user
 * Button -> to raise and event
 * */