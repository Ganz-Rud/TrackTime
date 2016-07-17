package com.example.gosha.tracktime;

import android.app.Activity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Spinner;
import android.widget.Toast;

public class BusActivity extends Activity implements AdapterView.OnItemSelectedListener
{
    Spinner spinner, spinner1, spinner2;
    String choiceOfBus;
    Button go, stop, cancel;
    long elapsedMillis;
    int stopCounter;

    Chronometer mChronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        //==============================================================
        spinner = (Spinner) findViewById(R.id.list_route);
        String selected = spinner.getSelectedItem().toString();
        ArrayAdapter<?> adapter;
        adapter = ArrayAdapter.createFromResource(this, R.array.avtobus, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        //===============================================================

        mChronometer = (Chronometer) findViewById(R.id.chronometer);

        mChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                elapsedMillis = SystemClock.elapsedRealtime() -  chronometer.getBase();
                if (elapsedMillis > 5000) {
                    Toast.makeText(getApplicationContext(), "прошло 5 секунд", Toast.LENGTH_SHORT).show();
                }
            }
        });

        go = (Button) findViewById(R.id.startButton);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChronometer.start();
            }
        });

        // по нажатии клавиши стоп записывается в бд данные о поездке и потом вызывается окно с результатом поездки и главное меню
        stop = (Button) findViewById(R.id.stopButton);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChronometer.stop();
                stopCounter = (int) elapsedMillis;

            }
        });
        cancel = (Button)findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChronometer.setBase(SystemClock.elapsedRealtime());
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        Object item = parent.getItemAtPosition(pos);
        choiceOfBus = item.toString();

        spinner1 = (Spinner) findViewById(R.id.station_first);
        String selected1 = spinner1.getSelectedItem().toString();

        spinner2 = (Spinner) findViewById(R.id.station_last);
        String selected2 = spinner2.getSelectedItem().toString();

        ArrayAdapter<?> adapter1;
        ArrayAdapter<?> adapter2;

        switch (choiceOfBus) {
            case "1":
                adapter1 = ArrayAdapter.createFromResource(this, R.array.bus_1, android.R.layout.simple_spinner_item);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(adapter1);
                spinner1.setOnItemSelectedListener(this);
                break;
            case "2":
                adapter1 = ArrayAdapter.createFromResource(this, R.array.bus_2, android.R.layout.simple_spinner_item);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(adapter1);
                spinner1.setOnItemSelectedListener(this);
                break;
            case "12":
                adapter1 = ArrayAdapter.createFromResource(this, R.array.bus_12, android.R.layout.simple_spinner_item);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(adapter1);
                spinner1.setOnItemSelectedListener(this);
                break;
            case "43":
                adapter1 = ArrayAdapter.createFromResource(this, R.array.bus_43, android.R.layout.simple_spinner_item);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(adapter1);
                spinner1.setOnItemSelectedListener(this);
                break;
        }
        switch (choiceOfBus) {
            case "1":
                adapter2 = ArrayAdapter.createFromResource(this, R.array.bus_1, android.R.layout.simple_spinner_item);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(adapter2);
                spinner2.setOnItemSelectedListener(this);
                break;
            case "2":
                adapter2 = ArrayAdapter.createFromResource(this, R.array.bus_2, android.R.layout.simple_spinner_item);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(adapter2);
                spinner2.setOnItemSelectedListener(this);
                break;
            case "12":
                adapter2 = ArrayAdapter.createFromResource(this, R.array.bus_12, android.R.layout.simple_spinner_item);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(adapter2);
                spinner2.setOnItemSelectedListener(this);
                break;
            case "43":
                adapter2 = ArrayAdapter.createFromResource(this, R.array.bus_43, android.R.layout.simple_spinner_item);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(adapter2);
                spinner2.setOnItemSelectedListener(this);
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
