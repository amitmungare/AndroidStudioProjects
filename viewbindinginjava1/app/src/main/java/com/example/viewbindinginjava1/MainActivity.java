package com.example.viewbindinginjava1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn2;

    EditText et1;
    EditText et2;
    TextView tv1;
    Button btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn2=findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"hello button 2",Toast.LENGTH_SHORT).show();
            }
        });

        btn3.setOnClickListener(this);

        et1 =findViewById(R.id.editTextTextPersonName);
        et2 =findViewById(R.id.editTextTextPersonName2);
        tv1 = findViewById(R.id.textView2);
    }

    public void buttonClicked(View v) {
        Toast.makeText(getApplicationContext(),"hello users",Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(),"hello button 3",Toast.LENGTH_SHORT).show();
    }

    public void btnamit(View view) {
        Toast.makeText(getApplicationContext(),"Amit LogIn",Toast.LENGTH_SHORT).show();
    }

    public void btnadd(View view) {

       int num = Integer.valueOf(et1.getText().toString());
       int num2 = Integer.valueOf(et2.getText().toString());

       int result = num+num2;
       tv1.setText(String.valueOf(result));
    }
}