package com.example.boldi.diceapp;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by MSI GS40 6QE on 27.02.2018.
 */

public class Dice implements Serializable {
    int rollValue = 0;
    String relevantImageId;

    public Dice()
    {
        Random rand = new Random();
        this.rollValue = rand.nextInt(6)+1;

        switch(rollValue) {
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

    public int getNumberOfRolledDots(){
        return this.rollValue;
    }

}
