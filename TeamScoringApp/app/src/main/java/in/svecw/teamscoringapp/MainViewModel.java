package in.svecw.teamscoringapp;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    int count;

    public MainViewModel() {
        Log.e("MAIN","View Model is created");
        count = 0;
    }

    // This method is executed when your activity is taken out of memory
    // after onDestroy() method this executes
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.e("MAIN","ViewModel destoryed");
    }

    public void increment(){
        count++;
    }

    public void decrement(){
        count--;
    }
}
