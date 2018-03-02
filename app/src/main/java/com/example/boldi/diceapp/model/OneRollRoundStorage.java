package com.example.boldi.diceapp.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class OneRollRoundStorage {
    private ArrayList<Integer> ResultsDrawables;
    private long rollingDateLong;

    public OneRollRoundStorage(ArrayList<Integer> resultsDrawables, Date rollingDate)
    {
     this.ResultsDrawables = resultsDrawables;
     this.rollingDateLong =  rollingDate.getTime();
    }

    public OneRollRoundStorage() {}

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
