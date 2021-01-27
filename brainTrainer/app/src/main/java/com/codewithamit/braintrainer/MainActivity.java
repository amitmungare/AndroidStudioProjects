package com.codewithamit.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.MediaRouteButton;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    TextView resultTextView;
    TextView pointsTextView;
    Button Button10;
    Button Button11;
    Button Button12;
    Button Button13;
    TextView sumTextView;
    TextView timerTextView;
    Button  playAgainButton;

    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions =0;

    public void playAgain(final View view) {
        score=0;
        numberOfQuestions=0;

        timerTextView.setText("30s");
        pointsTextView.setText("0/0");
        resultTextView.setText("");
        playAgainButton.setVisibility(view.INVISIBLE);

        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {

                timerTextView.setText(String.valueOf(l/1000)+"s");
            }

            @Override
            public void onFinish() {
                playAgainButton.setVisibility(view.VISIBLE);
                timerTextView.setText("0s");
                resultTextView.setText("Your Score: "+Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
            }
        }.start();
    }

    public void generateQuestion(){

        Random rand=new Random();
        int a= rand.nextInt(21);
        int b= rand.nextInt(21);

        sumTextView.setText(Integer.toString(a)+" + "+Integer.toString(b));

        locationOfCorrectAnswer=rand.nextInt(4);

        answers.clear();

        int inCorrectAnswer;

        for(int i=0;i<4;i++){
            if( i==locationOfCorrectAnswer){
                answers.add(a+b);
            }else{
                inCorrectAnswer=rand.nextInt(41);

                while(inCorrectAnswer==a+b){
                    inCorrectAnswer= rand.nextInt(41);
                }
                answers.add(inCorrectAnswer);
            }
        }

        Button10.setText(Integer.toString(answers.get(0)));
        Button11.setText(Integer.toString(answers.get(1)));
        Button12.setText(Integer.toString(answers.get(2)));
        Button13.setText(Integer.toString(answers.get(3)));
    }

    public void chooseAnswer(View view) {
        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
            score++;
            resultTextView.setText("Correct");
        }else{
            resultTextView.setText("Wrong");
        }
        numberOfQuestions++;
        pointsTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        generateQuestion();
    }

    public void start(View view) {
        startButton.setVisibility(View.INVISIBLE);

        playAgain(findViewById(R.id.playAgain));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton=(Button)findViewById(R.id.startButton);
        sumTextView = (TextView)findViewById(R.id.sumTextView);
        Button10 = (Button)findViewById(R.id.button10);
        Button11 = (Button)findViewById(R.id.button11);
        Button12 = (Button)findViewById(R.id.button12);
        Button13 = (Button)findViewById(R.id.button13);
        resultTextView = (TextView)findViewById(R.id.resultTextView);
        pointsTextView = (TextView)findViewById(R.id.pointsTextView);
        timerTextView = (TextView)findViewById(R.id.timerTextView);
        playAgainButton=(Button)findViewById(R.id.playAgain);


    }



}