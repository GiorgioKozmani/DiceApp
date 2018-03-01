package com.example.boldi.diceapp;

import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.TextView;

import com.example.boldi.diceapp.model.Dice;
import com.example.boldi.diceapp.model.OneRollingRoundStorage;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;


public class RollActivity extends AppCompatActivity {

    ArrayList<Dice>  RolledDices = new ArrayList<>();
    ArrayList<Integer>  RolledDicesDrawables = new ArrayList<>();
    int lastUniqueAnimationDiceDrawable=0;
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

        new CountDownTimer(numberOfDicesUserChoice*2000, 2000)
        {
            int tickNumber = 1;
            public void onTick(long millisUntilFinished)
            {
                new CountDownTimer(1000, 250)
                {
                    @Override
                    public void onTick(long l) {
                        textView.setText("Dice number "+tickNumber);
                        imageView.setImageResource(getNotRepeatedRandomDiceNumber());
                    }

                    @Override
                    public void onFinish() {
                        Dice rolledDice = new Dice();
                        imageView.setImageResource(rolledDice.getRelevantDrawableImage());
                        RolledDices.add(rolledDice);
                        RolledDicesDrawables.add(rolledDice.getRelevantDrawableImage());
                        //gridViewDiceDrawableArrayAdapter.notifyDataSetChanged();
                        imageAdapter.notifyDataSetChanged();
                        tickNumber++;
                    }
                }.start();

            }

            public void onFinish() {
                textView.setText("Rollings Done!");
                imageView.setImageResource(R.drawable.maindice);
                storeSharedPrefVal(new OneRollingRoundStorage(RolledDicesDrawables, Calendar.getInstance().getTime()));
            }
        }.start();

    }

    public void storeSharedPrefVal(OneRollingRoundStorage obj){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        String jsonStr = new Gson().toJson(obj);
        editor.putString("OneRoundResult",jsonStr);
        editor.commit();
    }

    private int getNotRepeatedRandomDiceNumber() {
            int diceSideToReturnInAnimation = new Dice().getRelevantDrawableImage();
            if(diceSideToReturnInAnimation==this.lastUniqueAnimationDiceDrawable)
            {
                return getNotRepeatedRandomDiceNumber();
            }
            return diceSideToReturnInAnimation;
    }
}
