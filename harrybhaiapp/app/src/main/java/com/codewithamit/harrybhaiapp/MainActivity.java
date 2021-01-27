package com.codewithamit.harrybhaiapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    public void send(View View){
        Toast.makeText(this, "Sending image...", Toast.LENGTH_SHORT).show();
    }
    public void review(View View){
        Toast.makeText(this, "review image...", Toast.LENGTH_SHORT).show();
    }
    public void delete(View View){
        Toast.makeText(this, "image deleted", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}