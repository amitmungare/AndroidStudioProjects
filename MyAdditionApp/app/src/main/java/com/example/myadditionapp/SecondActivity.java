package com.example.myadditionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvresult  =findViewById(R.id.textView2);

        Intent intent =getIntent();
        int result = intent.getIntExtra("result",0);
        tvresult.setText(String.valueOf(result));

    }
}