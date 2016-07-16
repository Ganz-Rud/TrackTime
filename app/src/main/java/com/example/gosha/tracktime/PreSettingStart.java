package com.example.gosha.tracktime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PreSettingStart extends Activity implements AdapterView.OnItemSelectedListener {

    TextView textView1;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_setting_start);
        Intent intent = getIntent();
        int trans = intent.getFlags();

        //-------
        textView1 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        //-------
        TransportHelper helper = new TransportHelper();
        helper.setTransport(trans);

        TextView nameTransport = (TextView) findViewById(R.id.transport);
        nameTransport.setText(helper.getNameTransport());

        Spinner spinner = (Spinner) findViewById(R.id.list_route);
        String selected = spinner.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(),selected,Toast.LENGTH_SHORT).show();

        Spinner spinner1 = (Spinner) findViewById(R.id.station_first);
        String selected1 = spinner1.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(),selected1,Toast.LENGTH_SHORT).show();

        Spinner spinner2 = (Spinner) findViewById(R.id.station_last);
        String selected2 = spinner2.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(),selected2,Toast.LENGTH_SHORT).show();

        ArrayAdapter<?> adapter;
        ArrayAdapter<?> adapter1;
        ArrayAdapter<?> adapter2;
        switch (intent.getFlags())
        {
            case 11111: //вызвано окно автобусов
                adapter = ArrayAdapter.createFromResource(this, R.array.avtobus, android.R.layout.simple_spinner_item );
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(this);

//                switch (textView1.getText().toString()) { //spinner - стартовая автобусная остановка
//                    case "1":
//                        adapter1 = ArrayAdapter.createFromResource(this, R.array.bus_1, android.R.layout.simple_spinner_item);
//                        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                        spinner1.setAdapter(adapter1);
//                        break;
//                    case "2":
//                        adapter1 = ArrayAdapter.createFromResource(this, R.array.bus_2, android.R.layout.simple_spinner_item);
//                        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                        spinner1.setAdapter(adapter1);
//                        break;
//                }
//                switch (textView1.getText().toString()) { //spinner - конечная автобусная остановка
//                    case "1":
//                        adapter2 = ArrayAdapter.createFromResource(this, R.array.bus_1, android.R.layout.simple_spinner_item);
//                        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                        spinner2.setAdapter(adapter2);
//                        break;
//                    case "2":
//                        adapter2 = ArrayAdapter.createFromResource(this, R.array.bus_2, android.R.layout.simple_spinner_item);
//                        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                        spinner2.setAdapter(adapter2);
//                        break;
//                }

                break;
            case 22222: // вызвано окно троллейбусов
                adapter = ArrayAdapter.createFromResource(this, R.array.trolley, android.R.layout.simple_spinner_item );
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(this);
                break;
            case 33333: //вызвано окно трамваев
                adapter = ArrayAdapter.createFromResource(this, R.array.tramv, android.R.layout.simple_spinner_item );
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(this);
                break;
            case 44444://вызвано окно metro
                adapter = ArrayAdapter.createFromResource(this, R.array.metro, android.R.layout.simple_spinner_item );
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(this);
                break;
        }
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        Object item = parent.getItemAtPosition(pos);
        textView1.setText(item.toString());
        textView3.setText(item.toString());

        Spinner spinner1 = (Spinner) findViewById(R.id.station_first);
        String selected1 = spinner1.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(),selected1,Toast.LENGTH_SHORT).show();

        Spinner spinner2 = (Spinner) findViewById(R.id.station_last);
        String selected2 = spinner2.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(),selected2,Toast.LENGTH_SHORT).show();

        ArrayAdapter<?> adapter1;
        ArrayAdapter<?> adapter2;

        switch (textView1.getText().toString()) { //spinner - стартовая автобусная остановка
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
        }
        switch (textView1.getText().toString()) { //spinner - конечная автобусная остановка
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
        }

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Обработка события
    }

}