package com.example.boldi.diceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TextView;

public class SelectActivity extends AppCompatActivity {

    ImageButton btn_history;
    Button btn_roll;
    NumberPicker numbPick;
    TextView numbofDices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        btn_history = (ImageButton)findViewById(R.id.btn_history);
        btn_roll = (Button)findViewById(R.id.btn_roll);
        numbPick = (NumberPicker)findViewById(R.id.numbPick);
        setNumbPick();
    }
    public void setNumbPick()
    {
        numbPick.setMaxValue(6);
        if(numbPick.getValue()==1)
        {
            numbofDices.setText("1");

        }else if(numbPick.getValue()==2)
        {
            numbofDices.setText("2");
        }else if(numbPick.getValue()==3)
        {
            numbofDices.setText("3");
        }else if(numbPick.getValue()==4)
        {
            numbofDices.setText("4");
        }else if(numbPick.getValue()==5)
        {
            numbofDices.setText("5");
        }else if (numbPick.getValue()==6)
        {
            numbofDices.setText("6");
        }

    }
}
