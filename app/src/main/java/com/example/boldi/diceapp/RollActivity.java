package com.example.boldi.diceapp;

import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.content.Intent;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class RollActivity extends AppCompatActivity {

    ArrayList<Dice>  RolledDices = new ArrayList<>();
    ArrayList<Integer>  RolledDicesDrawables = new ArrayList<>();
    int lastRolledNumberForAnimation = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll);
        int numberOfDicesUserChoice = getIntent().getExtras().getInt("numberOfDices");
        final ImageView imageView = (ImageView)findViewById(R.id.imageView);
        final TextView textView = (TextView) findViewById(R.id.textView);
        final Button btnViewHistory = (Button)findViewById(R.id.btnSeeHistoryFromRoll);
        final Button btnBackToMain = (Button)findViewById(R.id.btnBackToMainFromRoll);
        final GridView gridView = (GridView)findViewById(R.id.gridView);
        final ImageAdapter imageAdapter = new ImageAdapter(getApplicationContext(), RolledDicesDrawables);
        gridView.setAdapter(imageAdapter);
//        final ArrayAdapter<Dice> gridViewDiceArrayAdapter = new ArrayAdapter<Dice>
//                (this,android.R.layout.simple_list_item_1, RolledDices);
        final ArrayAdapter<Integer> gridViewDiceDrawableArrayAdapter = new ArrayAdapter<Integer>
                (this,android.R.layout.simple_list_item_1, RolledDicesDrawables);

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

        new CountDownTimer(numberOfDicesUserChoice*500, 500)
        {

            public void onTick(long millisUntilFinished)
            {
                 Dice rolledDice = new Dice();
                 // change this countdown to smth iterative so i can do like string on the top ROLLING DICE NR I
                 imageView.setImageResource(rolledDice.getRelevantDrawableImage());
                 RolledDices.add(rolledDice);
                 RolledDicesDrawables.add(rolledDice.getRelevantDrawableImage());
                 //gridViewDiceDrawableArrayAdapter.notifyDataSetChanged();

                 imageAdapter.notifyDataSetChanged();
            }

            public void onFinish() {
                textView.setText("Rollings Done!");
                imageView.setImageResource(R.drawable.maindice);
            }
        }.start();


      //  doAllTheRolling(userNumberOfDicesChoice);
       // testRolling();


    }



//    private void doAllTheRolling(int howManyDices)
//    {
//        for(int i = 0; i < howManyDices; i++){
//            RollDices.add(new Dice());
//        }
//    }
//
//    private void testRolling()
//    {
//        for(int i = 0; i < RollDices.size(); i++){
//            Log.d("DICE_TEST", "Dice nb "+(i+1)+" rolled "+RollDices.get(i).getNumberOfRolledDots());
//        }
//
//    }
//
//    private int getNotRepeatedRandomDiceNumber() {
//            int rolledNumber;
//            Random rand = new Random();
//            rolledNumber = rand.nextInt(6)+1;
//            return rolledNumber!=this.lastRolledNumberForAnimation ? rolledNumber : getNotRepeatedRandomDiceNumber();
//    }
}
