package in.nareshtechnologies.uicomponents2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {

    Spinner spinner;
    SwitchCompat switchCompat;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        switchCompat = findViewById(R.id.switch_btn);
        tv1 = findViewById(R.id.textview1);
        String[] entries = new String[]{"India","Pakistan","Bangladesh","Srilanka","Philippines","Maldivs"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                entries);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
        
        
        switchCompat.setOnCheckedChangeListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // This method works when there is a selection on The spinner
        Toast.makeText(this, adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b){
            tv1.setText("SWitch is on!");
        }else{
            tv1.setText("SWitch is off!");
        }
    }
}