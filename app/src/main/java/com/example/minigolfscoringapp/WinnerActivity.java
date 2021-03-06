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
    Button btn_play_again, btn_quit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        Intent intent = getIntent();
        topScores = intent.getIntArrayExtra("topScores");
        firstScore = intent.getIntExtra("firstScore", 0);

        updateTopScoreLabels(topScores);

        btn_play_again = (Button) findViewById(R.id.playAgainButton);
        btn_play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getBaseContext(), StartActivity.class);
                startActivity(startIntent);
            }
        });

        btn_quit = (Button) findViewById(R.id.quitButton);
        btn_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void updateTopScoreLabels(int[] topScores) {
        TextView lbl_first_place, lbl_second_place, lbl_third_place;

        lbl_first_place = (TextView) findViewById(R.id.firstPlace);
        lbl_second_place = (TextView) findViewById(R.id.secondPlace);
        lbl_third_place = (TextView) findViewById(R.id.thirdPlace);

        lbl_first_place.setText("First Place: " + topScores[0]);
        lbl_second_place.setText("Second Place: " + topScores[1]);
        lbl_third_place.setText("Third Place: " + topScores[2]);

    }
}

