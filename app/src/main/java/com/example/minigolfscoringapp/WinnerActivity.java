package com.example.minigolfscoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import android.os.Bundle;

public class WinnerActivity extends AppCompatActivity {

    int firstScore;
    int secondScore;
    int thirdScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        Intent intent = getIntent();
        firstScore = intent.getIntExtra("firstScore", 0);
    }
}

