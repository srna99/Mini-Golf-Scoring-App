package com.teamgolf.minigolfscoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.icu.number.UnlocalizedNumberFormatter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class NameInputActivity extends AppCompatActivity {


    protected Button continueButton;
    EditText nameInput;
    protected TextInputLayout namesInLayout;
    protected LinearLayout parentLinearLayout;

    int numPlayers, numHoles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name_input);
        parentLinearLayout = (LinearLayout) findViewById(R.id.name_parent_linear_layout);

        addInputFields();

//        nameInput = (EditText) findViewById(R.id.playerName1);
//        namesInLayout = (TextInputLayout) findViewById(R.id.nameInputsLayout);

        Intent receivedIntent = getIntent();
        numPlayers = receivedIntent.getIntExtra("numberOfPlayers", 2);
        numHoles = receivedIntent.getIntExtra("numberOfHoles", 1);

        continueButton = (Button) findViewById(R.id.name_input_continue);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scoreSheetIntent = new Intent(getBaseContext(), ScoreSheetActivity.class);
                //Pass player names to next screen
                scoreSheetIntent.putExtra("numberOfPlayers", numPlayers);
                scoreSheetIntent.putExtra("numberOfHoles", numHoles);
                startActivity(scoreSheetIntent);
            }
        });
    }

    //Dynamically create name input fields, with a default amount of 2
    protected void addInputFields() {

        for(int i=2; i<=numPlayers; i++) {
            //Create new name input with incrementing id
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout tempLine = (LinearLayout) inflater.inflate(R.layout.name_input_field, null);
            EditText nextField = (EditText) tempLine.getChildAt(0);
            nextField.setHint("Player " + i);
//            nextField.setId("player_" + i + "_field");
            //Add subsequent fields before submit button
            parentLinearLayout.addView(nextField, parentLinearLayout.getChildCount() - 1);
        }
    }
}