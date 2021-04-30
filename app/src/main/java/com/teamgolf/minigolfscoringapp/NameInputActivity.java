package com.teamgolf.minigolfscoringapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputLayout;

public class NameInputActivity extends AppCompatActivity {


    protected Button continueButton;
    EditText nameInput;
    protected TextInputLayout namesInLayout;
    protected LinearLayout parentLinearLayout;
    protected String[] playerNames;
    protected String currentName;
    int numPlayers, numHoles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name_input);
        parentLinearLayout = (LinearLayout) findViewById(R.id.name_parent_linear_layout);

        Intent receivedIntent = getIntent();
        numPlayers = receivedIntent.getIntExtra("numberOfPlayers", 2);
        numHoles = receivedIntent.getIntExtra("numberOfHoles", 1);

        playerNames = new String[numPlayers];

        addInputFields();

        continueButton = (Button) findViewById(R.id.name_input_continue);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Populate array with player names
                for(int i=0;i<numPlayers;i++) {
                    nameInput = (EditText) findViewById(i+1);

                    if(nameInput.getText().toString().length() > 0) {
                        playerNames[i] = nameInput.getText().toString();
                    } else {
                        playerNames[i] = nameInput.getHint().toString();
                    }
                }
                Intent scoreSheetIntent = new Intent(getBaseContext(), ScoreSheetActivity.class);
                //Pass player names to next screen
                scoreSheetIntent.putExtra("numberOfPlayers", numPlayers);
                scoreSheetIntent.putExtra("numberOfHoles", numHoles);
                scoreSheetIntent.putExtra("namesOfPlayers", playerNames);
                startActivity(scoreSheetIntent);
            }
        });
    }

    //Dynamically create name input fields, with a default amount of 2
    protected void addInputFields() {
        //Manually creating edittexts
        for(int i=1; i<=numPlayers; i++) {
            EditText newInputField = new EditText(this);
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            newInputField.setLayoutParams(p);
            newInputField.setHint("Player " + i);
            newInputField.setId(i);
            newInputField.setMaxLines(1);
            newInputField.setSingleLine();
            newInputField.setImeOptions(EditorInfo.IME_ACTION_DONE);
            newInputField.setTypeface(ResourcesCompat.getFont(this, R.font.fresca));
            newInputField.setTextSize(25);

            //Add input fields before the continue button
            parentLinearLayout.addView(newInputField, parentLinearLayout.getChildCount() - 1);
        }
    }
}