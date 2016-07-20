package com.example.gosha.tracktime;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class Statistics extends Activity
{
    Spinner spinner11,spinner12;

    ListView listView;
    String firstStation;
    String lastStation;

    TextView time_sec;
    String number_bus, comment, fStation, lStation;
    int time;
    int counter = 0;
    int secondaryTime = 0;
    private SQLiteHelper mDatabaseHelper;
    private SQLiteDatabase mSqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        //================================================
        //================================================
        spinner11 = (Spinner) findViewById(R.id.spinner_statistic1);
        spinner11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                String[] choose = getResources().getStringArray(R.array.bus_all);
                firstStation = choose[selectedItemPosition];

            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner12 = (Spinner) findViewById(R.id.spinner_statistic2);
        spinner12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                String[] choose = getResources().getStringArray(R.array.bus_all);
                lastStation = choose[selectedItemPosition];
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //================================================
        //================================================


        mDatabaseHelper = new SQLiteHelper(this, "StationsRoutes.db", null, 1);
        mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();
        time_sec = (TextView) findViewById(R.id.second_time);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondaryTime = 0;
                counter = 0;
                listView = (ListView) findViewById(R.id.listView);

                Cursor cursor = mSqLiteDatabase.query("tableAndroid", new String[]{SQLiteHelper.NUMBER_COLUMN,
                        SQLiteHelper.COMMENT_COLUMN, SQLiteHelper.TRAVEL_TIME_COLUMN, SQLiteHelper.FIRST_STATION_COLUMN, SQLiteHelper.LAST_STATION_COLUMN}, null, null, null, null, null);

                cursor.moveToFirst();

                ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(Statistics.this, android.R.layout.simple_list_item_1);

                while (true) {

                    fStation = cursor.getString(cursor.getColumnIndex(SQLiteHelper.FIRST_STATION_COLUMN));
                    lStation = cursor.getString(cursor.getColumnIndex(SQLiteHelper.LAST_STATION_COLUMN));
                    number_bus = cursor.getString(cursor.getColumnIndex(SQLiteHelper.NUMBER_COLUMN));
                    comment = cursor.getString(cursor.getColumnIndex(SQLiteHelper.COMMENT_COLUMN));
                    time = cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TRAVEL_TIME_COLUMN));

                    int hour, min;
                    if (time > 60) {
                        hour = time / 60;
                        min = time % 60;
                    } else {
                        hour = 0;
                        min = time;
                    }

                    if (fStation.equals(firstStation)&&(lStation.equals(lastStation))) {
                    String temporary = "Номер маршрута: " + number_bus + " , время пути: " + hour + ":" + min + "\n" +
                            "комментарий: " + comment;
                        secondaryTime = secondaryTime + time;
                        counter++;
                        adapter3.add(temporary);
                    }
                    if (cursor.isLast() == true) {
                        cursor.close();
                        break;
                    } else {
                        cursor.moveToNext();
                    }
                }
                if (adapter3.isEmpty()){
                    adapter3.add("Нет данных");
                }
                listView.setAdapter(adapter3);
                secondaryTime = secondaryTime/counter;
                String temp = Integer.toString(secondaryTime);
//                int temp = (int) secondaryTime;
                time_sec.setText(temp);
            }
        });
    }
}
