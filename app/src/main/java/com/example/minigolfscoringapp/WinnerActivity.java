package com.example.minigolfscoringapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class WinnerActivity extends AppCompatActivity {

    int firstScore;
    int secondScore;
    int thirdScore;
    Button playagain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_winner);
        Intent intent = getIntent();
        firstScore = intent.getIntExtra("firstScore", 0);

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_winner);
        this.playagain = (Button) this.findViewById(R.id.winner);
        this.playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

