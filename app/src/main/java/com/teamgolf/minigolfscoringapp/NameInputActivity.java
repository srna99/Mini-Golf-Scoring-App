package com.teamgolf.minigolfscoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.number.UnlocalizedNumberFormatter;
import android.os.Bundle;

public class NameInputActivity extends AppCompatActivity {

    int numPlayers = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_input);

//        Intent receivedIntent = getIntent();
//        numPlayers = receivedIntent.getIntExtra("numberOfPlayers", 2);


        //Dynamically create name input fields, with a default amount of 1
        for(int i=1; i<=numPlayers; i++) {

        }


    }
}