package com.example.gosha.tracktime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PreSettingStart extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_setting_start);
        Intent intent = getIntent();
        int trans = intent.getFlags();

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

        switch (intent.getFlags())
        {
            case 11111:
                adapter = ArrayAdapter.createFromResource(this, R.array.avtobus, android.R.layout.simple_spinner_item );
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                break;
            case 22222:
                adapter = ArrayAdapter.createFromResource(this, R.array.trolley, android.R.layout.simple_spinner_item );
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                break;
            case 33333:
                adapter = ArrayAdapter.createFromResource(this, R.array.tramv, android.R.layout.simple_spinner_item );
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                break;
            case 44444:
                adapter = ArrayAdapter.createFromResource(this, R.array.metro, android.R.layout.simple_spinner_item );
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                break;
        }
    }
}