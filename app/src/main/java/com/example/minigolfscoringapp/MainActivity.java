package com.example.minigolfscoringapp;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText p1Hole1, p1Hole2, p1Hole3, p1Hole4, p1Hole5;
    EditText p2Hole1, p2Hole2, p2Hole3, p2Hole4, p2Hole5;
    TextView p1Total, p2Total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p1Hole1 = (EditText) findViewById(R.id.editTextNumber2);
        p1Hole2 = (EditText) findViewById(R.id.editTextNumber5);
        p1Hole3 = (EditText) findViewById(R.id.editTextNumber6);
        p1Hole4 = (EditText) findViewById(R.id.editTextNumber8);
        p1Hole5 = (EditText) findViewById(R.id.editTextNumber11);

        p2Hole1 = (EditText) findViewById(R.id.editTextNumber3);
        p2Hole2 = (EditText) findViewById(R.id.editTextNumber4);
        p2Hole3 = (EditText) findViewById(R.id.editTextNumber7);
        p2Hole4 = (EditText) findViewById(R.id.editTextNumber9);
        p2Hole5 = (EditText) findViewById(R.id.editTextNumber10);


    }
}

