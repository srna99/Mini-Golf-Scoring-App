package com.teamgolf.minigolfscoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;

import static android.view.View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION;

public class ScoreSheetActivity extends AppCompatActivity {

    LayoutInflater inflater;
    RelativeLayout rowTemp;
    Button finishButton;

    EditText scoreInp;
    TableLayout scoresTable;
    TableRow playerNames, row, total;
    TextView player, holeNum, totalScore, p1Total, p2Total;

    int numPlayers, numHoles;
    int p1FinalTotal = 0;
    int p2FinalTotal = 0;

    Dictionary<String, Integer> playerTotals = new Hashtable<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_sheet);

        Intent receivedIntent = getIntent();
        numPlayers = receivedIntent.getIntExtra("numberOfPlayers", 2);
        numHoles = receivedIntent.getIntExtra("numberOfHoles", 18);

        scoresTable = (TableLayout) findViewById(R.id.scoresTable);
        playerNames = (TableRow) findViewById(R.id.headers);

        total = (TableRow) findViewById(R.id.totals);

        for(int i = 1; i <= numHoles; i++){
            inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowTemp = (RelativeLayout) inflater.inflate(R.layout.scoresheet_row, null);
            row = (TableRow) rowTemp.getChildAt(0);

            holeNum = (TextView) row.getChildAt(0);
            holeNum.setText(String.valueOf(i));

            for(int j = 4; j > numPlayers; j--) {
                scoreInp = (EditText) row.getChildAt(j);
                scoreInp.setVisibility(View.GONE);

                player = (TextView) playerNames.getChildAt(j);
                player.setVisibility(View.GONE);

                totalScore = (TextView) total.getChildAt(j);
                totalScore.setVisibility(View.GONE);
            }

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

            scoresTable.addView(rowTemp, i);
        }

        finishButton = (Button) findViewById(R.id.finishButton);

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), WinnerActivity.class);

                int winnerScore = Math.min(p1FinalTotal, p2FinalTotal);
                intent.putExtra("firstScore", winnerScore);

                String[] playerNames = new String[2];

                if (p1FinalTotal <= p2FinalTotal){
                    playerNames[0] = "Player 1";
                    playerNames[1] = "Player 2";
                } else {
                    playerNames[0] = "Player 2";
                    playerNames[1] = "Player 1";
                }

                intent.putExtra("playerNames", playerNames);
                intent.putExtra("topScores", getFinalTotals());
                startActivity(intent);
            }
        });

    }

    // iterate over table to grab scores, return top three
    private int[] getFinalTotals() {
        TextView finalScoresTv;

        TableRow finalScores = (TableRow) ((TableLayout) findViewById(R.id.totalScoresTable)).getChildAt(0);
        int[] finalTotals = new int[finalScores.getChildCount()-1]; //or int numPlayers

        for (int i=1; i<finalScores.getChildCount(); i++) {
            finalScoresTv = (TextView) finalScores.getChildAt(i);
            finalTotals[i-1] = Integer.parseInt(finalScoresTv.getText().toString());
        }

        Arrays.sort(finalTotals);

        return finalTotals;
    }

}