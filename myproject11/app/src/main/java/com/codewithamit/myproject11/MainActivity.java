package com.codewithamit.myproject11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void button(View view){

        TextView txtHello = findViewById(R.id.textView);
        TextView txtHello2 = findViewById(R.id.textView2);
        TextView txtHello3 = findViewById(R.id.textView3);

        EditText editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        EditText editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        EditText editTextTextPersonName3 = findViewById(R.id.editTextTextPersonName3);

        txtHello.setText(editTextTextPersonName.getText().toString());
        txtHello2.setText(editTextTextPersonName2.getText().toString());
        txtHello3.setText(editTextTextPersonName3.getText().toString());

    }
}