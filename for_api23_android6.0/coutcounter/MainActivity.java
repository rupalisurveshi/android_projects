package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0 ;
    int scoreTeamB = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team A and B
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreePointsA(View view){
        scoreTeamA = scoreTeamA + 3 ;
        displayForTeamA(scoreTeamA);
    }

    public void addTwoPointsA(View view){
        scoreTeamA = scoreTeamA + 2 ;
        displayForTeamA(scoreTeamA);
    }

    public void addOnePointsA(View view){
        scoreTeamA = scoreTeamA + 1 ;
        displayForTeamA(scoreTeamA);
    }

    public void addThreePointsB(View view){
        scoreTeamB = scoreTeamB + 3 ;
        displayForTeamB(scoreTeamB);
    }

    public void addTwoPointsB(View view){
        scoreTeamB = scoreTeamB + 2 ;
        displayForTeamB(scoreTeamB);
    }

    public void addOnePointsB(View view){
        scoreTeamB = scoreTeamB + 1 ;
        displayForTeamB(scoreTeamB);
    }

    public void resetAll(View view){
        scoreTeamA = 0 ;
        scoreTeamB = 0 ;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
