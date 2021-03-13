package com.example.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.widget.Toast;

public class DemoJob extends JobService {

    @Override
    public boolean onStartJob(JobParameters params) {

        Toast.makeText(this, "job done", Toast.LENGTH_SHORT).show();

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
