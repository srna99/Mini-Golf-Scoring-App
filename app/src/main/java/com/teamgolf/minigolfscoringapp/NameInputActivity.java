package com.teamgolf.minigolfscoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.icu.number.UnlocalizedNumberFormatter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class NameInputActivity extends AppCompatActivity {


    EditText nameInput;
    TextInputLayout namesInLayout;
    LinearLayout parentLinearLayout;

    int numPlayers = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_name_input);



//        nameInput = (EditText) findViewById(R.id.playerName1);
//        namesInLayout = (TextInputLayout) findViewById(R.id.nameInputsLayout);

//        Intent receivedIntent = getIntent();
//        numPlayers = receivedIntent.getIntExtra("numberOfPlayers", 2);


    }

    //Dynamically create name input fields, with a default amount of 1
    protected void addInputFields(int n) {
        parentLinearLayout = (LinearLayout) findViewById(R.id.name_parent_linear_layout);

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