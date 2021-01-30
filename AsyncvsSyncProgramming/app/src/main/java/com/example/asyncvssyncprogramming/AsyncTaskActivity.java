package com.example.asyncvssyncprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.INotificationSideChannel;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class AsyncTaskActivity extends AppCompatActivity {

    TextView tvcounter;
    Button btnstart;
    Button btnrandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        tvcounter = findViewById(R.id.tvcounter);
        btnstart = findViewById(R.id.btnstart);
        btnrandom = findViewById(R.id.btnrandom);

        btnrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                tvcounter.setText(String.valueOf(r.nextInt(100)));
            }
        });

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountTask ct = new CountTask();
                ct.execute(61);
            }
        });

    }

    class CountTask extends AsyncTask<Integer,Integer,Void> {

        @Override
        protected Void doInBackground(Integer... integers) {

            int n = integers[0];
//            waitNSec(n);

            for(int i=0;i<n;i++){
                wait1sec();
                publishProgress(i);
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            tvcounter.setText(String.valueOf(values[0]));
        }

        void wait1sec(){
            long startTime =System.currentTimeMillis();
            while(System.currentTimeMillis()< startTime+1000);
        }
        void waitNSec(int n){
            for(int i=0; i<n; i++){
                wait1sec();
            }
        }

    }

}