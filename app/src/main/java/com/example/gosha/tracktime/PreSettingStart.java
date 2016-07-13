package com.example.gosha.tracktime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

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
    }
}