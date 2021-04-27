package com.teamgolf.minigolfscoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

import static android.view.View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION;

public class ScoreSheetActivity extends AppCompatActivity {

    LayoutInflater inflater;
    RelativeLayout rowTemp;
    Button finishButton;
    EditText scoreInp;
    TableLayout scoresTable;
    TableRow playerNames, row, total;
    TextView player, holeNum, totalScore;

    int numPlayers, numHoles;

    // For player names (key) and their current scores (value)
    Map<String, Integer> playerTotals = new Hashtable<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_sheet);

        //Receive game parameters from previous screen
        Intent receivedIntent = getIntent();
        numPlayers = receivedIntent.getIntExtra("numberOfPlayers", 2);
        numHoles = receivedIntent.getIntExtra("numberOfHoles", 18);

        scoresTable = (TableLayout) findViewById(R.id.scoresTable);
        playerNames = (TableRow) findViewById(R.id.headers);

        total = (TableRow) findViewById(R.id.totals);

        // Dynamically adds rows to table
        for(int i = 1; i <= numHoles; i++){
            inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowTemp = (RelativeLayout) inflater.inflate(R.layout.scoresheet_row, null);
            row = (TableRow) rowTemp.getChildAt(0);

            holeNum = (TextView) row.getChildAt(0);
            holeNum.setText(String.valueOf(i));

            // Hides unneeded player columns
            for(int j = 4; j > numPlayers; j--) {
                scoreInp = (EditText) row.getChildAt(j);
                scoreInp.setVisibility(View.GONE);

                player = (TextView) playerNames.getChildAt(j);
                player.setVisibility(View.GONE);

                totalScore = (TextView) total.getChildAt(j);
                totalScore.setVisibility(View.GONE);
            }

            // Add listener for score calculation
            for(int j = 1; j <= numPlayers; j++) {
                player = (TextView) playerNames.getChildAt(j);
                String name = player.getText().toString();
                playerTotals.put(name, 0);

                scoreInp = (EditText) row.getChildAt(j);
                TextView playerScore = (TextView) total.getChildAt(j);

                scoreInp.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        if(!s.toString().isEmpty()){
                            int score = Integer.parseInt(s.toString());
                            playerTotals.put(name, playerTotals.get(name) - score);
                            playerScore.setText(String.valueOf(playerTotals.get(name)));
                        }
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        if(!s.toString().isEmpty()){
                            int score = Integer.parseInt(s.toString());
                            playerTotals.put(name, playerTotals.get(name) + score);
                            playerScore.setText(String.valueOf(playerTotals.get(name)));
                        }
                    }
                });
            }

            scoresTable.addView(rowTemp, i-1);
        }

        finishButton = (Button) findViewById(R.id.finishButton);

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), WinnerActivity.class);
                intent.putExtra("playerTotals", (Serializable) playerTotals);
                startActivity(intent);
            }
        });
    }

}