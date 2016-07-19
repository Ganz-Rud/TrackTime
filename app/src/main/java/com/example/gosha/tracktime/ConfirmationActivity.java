package com.example.gosha.tracktime;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ConfirmationActivity extends Activity {

    String first, last, number, transport;
    String comment = " ";
    int time;
    private SQLiteHelper sQlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        ArrayList<String> list = bundle.getStringArrayList("EXTRA_DATA");

        time = intent.getFlags();
        first = list.get(0);
        last = list.get(1);
        number = list.get(2);
        transport = list.get(3);




        Button yes = (Button)findViewById(R.id.yes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = (EditText)findViewById(R.id.editText);
                comment = editText.getText().toString();

                sQlite = new SQLiteHelper(ConfirmationActivity.this,"StationsRoutes.db", null, 1);
                SQLiteDatabase sdb;
                sdb = sQlite.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(SQLiteHelper.FIRST_STATION_COLUMN, first);
                values.put(SQLiteHelper.LAST_STATION_COLUMN, last);
                values.put(SQLiteHelper.TRANSPORT_COLUMN, transport);
                values.put(SQLiteHelper.TRAVEL_TIME_COLUMN, time);
                values.put(SQLiteHelper.NUMBER_COLUMN, number);
                values.put(SQLiteHelper.COMMENT_COLUMN, comment);


                sdb.insert("tableAndroid", null, values);
                Toast.makeText(getApplicationContext(),"Данные успешно добавлены",Toast.LENGTH_SHORT).show();

                Intent intent1 = new Intent(ConfirmationActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });

        Button no = (Button)findViewById(R.id.no);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Ввод данных отменён",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(ConfirmationActivity.this, BusActivity.class);
                startActivity(intent2);
            }
        });
    }
}
