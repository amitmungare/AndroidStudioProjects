package com.codewithamit.meworkapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void orangeclick(View view) {
        Intent i=new Intent(this, orangeact.class);
        startActivity(i);
    }

    public void grapsclick(View view) {
        Log.i("Info", "amit mungare");
        Intent i=new Intent(this, grapsact.class);
        startActivity(i);
    }

    public void appleclick(View view) {
        Intent i=new Intent(this, appleact.class);
        startActivity(i);
    }

    public void mangoclick(View view) {
        Intent i=new Intent(this, mangoact.class);
        startActivity(i);
    }
}