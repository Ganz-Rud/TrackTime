package com.example.gosha.tracktime;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class BusActivity extends Activity implements AdapterView.OnItemSelectedListener
{
    TextView textView;
    TextView textView2;
    Spinner spinner, spinner1, spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bus_activity);

        //||||||||||||||||||||||||||||||||||||||||||||||||||
        //==================================================
        textView = (TextView) findViewById(R.id.textView2);
        textView2 = (TextView) findViewById(R.id.textView3);
        //==================================================
        //||||||||||||||||||||||||||||||||||||||||||||||||||

        spinner = (Spinner) findViewById(R.id.list_route);
        String selected = spinner.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(),selected,Toast.LENGTH_SHORT).show();

//        spinner1 = (Spinner) findViewById(R.id.station_first);
//        String selected1 = spinner1.getSelectedItem().toString();
//        Toast.makeText(getApplicationContext(),selected1,Toast.LENGTH_SHORT).show();
//
//        spinner2 = (Spinner) findViewById(R.id.station_last);
//        String selected2 = spinner2.getSelectedItem().toString();
//        Toast.makeText(getApplicationContext(),selected2,Toast.LENGTH_SHORT).show();

        ArrayAdapter<?> adapter;

        adapter = ArrayAdapter.createFromResource(this, R.array.avtobus, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<?> adapter1;
        ArrayAdapter<?> adapter2;

//        switch (textView.getText().toString()) { //spinner - стартовая автобусная остановка
//            case "1":
//                adapter1 = ArrayAdapter.createFromResource(this, R.array.bus_1, android.R.layout.simple_spinner_item);
//                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                spinner1.setAdapter(adapter1);
//                spinner1.setOnItemSelectedListener(this);
//                break;
//            case "2":
//                adapter1 = ArrayAdapter.createFromResource(this, R.array.bus_2, android.R.layout.simple_spinner_item);
//                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                spinner1.setAdapter(adapter1);
//                spinner1.setOnItemSelectedListener(this);
//                break;
//        }
//        switch (textView2.getText().toString()) { //spinner - конечная автобусная остановка
//            case "1":
//                adapter2 = ArrayAdapter.createFromResource(this, R.array.bus_1, android.R.layout.simple_spinner_item);
//                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                spinner2.setAdapter(adapter2);
//                spinner2.setOnItemSelectedListener(this);
//                break;
//            case "2":
//                adapter2 = ArrayAdapter.createFromResource(this, R.array.bus_2, android.R.layout.simple_spinner_item);
//                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                spinner2.setAdapter(adapter2);
//                spinner2.setOnItemSelectedListener(this);
//                break;
//        }
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        Object item = parent.getItemAtPosition(pos);
        textView.setText(item.toString());

        spinner1 = (Spinner) findViewById(R.id.station_first);
        String selected1 = spinner1.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(),selected1,Toast.LENGTH_SHORT).show();

        spinner2 = (Spinner) findViewById(R.id.station_last);
        String selected2 = spinner2.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(),selected2,Toast.LENGTH_SHORT).show();

        ArrayAdapter<?> adapter1;
        ArrayAdapter<?> adapter2;

        switch (textView.getText().toString()) { //spinner - стартовая автобусная остановка
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
        switch (textView.getText().toString()) { //spinner - конечная автобусная остановка
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

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
