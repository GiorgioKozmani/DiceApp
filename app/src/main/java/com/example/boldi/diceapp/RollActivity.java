package com.example.boldi.diceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.content.Intent;

import java.util.ArrayList;


public class RollActivity extends AppCompatActivity {

    ArrayList<Dice>  oneRollDices = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll);
        int userNumberOfDicesChoice = getIntent().getExtras().getInt("numberOfDices");
        doAllTheRolling(userNumberOfDicesChoice);
        testRolling();
    }



    private void doAllTheRolling(int howManyDices)
    {
        for(int i = 0; i < howManyDices; i++){
            oneRollDices.add(new Dice());
        }
    }

    private void testRolling()
    {
        for(int i = 0; i < oneRollDices.size(); i++){
            Log.d("DICE_TEST", "Dice nb "+(i+1)+" rolled "+oneRollDices.get(i).getNumberOfRolledDots());
        }

    }


}
