package com.example.myadditionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    TextView tv1;

    EditText etsearch;
    ImageButton btnsec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 =findViewById(R.id.editText1);
        et2 =findViewById(R.id.editText2);
        tv1 =findViewById(R.id.textView);

        etsearch=findViewById(R.id.editTextsearch);
        btnsec = findViewById(R.id.btnsearch);

    }

    public void btnadd(View view) {

        int num1 = Integer.valueOf(et1.getText().toString());
        int num2 = Integer.valueOf(et2.getText().toString());
        int result= num1+ num2;

        tv1.setText(String.valueOf(result));


        // Go TO Second Activity
        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        i.putExtra("result" , result);
        startActivity(i);


    }

    public void bthSearch(View view) {

        String url = etsearch.getText().toString();
        Uri uri =Uri.parse(url);

        Intent i= new Intent(Intent.ACTION_VIEW, uri);

        try {
            startActivity(i);
        }catch (ActivityNotFoundException anfe){
            Toast.makeText(this, "enter a valid text", Toast.LENGTH_SHORT).show();
        }



    }
}