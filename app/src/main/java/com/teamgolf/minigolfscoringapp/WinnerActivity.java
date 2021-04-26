package com.teamgolf.minigolfscoringapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

public class WinnerActivity extends AppCompatActivity {

    Map<String, Integer> playerTotals = new HashMap<>();
    int[] rankedPlayerScores;
    String[] rankedPlayerNames;

    int playerNum;

    Button playAgainButton, quitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        Intent intent = getIntent();
        playerTotals = (Map<String, Integer>) intent.getSerializableExtra("playerTotals");

        playerNum = playerTotals.size();
        rankedPlayerNames = new String[playerNum];
        rankedPlayerScores = new int[playerNum];

        rankPlayersAndScores();
        updateRankingLabels();

        quitButton = (Button) findViewById(R.id.quitButton);

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getBaseContext(), StartActivity.class);
                startActivity(startIntent);
            }
        });

        playAgainButton = findViewById(R.id.play_againButton);

        playAgainButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                Intent startIntent = new Intent(getBaseContext(), SetUpActivity.class);
                startActivity(startIntent);
           }
        });
    }

    private void rankPlayersAndScores() {
        for(int i = 0; i < playerNum; i++) {
            String minPlayer = "";
            int minScore = -1;

            for(Map.Entry<String, Integer> item : playerTotals.entrySet()) {
                if(item.getValue() <= minScore) {
                    minPlayer = item.getKey();
                    minScore = item.getValue();
                }
            }

            rankedPlayerNames[i] = minPlayer;
            rankedPlayerScores[i] = minScore;

            playerTotals.remove(minPlayer);
        }
    }

    private void updateRankingLabels() {

//        lbl_first_place = (TextView) findViewById(R.id.firstPlaceName);
//        lbl_second_place = (TextView) findViewById(R.id.secondPlaceName);
////        lbl_third_place = (TextView) findViewById(R.id.thirdPlace);
//
//        firstPlaceScoreLabel = (TextView) findViewById(R.id.firstPlaceScore);
//        secondPlaceScoreLabel = (TextView) findViewById(R.id.secondPlaceScore);
//
//        lbl_first_place.setText(playerNames[0]);
//        lbl_second_place.setText(playerNames[1]);
////        lbl_third_place.setText("Third Place: " + topScores[2]);
//
//        firstPlaceScoreLabel.setText(String.valueOf(topScores[0]));
//        secondPlaceScoreLabel.setText(String.valueOf(topScores[1]));

    }
}

