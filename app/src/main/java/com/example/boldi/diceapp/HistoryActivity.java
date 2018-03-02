package com.example.boldi.diceapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.boldi.diceapp.adapters.HistoryAdapter;
import com.example.boldi.diceapp.converters.JsonConverters;
import com.example.boldi.diceapp.model.OneRollRoundStorage;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


public class HistoryActivity extends AppCompatActivity {

    Button btn_clear;
    ImageButton  btn_back;
    HistoryAdapter ra;
    ArrayList<OneRollRoundStorage> RollsObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_back = (ImageButton) findViewById(R.id.btn_back);
        // fetch data from sharedprefs and assign it to internal array in order to present in in listview after
        try {
            getSharedPrefArray();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ra = new HistoryAdapter(getApplicationContext(), this.RollsObjects);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(ra);

        btn_clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    ClearSharedPreferencesForRolls();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    finish();
            }
        });
    }

    // ----------------------------------------------------------------------------- SharedPreferences ----------------------------------------------------------------------------------------


    public void ClearSharedPreferencesForRolls() throws JSONException {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
        this.RollsObjects.clear();
        ra.notifyDataSetChanged();
    }

    private void getSharedPrefArray() throws JSONException {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String jArr = preferences.getString("RoundResultsArray", "");
        if(jArr.equals(""))RollsObjects =  new ArrayList<OneRollRoundStorage>();

        JSONArray a = new JSONArray(jArr);
        RollsObjects = JsonConverters.JsonOneRollingRoundStorageArrayToOneRollingRoundStorageArrayList(a);
    }






}
