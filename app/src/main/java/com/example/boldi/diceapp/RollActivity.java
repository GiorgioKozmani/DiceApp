package com.example.boldi.diceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import java.util.ArrayList;

public class RollActivity extends AppCompatActivity {

    ArrayList<Dice>  oneRollDices = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll);


        Bundle extras = getIntent().getExtras();
        int numbOfDices = extras.getInt("NumberOfDice");
        System.out.println(numbOfDices);

        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.dice1);

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
