package com.codewithamit.tableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timetableList;

    public void generatetimetable(int timeTable){


        ArrayList<String> timetableContent = new ArrayList<String>();

        for(int i=1;i<=10;i++){
            timetableContent.add(Integer.toString(i *timeTable));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this ,
                android.R.layout.simple_list_item_1,timetableContent);

        timetableList.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final SeekBar timetableSeekbar = (SeekBar)findViewById(R.id.seekBar);
         timetableList =(ListView)findViewById(R.id.listView);

        timetableSeekbar.setMax(20);
        timetableSeekbar.setProgress(10);

        timetableSeekbar.setOnSeekBarChangeListener(new SeekBar .OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timeTable;

                if (i<min){
                    timeTable = min;
                    timetableSeekbar.setProgress(min);
                }else{
                    timeTable = i;
                }

                generatetimetable(timeTable);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        generatetimetable(10);
    }
}