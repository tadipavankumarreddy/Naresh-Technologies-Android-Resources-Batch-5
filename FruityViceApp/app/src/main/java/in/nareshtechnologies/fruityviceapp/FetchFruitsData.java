package in.nareshtechnologies.fruityviceapp;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class FetchFruitsData extends AsyncTask<String,Void,String> {

    TextView ref_result;
    Context context;
    ProgressBar progressBar;

    public FetchFruitsData(TextView ref_result, Context context, ProgressBar progressBar) {
        this.ref_result = ref_result;
        this.context = context;
        this.progressBar = progressBar;
    }

    //This works in the background. once its work is finished it delivers the results to onPostExecute(...) method
    // This method runs in the background thread - (not on Main thread or UI thread)
    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = "";
            StringBuilder sb = new StringBuilder();
            while ((line= br.readLine())!=null){
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // onPostExecute(..) method runs in the mainthread and this method is responsible to populate data on the UI.
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        ref_result.setText(s);
        progressBar.setVisibility(View.INVISIBLE);
    }
}
