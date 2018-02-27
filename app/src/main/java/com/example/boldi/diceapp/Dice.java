package com.example.boldi.diceapp;

import java.io.Serializable;

/**
 * Created by MSI GS40 6QE on 27.02.2018.
 */

public class Dice implements Serializable {
    int rollValue;
    String relevantImageId;

    public Dice(int rollResult)
    {
        switch(rollResult) {
            case 1: relevantImageId = "";
            break;
            case 2: relevantImageId = "";
                break;
            case 3: relevantImageId = "";
                break;
            case 4: relevantImageId = "";
                break;
            case 5: relevantImageId = "";
                break;
            case 6: relevantImageId = "";
                break;
            default: relevantImageId = "";
                break;
        }
    }
}
