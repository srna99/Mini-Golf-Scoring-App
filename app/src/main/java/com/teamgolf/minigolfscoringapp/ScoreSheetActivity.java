package com.teamgolf.minigolfscoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.view.inputmethod.EditorInfo;
import android.os.Bundle;
import android.view.KeyEvent;

import java.util.Arrays;

public class ScoreSheetActivity extends AppCompatActivity {

    LayoutInflater inflater;
    RelativeLayout rowTemp;
    Button finishButton;

    EditText p1Hole1, p1Hole2, p1Hole3, p1Hole4, p1Hole5;
    EditText p2Hole1, p2Hole2, p2Hole3, p2Hole4, p2Hole5;
    EditText scoreInp;
    TableLayout scoresTable;
    TableRow playerNames, row, total;
    TextView player, holeNum, totalScore, p1Total, p2Total;

    String boxEntry;
    int numStrokes, numPlayers, numHoles;
    int p1FinalTotal = 0;
    int p2FinalTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_sheet);

        //Receive game parameters from previous screen
        Intent receivedIntent = getIntent();
        numPlayers = receivedIntent.getIntExtra("numberOfPlayers", 2);
        numHoles = receivedIntent.getIntExtra("numberOfHoles", 18);

        //tableInit();

        scoresTable = (TableLayout) findViewById(R.id.scoresTable);
        playerNames = (TableRow) findViewById(R.id.headers);

        total = (TableRow) findViewById(R.id.totals);

        for(int i = 4; i > numPlayers; i--) {
            player = (TextView) playerNames.getChildAt(i);
            player.setVisibility(View.GONE);

            totalScore = (TextView) total.getChildAt(i);
            totalScore.setVisibility(View.GONE);
        }

        for(int i = 1; i <= numHoles; i++){
            inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowTemp = (RelativeLayout) inflater.inflate(R.layout.scoresheet_row, null);
            row = (TableRow) rowTemp.getChildAt(0);

            holeNum = (TextView) row.getChildAt(0);
            holeNum.setText(String.valueOf(i));

            for(int j = 4; j > numPlayers; j--) {
                scoreInp = (EditText) row.getChildAt(j);
                scoreInp.setVisibility(View.GONE);
            }

            scoresTable.addView(rowTemp, i);
        }

//        p1Hole1 = (EditText) findViewById(R.id.p1h1);
//        p1Hole2 = (EditText) findViewById(R.id.p1h2);
//        p1Hole3 = (EditText) findViewById(R.id.p1h3);
//        p1Hole4 = (EditText) findViewById(R.id.p1h4);
//        p1Hole5 = (EditText) findViewById(R.id.p1h5);
//
//        p2Hole1 = (EditText) findViewById(R.id.p2h1);
//        p2Hole2 = (EditText) findViewById(R.id.p2h2);
//        p2Hole3 = (EditText) findViewById(R.id.p2h3);
//        p2Hole4 = (EditText) findViewById(R.id.p2h4);
//        p2Hole5 = (EditText) findViewById(R.id.p2h5);
//
//        p1Total = (TextView) findViewById(R.id.p1Total);
//        p2Total = (TextView) findViewById(R.id.p2Total);

//        setupHoleEditors();

        finishButton = (Button) findViewById(R.id.finishButton);

        p1Hole1.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    boxEntry = p1Hole1.getText().toString();
                    numStrokes = Integer.parseInt(boxEntry);
                    p1FinalTotal += numStrokes;
                    p1Total.setText(String.valueOf(p1FinalTotal));
                    p1Hole1.clearFocus();
                }
                return false;
            }
        });
        p1Hole2.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    boxEntry = p1Hole2.getText().toString();
                    numStrokes = Integer.parseInt(boxEntry);
                    p1FinalTotal += numStrokes;
                    p1Total.setText(String.valueOf(p1FinalTotal));
                    p1Hole2.clearFocus();
                }
                return false;
            }
        });
        p1Hole3.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    boxEntry = p1Hole3.getText().toString();
                    numStrokes = Integer.parseInt(boxEntry);
                    p1FinalTotal += numStrokes;
                    p1Total.setText(String.valueOf(p1FinalTotal));
                    p1Hole3.clearFocus();
                }
                return false;
            }
        });
        p1Hole4.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    boxEntry = p1Hole4.getText().toString();
                    numStrokes = Integer.parseInt(boxEntry);
                    p1FinalTotal += numStrokes;
                    p1Total.setText(String.valueOf(p1FinalTotal));
                    p1Hole4.clearFocus();
                }
                return false;
            }
        });
        p1Hole5.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    boxEntry = p1Hole5.getText().toString();
                    numStrokes = Integer.parseInt(boxEntry);
                    p1FinalTotal += numStrokes;
                    p1Total.setText(String.valueOf(p1FinalTotal));
                    p1Hole5.clearFocus();
                }
                return false;
            }
        });
        p2Hole1.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    boxEntry = p2Hole1.getText().toString();
                    numStrokes = Integer.parseInt(boxEntry);
                    p2FinalTotal += numStrokes;
                    p2Total.setText(String.valueOf(p2FinalTotal));
                    p2Hole1.clearFocus();
                }
                return false;
            }
        });

        p2Hole2.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    boxEntry = p2Hole2.getText().toString();
                    numStrokes = Integer.parseInt(boxEntry);
                    p2FinalTotal += numStrokes;
                    p2Total.setText(String.valueOf(p2FinalTotal));
                    p2Hole2.clearFocus();
                }
                return false;
            }
        });
        p2Hole3.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    boxEntry = p2Hole3.getText().toString();
                    numStrokes = Integer.parseInt(boxEntry);
                    p2FinalTotal += numStrokes;
                    p2Total.setText(String.valueOf(p2FinalTotal));
                    p2Hole3.clearFocus();
                }
                return false;
            }
        });
        p2Hole4.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    boxEntry = p2Hole4.getText().toString();
                    numStrokes = Integer.parseInt(boxEntry);
                    p2FinalTotal += numStrokes;
                    p2Total.setText(String.valueOf(p2FinalTotal));
                    p2Hole4.clearFocus();
                }
                return false;
            }
        });
        p2Hole5.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    boxEntry = p2Hole5.getText().toString();
                    numStrokes = Integer.parseInt(boxEntry);
                    p2FinalTotal += numStrokes;
                    p2Total.setText(String.valueOf(p2FinalTotal));
                    p2Hole5.clearFocus();
                }
                return false;
            }
        });

        //Navigates to next screen
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

    // Dynamically create table layout with specified rows and columns
    private void tableInit() {
        //Accept parameters from previous screen



        //Find table layout by id

        //For loop -> rows/cols
        for(int i=1; i < numPlayers; i++) {
            //Initialize table columns
        }

        for(int i=1; i < numHoles; i++) {
            //Initialize table rows
        }

        //Store data in 2-dimensional array
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
//        int[] topScores = new int[3];
//
//        for (int i=0; i<3; i++) {
//            topScores[i] = finalTotals[i];
//        }

        return finalTotals;
    }

}