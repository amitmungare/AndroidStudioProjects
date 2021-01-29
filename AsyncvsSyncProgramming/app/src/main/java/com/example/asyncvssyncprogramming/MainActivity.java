package com.example.asyncvssyncprogramming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btncolourchange;
    ConstraintLayout clbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncolourchange = findViewById(R.id.btncolourchange);
        clbackground = findViewById(R.id.clbackground);

        btncolourchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Handler h= new Handler();
                Runnable r= new Runnable() {
                    @Override
                    public void run() {
                        waitNSec(1);
                        clbackground.setBackgroundColor(Color.RED);
                    }
                };
                h.postDelayed(r,5000);
            }
        });
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























