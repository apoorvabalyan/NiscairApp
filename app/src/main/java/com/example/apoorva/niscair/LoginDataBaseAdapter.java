package com.example.apoorva.niscair;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteAbortException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.name;
import static android.provider.Contacts.SettingsColumns.KEY;

/**
 * Created by Apoorva on 7/30/2017.
 */

public class LoginDataBaseAdapter {
    static final String DATABASE_NAME = "Login.db";
    static final int DATABASE_VERSION = 1;
    static final String TABLE_NAME = "LOGIN";
    static final String TABLE_NAME1 = "FORM";
    static final String KEY_ID = "id";
    static final String KEY_EMAIL = "email";
    static final String KEY_PASS = "password";
    //These are variables for the form
    static final String KEY_TITLE = "title";
    static final String KEY_DATES = "dates";
    static final String KEY_NAME = "name";
    static final String KEY_ADDRESS1 = "address1";
    static final String KEY_ADDRESS2 = "address2";
    static final String KEY_ADDRESS3 = "address3";
    static final String KEY_PIN = "pincode";
    static final String KEY_EMAIL_ADDRESS = "email_address";
    static final String KEY_MOBILE = "mobile";
    static final String KEY_TELEPHONE = "telephone";
    static final String KEY_DEGREE1 = "degree1";
    static final String KEY_UNIVERSITY1 = "university1";
    static final String KEY_YEAR1 = "year1";
    static final String KEY_DEGREE2 = "degree2";
    static final String KEY_UNIVERSITY2 = "university2";
    static final String KEY_YEAR2 = "year2";
    static final String KEY_DEGREE3 = "degree3";
    static final String KEY_UNIVERSITY3 = "university3";
    static final String KEY_YEAR3 = "year3";
    static final String KEY_SPONSORING_ADDRESS = "spons_address";
    static final String KEY_PRESENT_DESIGNATION = "designation";
    static final String KEY_PRESENT_PERIOD_OF_SERVICE = "period_of_service";
    static final String KEY_UTR = "utr";
    static final String KEY_DATE = "utr";
    static final String KEY_AMOUNT = "utr";
    static final String KEY_PLACE = "utr";
    static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_EMAIL + " TEXT, " + KEY_PASS
            + " TEXT);";
    static final String DATABASE_CREATE1 = "CREATE TABLE " + TABLE_NAME1 + "(" + KEY_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_TITLE + " TEXT, " + KEY_DATES + " TEXT,"
            + KEY_NAME + " TEXT, " + KEY_ADDRESS1 + " TEXT, " + KEY_ADDRESS2 + " TEXT, " +KEY_ADDRESS3 + " TEXT, " + KEY_PIN + " TEXT, " + KEY_EMAIL_ADDRESS +
            " TEXT, " + KEY_MOBILE + " TEXT, " + KEY_TELEPHONE + " TEXT, " + KEY_DEGREE1 + " TEXT, " + KEY_UNIVERSITY1 + " TEXT, " +
            KEY_YEAR1 + " TEXT, " + KEY_DEGREE2 + " TEXT, " + KEY_UNIVERSITY2 + " TEXT, " +
            KEY_YEAR2 + " TEXT, " + KEY_DEGREE3 + " TEXT, " + KEY_UNIVERSITY3 + " TEXT, " +
            KEY_YEAR3 + " TEXT, "+ KEY_SPONSORING_ADDRESS + " TEXT," + KEY_PRESENT_DESIGNATION + " TEXT, " + KEY_PRESENT_PERIOD_OF_SERVICE +
            " TEXT, " + KEY_UTR + " TEXT, " + KEY_DATE + " TEXT, " + KEY_AMOUNT + " TEXT, " + KEY_PLACE + " TEXT" + "); ";

    //Context of the database
    private final Context context;
    //This creates a instance of database
    public SQLiteDatabase db;
    //Database open/upgrade helper
    private DataBaseHelper dbhelper;

    //This is the constructor of the class
    public LoginDataBaseAdapter(Context _context) {
        context = _context;
        dbhelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //This is the function to open the database to enter the data
    public LoginDataBaseAdapter open() throws SQLiteException
    {
        db = dbhelper.getWritableDatabase();
        return this;
    }

    //This is the function to close the database
    public void close() {
        db.close();
    }

    public void insertEntry(String email, String pass) {
        ContentValues values = new ContentValues();
        //ContentValues are key-value pair,Key will form column-name and value will form the column value
        values.put(KEY_EMAIL, email);
        values.put(KEY_PASS, pass);
        //Inserting row in the table
        db.insert(TABLE_NAME, null, values);
    }
    public void insertEntry1(String title, String dates, String name, String address1, String address2, String address3, String pin, String email_address, String mobile, String telephone
            , String degree1, String university1, String year1, String degree2, String university2, String year2, String degree3, String university3, String year3, String spons_address, String present_designation,String present_service) {
        ContentValues values = new ContentValues();
        //ContentValues are key-value pair,Key will form column-name and value will form the column value
        values.put(KEY_TITLE, title);
        values.put(KEY_DATES, dates);
        values.put(KEY_NAME, name);
        values.put(KEY_ADDRESS1,address1 );
        values.put(KEY_ADDRESS2,address2 );
        values.put(KEY_ADDRESS3,address3 );
        values.put(KEY_PIN, pin);
        values.put(KEY_EMAIL_ADDRESS,email_address );
        values.put(KEY_MOBILE, mobile);
        values.put(KEY_TELEPHONE, telephone);
        values.put(KEY_DEGREE1,degree1 );
        values.put(KEY_UNIVERSITY1,university1 );
        values.put(KEY_YEAR1,year1 );
        values.put(KEY_DEGREE2,degree2 );
        values.put(KEY_UNIVERSITY2,university2 );
        values.put(KEY_YEAR2,year2 );
        values.put(KEY_DEGREE3,degree3 );
        values.put(KEY_UNIVERSITY3,university3 );
        values.put(KEY_YEAR3,year3 );
        values.put(KEY_SPONSORING_ADDRESS, spons_address);
        values.put(KEY_PRESENT_DESIGNATION, present_designation);
        values.put(KEY_PRESENT_PERIOD_OF_SERVICE,present_service );
        //Inserting row in the table
        db.insert(TABLE_NAME1, null, values);
    }
    public void insertEntry2(String utr, String date, String amnt, String place) {
        ContentValues values = new ContentValues();
        //ContentValues are key-value pair,Key will form column-name and value will form the column value
        values.put(KEY_UTR, utr);
        values.put(KEY_DATE, date);
        values.put(KEY_AMOUNT, amnt);
        values.put(KEY_PLACE,place );
        //Inserting row in the table
        db.insert(TABLE_NAME1, null, values);
    }


    public List<formClass> getSingleEntry1(String name, String address) {
        List<formClass> data = new ArrayList<formClass>();
        String[] columns = {

                KEY_ID,
                KEY_TITLE,
                KEY_DATES,
                KEY_NAME,
                KEY_ADDRESS1,
                KEY_ADDRESS2,
                KEY_ADDRESS3,
                KEY_PIN,
                KEY_EMAIL_ADDRESS,
                KEY_MOBILE,
                KEY_TELEPHONE,
                KEY_DEGREE1,
                KEY_UNIVERSITY1,
                KEY_YEAR1,
                KEY_DEGREE2,
                KEY_UNIVERSITY2,
                KEY_YEAR2,
                KEY_DEGREE3,
                KEY_UNIVERSITY3,
                KEY_YEAR3,
                KEY_SPONSORING_ADDRESS,
                KEY_PRESENT_DESIGNATION,
                KEY_PRESENT_PERIOD_OF_SERVICE,
                KEY_UTR,
                KEY_DATE,
                KEY_AMOUNT,
                KEY_PLACE
        };
        Cursor cursor = db.query(TABLE_NAME1,columns,null,null,null,null,null,null);
        int _id = cursor.getInt(cursor.getColumnIndex(KEY_ID));
        String _title = cursor.getString(cursor.getColumnIndex(KEY_TITLE));
        String _dates = cursor.getString(cursor.getColumnIndex(KEY_DATES));
        String _name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
        String _address1 = cursor.getString(cursor.getColumnIndex(KEY_ADDRESS1));
        String _address2 = cursor.getString(cursor.getColumnIndex(KEY_ADDRESS2));
        String _address3 = cursor.getString(cursor.getColumnIndex(KEY_ADDRESS3));
        String __pin = cursor.getString(cursor.getColumnIndex(KEY_PIN));
        String __email_add = cursor.getString(cursor.getColumnIndex(KEY_EMAIL_ADDRESS));
        String __mobile = cursor.getString(cursor.getColumnIndex(KEY_MOBILE));
        String __telephone = cursor.getString(cursor.getColumnIndex(KEY_TELEPHONE));
        String __degree1 = cursor.getString(cursor.getColumnIndex(KEY_DEGREE1));
        String __university1 = cursor.getString(cursor.getColumnIndex(KEY_UNIVERSITY1));
        String __year1 = cursor.getString(cursor.getColumnIndex(KEY_YEAR1));
        String __degree2 = cursor.getString(cursor.getColumnIndex(KEY_DEGREE2));
        String __university2 = cursor.getString(cursor.getColumnIndex(KEY_UNIVERSITY2));
        String __year2 = cursor.getString(cursor.getColumnIndex(KEY_YEAR2));
        String __degree3 = cursor.getString(cursor.getColumnIndex(KEY_DEGREE3));
        String __university3 = cursor.getString(cursor.getColumnIndex(KEY_UNIVERSITY3));
        String __year3 = cursor.getString(cursor.getColumnIndex(KEY_YEAR3));
        String __spons_add = cursor.getString(cursor.getColumnIndex(KEY_SPONSORING_ADDRESS));
        String __pre_desi = cursor.getString(cursor.getColumnIndex(KEY_PRESENT_DESIGNATION));
        String __pre_period = cursor.getString(cursor.getColumnIndex(KEY_PRESENT_PERIOD_OF_SERVICE));
        String __utr = cursor.getString(cursor.getColumnIndex(KEY_UTR));
        String __date = cursor.getString(cursor.getColumnIndex(KEY_DATE));
        String __amnt = cursor.getString(cursor.getColumnIndex(KEY_AMOUNT));
        String __place = cursor.getString(cursor.getColumnIndex(KEY_PLACE));
        cursor.close();
        return data;
    }
    public String getSingleEntry(String email) {
        Cursor cursor = db.query(TABLE_NAME, null, KEY_EMAIL + "=?", new String[]{email}, null, null, null);
        //Username doesnot exist
        if (cursor.getCount() < 1) {
            cursor.close();
            return "Not Exist";
        }
        cursor.moveToFirst();
        String pass = cursor.getString(cursor.getColumnIndex(KEY_PASS));
        cursor.close();
        return pass;
    }


}
