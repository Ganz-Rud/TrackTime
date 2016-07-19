package com.example.gosha.tracktime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class BusActivity extends Activity implements AdapterView.OnItemSelectedListener
{
    Spinner spinner, spinner1, spinner2;
    String choiceOfBus;
    Button go, stop, cancel;
    long elapsedMillis;
    int stopCounter;
    String selected  = "";
    String selected1 = "";
    String selected2 = "";
    String selected3 = "";
    int count;
    private Vibrator vibro;
    Chronometer mChronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        //==============================================================
        spinner = (Spinner) findViewById(R.id.list_route);
        ArrayAdapter<?> adapter;
        adapter = ArrayAdapter.createFromResource(this, R.array.avtobus, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        selected = spinner.getSelectedItem().toString();
        spinner.setEnabled(true);
        //===============================================================
        vibro = (Vibrator)this.getSystemService(VIBRATOR_SERVICE);

        mChronometer = (Chronometer) findViewById(R.id.chronometer);
        mChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                elapsedMillis = SystemClock.elapsedRealtime() -  chronometer.getBase();
                 count = (int) elapsedMillis / 1000;
                if (((count % 30) == 0)&& (count!=0)) {
                    vibro.vibrate(200);
                }
            }
        });

        go = (Button) findViewById(R.id.startButton);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.setEnabled(false);
                spinner1.setEnabled(false);
                spinner2.setEnabled(false);
                mChronometer.setBase(SystemClock.elapsedRealtime());
                mChronometer.start();
            }
        });

        // по нажатии клавиши стоп записывается в бд данные о поездке и потом вызывается окно с результатом поездки и главное меню
        stop = (Button) findViewById(R.id.stopButton);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChronometer.stop();
                stopCounter = (int) elapsedMillis/1000;

                //Intent intent = new Intent(BusActivity.this, ConfirmationActivity.class);
                ArrayList<String> list = new ArrayList<String>();
                list.add(selected1);
                list.add(selected2);
                list.add(selected3);
                list.add("Автобус");

                Bundle bundle = new Bundle();
                bundle.putStringArrayList("EXTRA_DATA", list);

                Intent intent = new Intent(BusActivity.this, ConfirmationActivity.class);
                intent.putExtras(bundle);
                intent.setFlags(stopCounter);

                startActivity(intent);

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

        TextView frequency = (TextView)findViewById(R.id.frequency);

        spinner1 = (Spinner) findViewById(R.id.station_first);
        selected1 = spinner1.getSelectedItem().toString();

        spinner2 = (Spinner) findViewById(R.id.station_last);
        selected2 = spinner2.getSelectedItem().toString();

        ArrayAdapter<?> adapter1;
        ArrayAdapter<?> adapter2;

        switch (choiceOfBus) {
            case "1":
                frequency.setText("Частота хождения: каждые 8 минут");
                selected3 = "1";
                adapter1 = ArrayAdapter.createFromResource(this, R.array.bus_1, android.R.layout.simple_spinner_item);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(adapter1);
                spinner1.setOnItemSelectedListener(this);
                break;
            case "2":
                frequency.setText("Частота хождения: каждые 12 минут");
                selected3 = "2";
                adapter1 = ArrayAdapter.createFromResource(this, R.array.bus_2, android.R.layout.simple_spinner_item);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(adapter1);
                spinner1.setOnItemSelectedListener(this);
                break;
            case "12":
                frequency.setText("Частота хождения: каждые 20 минут");
                selected3 = "12";
                adapter1 = ArrayAdapter.createFromResource(this, R.array.bus_12, android.R.layout.simple_spinner_item);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(adapter1);
                spinner1.setOnItemSelectedListener(this);
                break;
            case "43":
                frequency.setText("Частота хождения: каждые 5 минут");
                selected3 = "43";
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