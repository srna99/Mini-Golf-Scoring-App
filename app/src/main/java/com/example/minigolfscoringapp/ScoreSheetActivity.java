package com.example.minigolfscoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ScoreSheetActivity extends AppCompatActivity {
    EditText p1Hole1, p1Hole2, p1Hole3, p1Hole4, p1Hole5;
    EditText p2Hole1, p2Hole2, p2Hole3, p2Hole4, p2Hole5;
    TextView p1Total, p2Total;

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

    }
}