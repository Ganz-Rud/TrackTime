package com.example.gosha.tracktime;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Statistics extends Activity {

    TextView textView;
    ListView listView;
    String message;

    private SQLiteHelper mDatabaseHelper;
    private SQLiteDatabase mSqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);


        mDatabaseHelper = new SQLiteHelper(this, "StationsRoutes.db", null, 1);

        mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = (TextView) findViewById(R.id.statistic_text);
                Cursor cursor = mSqLiteDatabase.query("tableAndroid", new String[]{SQLiteHelper.FIRST_STATION_COLUMN,
                        SQLiteHelper.LAST_STATION_COLUMN, SQLiteHelper.TRAVEL_TIME_COLUMN}, null, null, null, null, null);
                cursor.moveToFirst();
                while (true) {
                    String firstStation = cursor.getString(cursor.getColumnIndex(SQLiteHelper.FIRST_STATION_COLUMN));
                    String lastStation = cursor.getString(cursor.getColumnIndex(SQLiteHelper.LAST_STATION_COLUMN));
                    int time = cursor.getInt(cursor.getColumnIndex(SQLiteHelper.TRAVEL_TIME_COLUMN));

                    message = message + "+++Начальная остановка: " + firstStation + ". Конечная: " + lastStation + ". Время пути: " + time;

                    /////////////////listView = (ListView) findViewById(R.id.listView);
                    if (cursor.isLast()== true){
                        cursor.close();
                        break;
                    }
                    else {
                        cursor.moveToNext();
                    }
                }
                textView.setText(message);
            }
        });
    }
}
