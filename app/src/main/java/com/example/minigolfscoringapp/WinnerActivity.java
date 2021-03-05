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
    Button btn_play_again, btn_quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        Intent intent = getIntent();
        firstScore = intent.getIntExtra("firstScore", 0);

        btn_play_again = (Button) findViewById(R.id.playAgainButton);
        btn_play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getBaseContext(), StartActivity.class);
                startActivity(startIntent);
            }
        });

        btn_quit = (Button) findViewById(R.id.quitButton);
        btn_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

