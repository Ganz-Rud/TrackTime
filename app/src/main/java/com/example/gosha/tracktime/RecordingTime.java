package com.example.gosha.tracktime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RecordingTime extends Activity {

    TextView startStation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording_time);

        Intent intent = getIntent();

//        startStation = (TextView) findViewById(R.id.startStation);
//        startStation.setText(intent.getAction());
    }
}
