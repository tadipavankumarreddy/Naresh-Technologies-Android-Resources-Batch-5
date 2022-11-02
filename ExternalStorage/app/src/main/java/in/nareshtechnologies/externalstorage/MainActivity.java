package in.nareshtechnologies.externalstorage;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    EditText name_et, age_et; TextView result;
    // for using external storage, you are required to take two permissions from the user

    boolean isAvailable = false, isWritable = false, isReadable = false;

    public static final String FILE_NAME = "external_file.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name_et = findViewById(R.id.name_et); age_et = findViewById(R.id.age_et); result = findViewById(R.id.textView);

        // To check if there is external storage and also check the status of its readability and writability
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            isAvailable = isReadable = isWritable = true;
        }else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            isAvailable = isReadable = true;
        }

        // Take the permission from the user to read and write to the external storage on the users device.
        // Dynamic permissions are introduced from API 23 (Marshmallow)
        // check the os version on which your app is running currently
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            // Now you need to request the permissions to the user
            if(checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }else{
                requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,READ_EXTERNAL_STORAGE},1234);
            }
        }


    }

    public void saveData(View view) {
        String name = name_et.getText().toString();
        int age = Integer.parseInt(age_et.getText().toString());

        // First Create the file in the external storage in your preferred folder
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder,FILE_NAME);
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            fos.write((name+"\n").getBytes());
            fos.write((age+"\n").getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadData(View view) {
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder,FILE_NAME);
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = ""; StringBuilder sb = new StringBuilder();
            while((line = br.readLine())!=null){
                sb.append(line);
            }
            result.setText(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}