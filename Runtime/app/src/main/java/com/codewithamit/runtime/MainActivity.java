package com.codewithamit.runtime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        final Handler handler =new Handler();
        Runnable run =new Runnable() {

            public void run(){
                Log.i("Runnable has run: ","sec must have passed... ");

                        handler.postDelayed(this, 1000);
            }

        };

        handler.post(run);
         */


        new CountDownTimer(10000,1000){
            public void onTick(long  millisecondsUnitsDone){

            Log.i("sec left", String.valueOf(millisecondsUnitsDone/1000));
            }
            public void onFinish(){
                Log.i("Done","Coundown Timer Finished");
            }
        }.start();
    }

}