package com.teamgolf.minigolfscoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SetUpActivity extends AppCompatActivity {
    Button continueButton;
    TextView playersIn, holesIn;
    int numPlayers, numHoles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);

//        setupContinueButton();
        continueButton = findViewById(R.id.continueButton);

        playersIn = findViewById(R.id.playersInput);
        holesIn = findViewById(R.id.holesInput);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scoreSheetIntent = new Intent(getBaseContext(), ScoreSheetActivity.class);

                numPlayers = Integer.parseInt(playersIn.getText().toString());
                numHoles = Integer.parseInt(holesIn.getText().toString());

                scoreSheetIntent.putExtra("numberOfPlayers", numPlayers);
                scoreSheetIntent.putExtra("numberOfHoles", numHoles);

                startActivity(scoreSheetIntent);
            }
        });
    }

    private void setupNumPlayersInput() {

    }

    private void setupNumHolesInput() {

    }

    private void setupContinueButton() {


    }

}//END class