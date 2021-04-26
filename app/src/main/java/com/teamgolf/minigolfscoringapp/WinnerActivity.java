package com.teamgolf.minigolfscoringapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class WinnerActivity extends AppCompatActivity {

    Map<String, Integer> playerTotals = new HashMap<>();
    int[] rankedPlayerScores;
    String[] rankedPlayerNames;

    int numPlayers;

    Button playAgainButton, quitButton;
    TableLayout rankingTable;
    TableRow row;
    TextView playerName, playerScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        Intent intent = getIntent();
        playerTotals = (Map<String, Integer>) intent.getSerializableExtra("playerTotals");

        numPlayers = playerTotals.size();
        rankedPlayerNames = new String[numPlayers];
        rankedPlayerScores = new int[numPlayers];

        rankingTable = (TableLayout) findViewById(R.id.rankingTable);

        for(int i = 4; i > numPlayers; i--) {
            row = (TableRow) rankingTable.getChildAt(i-1);
            row.setVisibility(View.GONE);
        }

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
        for(int i = 0; i < numPlayers; i++) {
            String minPlayer = "";
            int minScore = Integer.MAX_VALUE;

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
        for(int i = 0; i < numPlayers; i++) {
            row = (TableRow) rankingTable.getChildAt(i);
            playerName = (TextView) row.getChildAt(1);
            playerScore = (TextView) row.getChildAt(2);

            playerName.setText(rankedPlayerNames[i]);
            playerScore.setText(String.valueOf(rankedPlayerScores[i]));

        }
    }
}

