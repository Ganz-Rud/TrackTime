package com.example.gosha.tracktime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectionActivity extends AppCompatActivity {

    Button bus;
    Button trolley;
    Button tram;
    Button metro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        bus = (Button)  findViewById(R.id.bus);
        trolley = (Button) findViewById(R.id.trolley);
        tram = (Button) findViewById(R.id.tram);
        metro = (Button) findViewById(R.id.metro);

        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

