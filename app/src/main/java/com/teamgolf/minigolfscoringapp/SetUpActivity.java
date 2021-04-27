package com.teamgolf.minigolfscoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
                if( numPlayers <1 || numPlayers >4) {
                    playersIn.setError("Please enter a number of players between 1 and 4");
                }
                numHoles = Integer.parseInt(holesIn.getText().toString());
                if( numHoles <1 || numHoles >18) {
                    holesIn.setError("Please enter a number of holes between 1 and 18");
                }
                scoreSheetIntent.putExtra("numberOfPlayers", numPlayers);
                scoreSheetIntent.putExtra("numberOfHoles", numHoles);
                if (numHoles >0 && numHoles <19 && numPlayers >0 && numPlayers < 5) {
                    startActivity(scoreSheetIntent);
                }
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