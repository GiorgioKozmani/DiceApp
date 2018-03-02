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

import com.example.boldi.diceapp.adapters.ImageAdapter;
import com.example.boldi.diceapp.converters.JsonConverters;
import com.example.boldi.diceapp.model.Dice;
import com.example.boldi.diceapp.model.OneRollRoundStorage;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

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

//        final ArrayAdapter<Integer> gridViewDiceDrawableArrayAdapter = new ArrayAdapter<Integer>
//                (this,android.R.layout.simple_list_item_1, RolledDicesDrawables);

        btnBackToMain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), SelectActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });

        btnViewHistory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), HistoryActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
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
                try {
                    storeSharedPrefArray(new OneRollRoundStorage(RolledDicesDrawables, Calendar.getInstance().getTime()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    // ----------------------------------------------------------------------------- SharedPreferences ----------------------------------------------------------------------------------------

    public void storeSharedPrefArray(OneRollRoundStorage currentRoundResult) throws JSONException {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        // get all the preferences (ArrayList<OneRollRoundStorage>)
        ArrayList<OneRollRoundStorage> tempList = getSharedPrefArray();
        // add new OneRollRoundStorage object
        tempList.add(currentRoundResult);
        //now clear whole shared preferences
        editor.clear();
        editor.apply();
        // now add updated list to sharepreferences so at some point we just addred last roll to the list
        String jsonStr = new Gson().toJson(tempList);
        editor.putString("RoundResultsArray",jsonStr);
        editor.commit();
    }

    public ArrayList<OneRollRoundStorage> getSharedPrefArray () throws JSONException {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String sArrayObj = preferences.getString("RoundResultsArray", "");
        if(sArrayObj.equals(""))return new ArrayList<OneRollRoundStorage>();

        JSONArray jArray = new JSONArray(sArrayObj);

        return JsonConverters.JsonOneRollingRoundStorageArrayToOneRollingRoundStorageArrayList(jArray);
    }

    // ----------------------------------------------------------------------------- Randomising animation ----------------------------------------------------------------------------------------
    private int getNotRepeatedRandomDiceNumber() {
            int diceSideToReturnInAnimation = new Dice().getRelevantDrawableImage();
            if(diceSideToReturnInAnimation==this.lastUniqueAnimationDiceDrawable)
            {
                return getNotRepeatedRandomDiceNumber();
            }
            return diceSideToReturnInAnimation;
    }
}
