package com.example.apoorva.niscair;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Apoorva on 7/30/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(Context context, String name, CursorFactory factory,int version)
    {
        super(context,name,factory,version);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(LoginDataBaseAdapter.DATABASE_CREATE);
        //             sdedb.execSQL(LoginDataBaseAdapter.DATABASE_CREATE1);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        //This drops the old table
        db.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");
        //This creates a new table
        onCreate(db);
    }
}
