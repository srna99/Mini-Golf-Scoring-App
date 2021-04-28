package com.teamgolf.minigolfscoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.number.UnlocalizedNumberFormatter;
import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

public class NameInputActivity extends AppCompatActivity {


    EditText nameInput;
    TextInputLayout namesInLayout;

    int numPlayers = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_input);

        nameInput = (EditText) findViewById(R.id.playerName1);
        namesInLayout = (TextInputLayout) findViewById(R.id.nameInputsLayout);

//        Intent receivedIntent = getIntent();
//        numPlayers = receivedIntent.getIntExtra("numberOfPlayers", 2);


        //Dynamically create name input fields, with a default amount of 1
        for(int i=1; i<=numPlayers; i++) {
            //Create new name input with incrementing id

            //Add name input field to text input layout

        }


    }
}