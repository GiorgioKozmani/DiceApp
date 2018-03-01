package com.example.boldi.diceapp.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by miesz on 01.03.2018.
 */

public class OneRollingRoundStorage {
    ArrayList<Integer> ResultsDrawables;
    long rollingDateLong;

    public OneRollingRoundStorage(ArrayList<Integer> resultsDrawables, Date rollingDate)
    {
     this.ResultsDrawables = resultsDrawables;
     this.rollingDateLong =  rollingDate.getTime();
    }

    public OneRollingRoundStorage() {}

    public void setDrawables(ArrayList<Integer> arrayList){
        this.ResultsDrawables = arrayList;
    }

    public void setRollingDateLong(long dateAsLong){
        this.rollingDateLong = dateAsLong;
    }

    public String getDateString(){
        return  new SimpleDateFormat("MM/dd hh:mm").format(new Date(rollingDateLong));
    }

    public ArrayList<Integer> getDrawablesArrayList(){
        return this.ResultsDrawables;
    }
}
