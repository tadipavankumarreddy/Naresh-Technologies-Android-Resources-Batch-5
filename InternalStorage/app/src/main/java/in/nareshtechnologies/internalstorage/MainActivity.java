package in.nareshtechnologies.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    EditText name_et, age_et; TextView result;
    // To avoid confusions of the file name -I'm creating a constant here
    public static final String FILE_NAME = "internal_file.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_et = findViewById(R.id.name_et); age_et = findViewById(R.id.age_et); result = findViewById(R.id.textView);

    }

    public void saveData(View view) {
        String name = name_et.getText().toString(); int age = Integer.parseInt(age_et.getText().toString());
        // Want to write data - use FileOutputStream
        FileOutputStream fos;
        try {
            fos = openFileOutput(FILE_NAME,MODE_PRIVATE);
            fos.write(name.getBytes());
            fos.write((""+age).getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadData(View view) {
        FileInputStream fis;
        try {
            fis = openFileInput(FILE_NAME);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            StringBuilder sb = new StringBuilder();
            while((line=br.readLine())!=null){
                sb.append(line+"\n");
            }
            result.setText(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}