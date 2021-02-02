package com.example.alarms;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

public class alarms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarms);

        Button btnalarm = findViewById(R.id.btnalarm);


        btnalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(getBaseContext(),MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(getBaseContext(),1234,i,PendingIntent.FLAG_ONE_SHOT);

                AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
                am.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime()+6000,pi);

            }
        });

    }
}