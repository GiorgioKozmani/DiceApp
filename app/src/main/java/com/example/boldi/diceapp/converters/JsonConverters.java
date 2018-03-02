package com.example.boldi.diceapp.converters;

import com.example.boldi.diceapp.model.OneRollRoundStorage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by miesz on 01.03.2018.
 */

public class JsonConverters {

    // ----------------------------------------------------------------------------- custom converters -----------------------------------------------------------------------------------------

    public static OneRollRoundStorage JsonToOneRollingRoundStorage(JSONObject json) throws JSONException {

        OneRollRoundStorage tempObj = new OneRollRoundStorage();
        JSONObject jOneRollingRoundStorage = json;
        long rollingDateLong = jOneRollingRoundStorage.getLong("rollingDateLong");
        JSONArray jDrawables = jOneRollingRoundStorage.getJSONArray("ResultsDrawables");
        ArrayList<Integer> drawables = JsonIntegerArrayToIntegerArrayList(jDrawables);
        tempObj.setDrawables(drawables);
        tempObj.setRollingDateLong(rollingDateLong);

        return tempObj;
    }

    public static ArrayList<Integer> JsonIntegerArrayToIntegerArrayList(JSONArray jDrawables) throws JSONException {
        ArrayList<Integer> tempList = new ArrayList<>();
        if (jDrawables != null) {
            int len = jDrawables.length();
            for (int i = 0; i < len; i++) {
                tempList.add(jDrawables.getInt(i));
            }
        }
        return tempList;
    }

    public static ArrayList<OneRollRoundStorage> JsonOneRollingRoundStorageArrayToOneRollingRoundStorageArrayList(JSONArray jOneRollingRoundStorages) throws JSONException {
        ArrayList<OneRollRoundStorage> tempList = new ArrayList<>();
        if (jOneRollingRoundStorages != null) {
            int len = jOneRollingRoundStorages.length();
            for (int i = 0; i < len; i++) {
                OneRollRoundStorage tempObj = JsonToOneRollingRoundStorage(jOneRollingRoundStorages.getJSONObject(i));
                tempList.add(tempObj);
            }
        }
        return tempList;
    }


}
