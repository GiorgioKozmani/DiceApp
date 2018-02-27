package com.example.boldi.diceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class RollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll);

        Bundle extras = getIntent().getExtras();
        int numbOfDices = extras.getInt("NumberOfDice");
        System.out.println(numbOfDices);

        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.dice1);



    }
}
