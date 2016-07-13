package com.example.gosha.tracktime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectionActivity extends AppCompatActivity {

    Button bus;
    Button trolley;
    Button tram;
    Button metro;

    int busStart    = 11111;
    int trollStart  = 22222;
    int tramStart   = 33333;
    int metroStart  = 44444;
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
                Intent intent = new Intent(SelectionActivity.this, PreSettingStart.class);
                intent.setFlags(busStart);
                startActivity(intent);
            }
        });

        trolley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectionActivity.this, PreSettingStart.class);
                intent.setFlags(trollStart);
                startActivity(intent);
            }
        });

        tram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectionActivity.this, PreSettingStart.class);
                intent.setFlags(tramStart);
                startActivity(intent);
            }
        });

        metro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectionActivity.this, PreSettingStart.class);
                intent.setFlags(metroStart);
                startActivity(intent);
            }
        });
    }
}

