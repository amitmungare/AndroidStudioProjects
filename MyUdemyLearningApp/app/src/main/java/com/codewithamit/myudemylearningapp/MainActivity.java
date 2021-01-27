package com.codewithamit.myudemylearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void converdollertorupeebutton(View view) {

        EditText number=(EditText) findViewById(R.id.editTextNumber);
        Double num = Double.parseDouble(number.getText().toString());
        Double rup=num*74.5;
        Toast.makeText(MainActivity.this,"Rs: "+rup,Toast.LENGTH_SHORT).show();

        TextView rupTextview = (TextView) findViewById(R.id.textView3);
        rupTextview.setText((Double.toString(rup)));
    }
}