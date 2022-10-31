package in.nareshtechnologies.jobscheduler;

import static android.app.job.JobInfo.NETWORK_TYPE_ANY;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.view.View;

import kotlinx.coroutines.Job;

public class MainActivity extends AppCompatActivity {

    JobScheduler scheduler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
    }

    public void scheduleJob(View view) {
        JobInfo.Builder builder = new JobInfo.Builder(124,new ComponentName(getPackageName(), JobDefined.class.getName()));

        builder.setRequiredNetworkType(NETWORK_TYPE_ANY);

        JobInfo jobInfo = builder.build();

        scheduler.schedule(jobInfo);
    }
}


/**
 * AlarmManager works based on Time
 * JobScheduler is more intelligent than AlarmManager
 *  because it works based on conditions
 *
 *  JobScheduler - It schedules or cancels the scheduled tasks
 *  JobInfo - It follows builder pattern to accommodate conditons in it
 *      - setRequiresCharging(true/false)
 *      - setRequiresDeviceIdleState(true/false)
 *      - setPeriodic(int)
 *      - setRequiresNetworkType(NONE,ANY,UNMETERED)
 *  JobService
 *      you need to create a class and extend it to ```JobService```
 *              - onStartJob() -> boolean (Main thread or UI thread)
 *                      true - when the job is offloaded to worker thread
 *                          When the worker thread finishes its task, it has to call  ```jobFinished(...)```
 *                      flase - when the jon is successfully finished
 *              - onStopJob() -> boolean (Main thread or UI Thread)
 *                      true -> when the job rescheduling has to happen
 *                      false -> when there is no need of Job rescheduling
 *              */