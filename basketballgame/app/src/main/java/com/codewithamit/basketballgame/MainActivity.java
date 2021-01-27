package com.codewithamit.basketballgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int score_team_a=0;
    int score_team_b=0;

    private Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(score_team_a);
        displayForTeamA(score_team_b);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void one_point(View v) {
        score_team_a=score_team_a+1;
        displayForTeamA(score_team_a);
    }


    public void two_points(View v) {
        score_team_a=score_team_a+2;
        displayForTeamA(score_team_a);
    }


    public void three_points(View v) {
        score_team_a=score_team_a+3;
        displayForTeamA(score_team_a);
    }


    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score_result);
        scoreView.setText(String.valueOf(score));
    }


    public void one_point_b(View v) {
        score_team_b=score_team_b+1;
        displayForTeamB(score_team_b);
    }


    public void two_points_b(View v) {
        score_team_b=score_team_b+2;
        displayForTeamB(score_team_b);
    }


    public void three_points_b(View v) {
        score_team_b=score_team_b+3;
        displayForTeamB(score_team_b);
    }


    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.textView3);
        scoreView.setText(String.valueOf(score));
    }

    public void reset_score(View v) {
        score_team_a=0;
        score_team_b=0;
        displayForTeamA(score_team_a);
        displayForTeamB(score_team_b);

    }

}
