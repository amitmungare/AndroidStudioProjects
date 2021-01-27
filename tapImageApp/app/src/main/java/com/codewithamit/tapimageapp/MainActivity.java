package com.codewithamit.tapimageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void fade(View view) {

        ImageView imgview= (ImageView)findViewById(R.id.imageView);
        ImageView imgview1= (ImageView)findViewById(R.id.imageView2);

        imgview.animate().alpha(0f).setDuration(2000);
        imgview1.animate().alpha(1f).setDuration(2000);
    }
}