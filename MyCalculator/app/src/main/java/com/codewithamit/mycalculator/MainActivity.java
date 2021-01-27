package com.codewithamit.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity<textView, result, sum> extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1= (EditText)findViewById(R.id.num1);
        editText2= (EditText)findViewById(R.id.num2);

        result = (TextView)findViewById(R.id.result);
    }


    public void add(View view) {

        int n1=Integer.parseInt(editText1.getText().toString());
        int n2=Integer.parseInt(editText2.getText().toString());
        int sum=n1+n2;
        result.setText(String.valueOf(sum));
    }

    public void sub(View view) {
        int n1=Integer.parseInt(editText1.getText().toString());
        int n2=Integer.parseInt(editText2.getText().toString());
        int sum=n1-n2;
        result.setText(String.valueOf(sum));
    }

    public void mul(View view) {
        int n1=Integer.parseInt(editText1.getText().toString());
        int n2=Integer.parseInt(editText2.getText().toString());
        int sum=n1*n2;
        result.setText( String.valueOf(sum));
    }

    public void div(View view) {
        int n1=Integer.parseInt(editText1.getText().toString());
        int n2=Integer.parseInt(editText2.getText().toString());
        int sum=n1/n2;
        result.setText(String.valueOf(sum));
    }
}