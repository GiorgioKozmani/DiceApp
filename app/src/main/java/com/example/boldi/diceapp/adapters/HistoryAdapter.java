package com.example.boldi.diceapp.adapters;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.boldi.diceapp.R;
import com.example.boldi.diceapp.model.OneRollRoundStorage;

import java.util.ArrayList;

/**
 * Created by miesz on 01.03.2018.
 */

public class HistoryAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<OneRollRoundStorage> RollRoundStorages = new ArrayList<>();
    private LayoutInflater lInflater;

    public HistoryAdapter(Context c, ArrayList<OneRollRoundStorage> rollRoundStorages) {
        mContext = c;
        this.RollRoundStorages = rollRoundStorages;
        lInflater = (LayoutInflater) c
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return RollRoundStorages.size();
    }

    public OneRollRoundStorage getItem(int position) {
        return RollRoundStorages.get(position);
    }


    @Override
    public int getViewTypeCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        return ((RollRoundStorages.get(position).getDrawablesArrayList().size()) -1);
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        int type = getItemViewType(position);
        if (v == null) {
            // Inflate the layout according to the view type
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            switch (type){
                case 0:  v = inflater.inflate(R.layout.list_view_row_dices_1, parent, false);
                break;
                case 1:  v = inflater.inflate(R.layout.list_view_row_dices_2, parent, false);
                break;
                case 2:  v = inflater.inflate(R.layout.list_view_row_dices_3, parent, false);
                break;
                case 3:  v = inflater.inflate(R.layout.list_view_row_dices_4, parent, false);
                break;
                case 4: v = inflater.inflate(R.layout.list_view_row_dices_5, parent, false);
                break;
                case 5:  v = inflater.inflate(R.layout.list_view_row_dices_6, parent, false);
                break;
                default:  v = inflater.inflate(R.layout.list_view_row_dices_1, parent, false);
                break;
            }
        }
        //
        OneRollRoundStorage r = RollRoundStorages.get(position);

        TextView rollDate = (TextView) v.findViewById(R.id.txt_Date);

        switch (type){
            case 0:  ImageView imgDice1_1 = (ImageView) v.findViewById(R.id.imgDice1);
                     imgDice1_1.setImageResource(r.getDrawablesArrayList().get(0));
                break;
            case 1:  ImageView imgDice2_1 = (ImageView) v.findViewById(R.id.imgDice1);
                     imgDice2_1.setImageResource(r.getDrawablesArrayList().get(0));
                ImageView imgDice2_2 = (ImageView) v.findViewById(R.id.imgDice2);
                imgDice2_2.setImageResource(r.getDrawablesArrayList().get(1));
                break;
            case 2:  ImageView imgDice3_1 = (ImageView) v.findViewById(R.id.imgDice1);
                imgDice3_1.setImageResource(r.getDrawablesArrayList().get(0));
                ImageView imgDice3_2 = (ImageView) v.findViewById(R.id.imgDice2);
                imgDice3_2.setImageResource(r.getDrawablesArrayList().get(1));
                ImageView imgDice3_3 = (ImageView) v.findViewById(R.id.imgDice3);
                imgDice3_3.setImageResource(r.getDrawablesArrayList().get(2));
                break;
            case 3:  ImageView imgDice4_1 = (ImageView) v.findViewById(R.id.imgDice1);
                imgDice4_1.setImageResource(r.getDrawablesArrayList().get(0));
                ImageView imgDice4_2 = (ImageView) v.findViewById(R.id.imgDice2);
                imgDice4_2.setImageResource(r.getDrawablesArrayList().get(1));
                ImageView imgDice4_3 = (ImageView) v.findViewById(R.id.imgDice3);
                imgDice4_3.setImageResource(r.getDrawablesArrayList().get(2));
                ImageView imgDice4_4 = (ImageView) v.findViewById(R.id.imgDice4);
                imgDice4_4.setImageResource(r.getDrawablesArrayList().get(3));
                break;
            case 4: ImageView imgDice5_1 = (ImageView) v.findViewById(R.id.imgDice1);
                imgDice5_1.setImageResource(r.getDrawablesArrayList().get(0));
                ImageView imgDice5_2 = (ImageView) v.findViewById(R.id.imgDice2);
                imgDice5_2.setImageResource(r.getDrawablesArrayList().get(1));
                ImageView imgDice5_3 = (ImageView) v.findViewById(R.id.imgDice3);
                imgDice5_3.setImageResource(r.getDrawablesArrayList().get(2));
                ImageView imgDice5_4 = (ImageView) v.findViewById(R.id.imgDice4);
                imgDice5_4.setImageResource(r.getDrawablesArrayList().get(3));
                ImageView imgDice5_5 = (ImageView) v.findViewById(R.id.imgDice5);
                imgDice5_5.setImageResource(r.getDrawablesArrayList().get(4));
                break;
            case 5:  ImageView imgDice6_1 = (ImageView) v.findViewById(R.id.imgDice1);
                imgDice6_1.setImageResource(r.getDrawablesArrayList().get(0));
                ImageView imgDice6_2 = (ImageView) v.findViewById(R.id.imgDice2);
                imgDice6_2.setImageResource(r.getDrawablesArrayList().get(1));
                ImageView imgDice6_3 = (ImageView) v.findViewById(R.id.imgDice3);
                imgDice6_3.setImageResource(r.getDrawablesArrayList().get(2));
                ImageView imgDice6_4 = (ImageView) v.findViewById(R.id.imgDice4);
                imgDice6_4.setImageResource(r.getDrawablesArrayList().get(3));
                ImageView imgDice6_5 = (ImageView) v.findViewById(R.id.imgDice5);
                imgDice6_5.setImageResource(r.getDrawablesArrayList().get(4));
                ImageView imgDice6_6 = (ImageView) v.findViewById(R.id.imgDice6);
                imgDice6_6.setImageResource(r.getDrawablesArrayList().get(5));
                break;
            default:  ImageView imgDiceDefault_1 = (ImageView) v.findViewById(R.id.imgDice1);
                imgDiceDefault_1.setImageResource(r.getDrawablesArrayList().get(0));
                break;
        }

        rollDate.setText(r.getDateString());

        return v;
    }

//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        if (convertView == null) {
//
//            convertView = lInflater.inflate(R.layout.list_view_row, parent, false);
//        }
//
//        OneRollRoundStorage item = getItem(position);
//
//        ((TextView) convertView.findViewById(R.id.textView)).setText(item.getDateString());
//
//
//        for(int i =0;i<item.getDrawablesArrayList().size();i++){
//            ImageView img = new ImageView(mContext);
//            img.setVisibility(View.VISIBLE);
//            img.setImageBitmap(BitmapFactory.decodeResource(mContext.getResources(),item.getDrawablesArrayList().get(i)));
//
//            convertView.addView();
//        }
//
//        return convertView;
//    }

    public void removeItem(int position){
        RollRoundStorages.remove(position);
        notifyDataSetChanged();
    }



}