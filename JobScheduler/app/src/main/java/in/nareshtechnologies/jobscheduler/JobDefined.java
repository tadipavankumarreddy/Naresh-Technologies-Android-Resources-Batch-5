package in.nareshtechnologies.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

public class JobDefined extends JobService {

    // this method works on Main Thread or UI thread
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Toast.makeText(this, "Job running Successfully!", Toast.LENGTH_SHORT).show();
        return false;
    }

    // this method works on Main Thread or UI thread
    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Toast.makeText(this, "Job cancelled Successfully!", Toast.LENGTH_SHORT).show();
        return false;
    }
}
