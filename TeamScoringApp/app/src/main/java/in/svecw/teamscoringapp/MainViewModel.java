package in.svecw.teamscoringapp;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    MutableLiveData<Integer> count;

    public MainViewModel() {
        Log.e("MAIN","View Model is created");
        count = new MutableLiveData<>();
        count.setValue(0);
    }

    // This method is executed when your activity is taken out of memory
    // after onDestroy() method this executes
    @Override
    protected void onCleared() {
        super.onCleared();
        Log.e("MAIN","ViewModel destoryed");
    }

    public void increment(){
        count.setValue(count.getValue() + 1);
    }

    public void decrement(){
        count.setValue(count.getValue() - 1);
    }
}
