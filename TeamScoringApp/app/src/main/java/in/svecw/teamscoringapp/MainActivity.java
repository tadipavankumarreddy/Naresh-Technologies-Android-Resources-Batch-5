package in.svecw.teamscoringapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import in.svecw.teamscoringapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);*/
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        if(mainViewModel!=null){
            mainBinding.textView.setText(String.valueOf(mainViewModel.count));
        }
    }

    public void incrementScore(View view) {
        mainViewModel.increment();
        mainBinding.textView.setText(String.valueOf(mainViewModel.count));
    }

    public void decrementScore(View view) {
        mainViewModel.decrement();
        mainBinding.textView.setText(String.valueOf(mainViewModel.count));
    }
}