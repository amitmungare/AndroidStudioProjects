package com.codewithamit.guessnumbergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand=new Random();
        randomNumber=rand.nextInt(10)+1;

    }



    public void guessbutton(View view) {


        EditText num= (EditText) findViewById(R.id.editTextNumber);
        int number=Integer.parseInt(num.getText().toString());

        if(number >10){
            Toast.makeText(MainActivity.this,"Guess a number between 1 to 10", Toast.LENGTH_LONG).show();
        }
        else{

        if(number>randomNumber){
            TextView answer=(TextView) findViewById(R.id.textViewAnswer);
            answer.setText("Guess a Lower number");
        }
        else if (number<randomNumber){
            TextView answer=(TextView) findViewById(R.id.textViewAnswer);
            answer.setText("Guess a Higher number ");
        }
        else{
            TextView answer=(TextView) findViewById(R.id.textViewAnswer);
            answer.setText("You Won "+randomNumber +" Play again");

            Random rand=new Random();
            randomNumber=rand.nextInt(10)+1;
        }

        }


    }

}