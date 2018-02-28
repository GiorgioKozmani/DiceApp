package com.example.boldi.diceapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.content.Intent;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class RollActivity extends AppCompatActivity {

    ArrayList<Dice>  oneRollDices = new ArrayList<>();
    int lastRolledNumberForAnimation = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll);
        final ImageView imageView = (ImageView)findViewById(R.id.imageView);
        final TextView textView = (TextView) findViewById(R.id.textView);
        final Button btnViewHistory = (Button)findViewById(R.id.btnSeeHistoryFromRoll);
        final Button btnBackToMain = (Button)findViewById(R.id.btnBackToMainFromRoll);

        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), SelectActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        btnViewHistory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), HistoryActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        new CountDownTimer(2500, 500)
        {

            public void onTick(long millisUntilFinished)
            {
                switch(getNotRepeatedRandomDiceNumber()) {
                    case 1: imageView.setImageResource(R.drawable.dice1);
                        break;
                    case 2: imageView.setImageResource(R.drawable.dice2);
                        break;
                    case 3: imageView.setImageResource(R.drawable.dice3);
                        break;
                    case 4: imageView.setImageResource(R.drawable.dice4);
                        break;
                    case 5: imageView.setImageResource(R.drawable.dice5);
                        break;
                    case 6: imageView.setImageResource(R.drawable.dice6);
                        break;
                    default: imageView.setImageResource(R.drawable.dice1);
                        break;
                }
            }

            public void onFinish() {
                textView.setText("Rolling done!");
                imageView.setImageResource(R.drawable.maindice);
            }
        }.start();

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

    private int getNotRepeatedRandomDiceNumber() {
            int rolledNumber;
            Random rand = new Random();
            rolledNumber = rand.nextInt(6)+1;
            return rolledNumber!=this.lastRolledNumberForAnimation ? rolledNumber : getNotRepeatedRandomDiceNumber();
    }
}
