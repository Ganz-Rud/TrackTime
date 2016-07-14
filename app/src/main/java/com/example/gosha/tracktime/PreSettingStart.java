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

        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.avtobus, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }
}