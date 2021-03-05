package com.example.minigolfscoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.os.Bundle;
import android.view.KeyEvent;
public  class ScoreSheetActivity extends AppCompatActivity {

    Button finishButton;

    EditText p1Hole1, p1Hole2, p1Hole3, p1Hole4, p1Hole5;
    EditText p2Hole1, p2Hole2, p2Hole3, p2Hole4, p2Hole5;
    TextView p1Total, p2Total;

    String boxEntry;
    int numStrokes;
    int p1FinalTotal = 0;
    int p2FinalTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_sheet);

        p1Hole1 = (EditText) findViewById(R.id.p1h1);
        p1Hole2 = (EditText) findViewById(R.id.p1h2);
        p1Hole3 = (EditText) findViewById(R.id.p1h3);
        p1Hole4 = (EditText) findViewById(R.id.p1h4);
        p1Hole5 = (EditText) findViewById(R.id.p1h5);

        p2Hole1 = (EditText) findViewById(R.id.p2h1);
        p2Hole2 = (EditText) findViewById(R.id.p2h2);
        p2Hole3 = (EditText) findViewById(R.id.p2h3);
        p2Hole4 = (EditText) findViewById(R.id.p2h4);
        p2Hole5 = (EditText) findViewById(R.id.p2h5);

        p1Total = (TextView) findViewById(R.id.player1Total);
        p2Total = (TextView) findViewById(R.id.player2Total);

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

        finishButton = (Button) findViewById(R.id.finishButton);


        //Navigates to next screen
        //TODO: pass scores to final screen through intent
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), WinnerActivity.class);
                startActivity(intent);
            }
        });

    }
}