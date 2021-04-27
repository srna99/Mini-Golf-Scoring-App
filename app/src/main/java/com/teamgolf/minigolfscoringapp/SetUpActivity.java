package com.teamgolf.minigolfscoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
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
                if (playersIn.getText() == ""){
                    playersIn.setError("Please enter a number of players between 1 and 4");
                }
                if (TextUtils.isEmpty(holesIn.getText().toString())) {
                    holesIn.setError("Please enter a number of holes between 1 and 18");
                }
                Intent scoreSheetIntent = new Intent(getBaseContext(), ScoreSheetActivity.class);

                numPlayers = Integer.parseInt(playersIn.getText().toString());
                if( numPlayers <1 || numPlayers >4) {
                    playersIn.setError("Please enter a number of players between 1 and 4");
                }

                numHoles = Integer.parseInt(holesIn.getText().toString());
                if( numHoles <1 || numHoles >18) {
                    holesIn.setError("Please enter a number of holes between 1 and 18");
                }


                if (playersIn.getError() == null && holesIn.getError() == null) {
                    scoreSheetIntent.putExtra("numberOfPlayers", numPlayers);
                    scoreSheetIntent.putExtra("numberOfHoles", numHoles);
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