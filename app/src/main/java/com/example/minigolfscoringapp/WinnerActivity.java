package com.example.minigolfscoringapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;

public class WinnerActivity extends AppCompatActivity {

    int firstScore;
    int secondScore;
    int thirdScore;
    int[] topScores;
    String[] playerNames;
    Button btn_play_again, btn_quit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        Intent intent = getIntent();
        topScores = intent.getIntArrayExtra("topScores");
//        firstScore = intent.getIntExtra("firstScore", 0);
        playerNames = intent.getStringArrayExtra("playerNames");

        updateTopScoreLabels(topScores);

        btn_quit = (Button) findViewById(R.id.quitButton);
        btn_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getBaseContext(), StartActivity.class);
                startActivity(startIntent);
            }
        });
    }

    private void updateTopScoreLabels(int[] topScores) {
        TextView lbl_first_place, lbl_second_place, lbl_third_place, firstPlaceScoreLabel, secondPlaceScoreLabel;

        lbl_first_place = (TextView) findViewById(R.id.firstPlaceName);
        lbl_second_place = (TextView) findViewById(R.id.secondPlaceName);
//        lbl_third_place = (TextView) findViewById(R.id.thirdPlace);

        firstPlaceScoreLabel = (TextView) findViewById(R.id.firstPlaceScore);
        secondPlaceScoreLabel = (TextView) findViewById(R.id.secondPlaceScore);

        lbl_first_place.setText(playerNames[0]);
        lbl_second_place.setText(playerNames[1]);
//        lbl_third_place.setText("Third Place: " + topScores[2]);

        firstPlaceScoreLabel.setText(String.valueOf(topScores[0]));
        secondPlaceScoreLabel.setText(String.valueOf(topScores[1]));

    }
}

