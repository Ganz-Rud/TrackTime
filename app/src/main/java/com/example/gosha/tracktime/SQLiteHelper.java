package com.example.gosha.tracktime;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by gosha on 13.07.2016.
 */
public class SQLiteHelper extends SQLiteOpenHelper implements BaseColumns{

    //столбцы
    public static final String TRANSPORT_COLUMN     = "transport";
    public static final String NUMBER_COLUMN        = "number";
    public static final String FIRST_STATION_COLUMN = "first_station";
    public static final String LAST_STATION_COLUMN  = "last_station";
    public static final String TRAVEL_TIME_COLUMN   = "travel_time";

    private static final String DATABASE_NAME       = "StationsRoutes.db";
    private static final int DATABASE_VERSION       = 1;

    public static final String DATABASE_TABLE       = "tableAndroid";

    private static final String DATABASE_CREATE_SCRIPT = "create table "
            + DATABASE_TABLE + " (" + BaseColumns._ID
            + " integer primary key autoincrement, " + TRANSPORT_COLUMN
            + " text not null, " + NUMBER_COLUMN + " text not null, " + FIRST_STATION_COLUMN
            + " text not null, " + LAST_STATION_COLUMN + " text not null, " + TRAVEL_TIME_COLUMN + " integer);";

    SQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("SQLite", "Обновляемся с версии " + oldVersion + " на версию " + newVersion);

        // Удаляем старую таблицу и создаём новую
        db.execSQL("DROP TABLE IF IT EXISTS " + DATABASE_TABLE);
        // Создаём новую таблицу
        onCreate(db);
    }
}
