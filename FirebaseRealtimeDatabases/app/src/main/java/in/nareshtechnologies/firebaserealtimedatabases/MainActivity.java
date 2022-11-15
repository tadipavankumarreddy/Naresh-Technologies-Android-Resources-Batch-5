package in.nareshtechnologies.firebaserealtimedatabases;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    DatabaseReference dbr;

    EditText name_et, age_et; TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_et = findViewById(R.id.name_et); age_et = findViewById(R.id.age_et); result = findViewById(R.id.result);
        dbr = FirebaseDatabase.getInstance().getReference("Person");
    }

    public void saveData(View view) {

        String n = name_et.getText().toString();
        int a = Integer.parseInt(age_et.getText().toString());
        Person p = new Person(n,a);
        dbr.push().setValue(p);
        Toast.makeText(this, "Data is inserted Successfully!", Toast.LENGTH_SHORT).show();
    }

    public void loaddata(View view) {
        result.setText("");
        dbr.orderByKey().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){
                    Person p = ds.getValue(Person.class);
                    result.append(p.getName() +"\n"+p.getAge()+"\n\n");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}