package com.codewithamit.mytry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button.setOnClickListener({
                val result = editTextNumber.text.toString().toInt() + editTextNumber2.text.toString().toInt()
                textView.text=result.toString()
        })
        
    }


}