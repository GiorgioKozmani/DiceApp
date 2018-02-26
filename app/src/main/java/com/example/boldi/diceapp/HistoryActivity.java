package com.example.boldi.diceapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageButton;


public class HistoryActivity extends AppCompatActivity {

    Button btn_clear;
    ImageButton  btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        btn_clear = (Button)findViewById(R.id.btn_clear);
        btn_back = (ImageButton)findViewById(R.id.btn_back);
    }
}
