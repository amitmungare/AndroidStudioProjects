package com.codewithamit.amitlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnHello:
                System.out.println("Hello");
                break;
            default:
                break;
        }
    }
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        Button btnHello=findViewById(R.id.btnHello);
        btnHello.setOnClickListener(this);

    }
}