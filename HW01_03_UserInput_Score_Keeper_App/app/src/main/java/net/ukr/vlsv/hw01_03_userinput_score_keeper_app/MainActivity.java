package net.ukr.vlsv.hw01_03_userinput_score_keeper_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int pointsTeamA = 0;
    int foulsTeamA = 0;
    int pointsTeamB = 0;
    int foulsTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addPointForTeamA(View v) {
        displayValue((TextView) findViewById(R.id.team_a_points), ++pointsTeamA);
    }

    public void addFoulForTeamA(View v) {
        displayValue((TextView) findViewById(R.id.team_a_fouls), ++foulsTeamA);
    }

    public void addPointForTeamB(View v) {
        displayValue((TextView) findViewById(R.id.team_b_points), ++pointsTeamB);
    }

    public void addFoulForTeamB(View v) {
        displayValue((TextView) findViewById(R.id.team_b_fouls), ++foulsTeamB);
    }

    public void resetScore(View v) {
        pointsTeamA = 0;
        foulsTeamA = 0;
        pointsTeamB = 0;
        foulsTeamB = 0;
        displayValue((TextView) findViewById(R.id.team_a_points), pointsTeamA);
        displayValue((TextView) findViewById(R.id.team_a_fouls), foulsTeamA);
        displayValue((TextView) findViewById(R.id.team_b_points), pointsTeamB);
        displayValue((TextView) findViewById(R.id.team_b_fouls), foulsTeamB);
    }


    public void displayValue(TextView view, int points) {
        view.setText(String.valueOf(points));
    }
}