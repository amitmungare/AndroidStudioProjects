package com.example.permissionsinjava;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView txtnetwork;
    Button btnconnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtnetwork=findViewById(R.id.textView);
        btnconnection = findViewById(R.id.button);

       btnconnection.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               ConnectivityManager cm =(ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
               NetworkInfo netInfo = cm.getActiveNetworkInfo();

               boolean isConnected = netInfo != null && netInfo.isConnected();
               txtnetwork.setText(isConnected ? "CONNECTED" : "DISCONNECTED");
           }
       });

    }
}