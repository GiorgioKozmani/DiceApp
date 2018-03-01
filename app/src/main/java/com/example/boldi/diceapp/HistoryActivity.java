package com.example.boldi.diceapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.boldi.diceapp.model.OneRollingRoundStorage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;


public class HistoryActivity extends AppCompatActivity {

    Button btn_clear;
    ImageButton  btn_back;

    ArrayList<OneRollingRoundStorage> RollsObjects;
    OneRollingRoundStorage test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_back = (ImageButton) findViewById(R.id.btn_back);

        try {
            getSharedPrefVal();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // ----------------------------------------------------------------------------- SharedPreferences ----------------------------------------------------------------------------------------


    private void getSharedPrefVal () throws JSONException {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String sobj = preferences.getString("OneRoundResult", "");
       // if(sobj.equals(""))return new OneRollingRoundStorage(new ArrayList<Integer>(), Calendar.getInstance().getTime());

        JSONObject a = new JSONObject(sobj);
        test = convertJsonToItem(a);
        Log.d("------------------>", "start|"+test.getDateString()+"|end");
       // return convertJsonToItem(a);
    }

    // ----------------------------------------------------------------------------- custom converters -----------------------------------------------------------------------------------------
    private OneRollingRoundStorage convertJsonToItem(JSONObject json) throws JSONException {

            OneRollingRoundStorage tempObj = new OneRollingRoundStorage();
            JSONObject jOneRollingRoundStorage = json;
            long rollingDateLong = jOneRollingRoundStorage.getLong("rollingDateLong");
            JSONArray jDrawables = jOneRollingRoundStorage.getJSONArray("ResultsDrawables");
            ArrayList<Integer> drawables = convertJsonIntegerArrayToIntegerArrayList(jDrawables);
            tempObj.setDrawables(drawables);
            tempObj.setRollingDateLong(rollingDateLong);
            // think it throught     RollsObjects.add(tempObj);

        return tempObj;
    }

    private ArrayList<Integer> convertJsonIntegerArrayToIntegerArrayList(JSONArray jDrawables) throws JSONException {
        ArrayList<Integer> tempList = new ArrayList<>();
        if (jDrawables != null) {
            int len = jDrawables.length();
            for (int i = 0; i < len; i++) {
                tempList.add(jDrawables.getInt(i));
            }
        }
        return tempList;
    }

}
