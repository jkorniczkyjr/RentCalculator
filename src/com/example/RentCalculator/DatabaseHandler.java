package com.example.RentCalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    //All Static Variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "propertyManager";
    // Property Table Name
    private static final String TABLE_PROPERTIES = "properties";
    // Property Table Column Names
    private static final String KEY_ID = "id";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_PURCHASE_PRICE = "purchasePrice";
    private static final String KEY_TERM = "term";
    private static final String KEY_INTEREST = "interest";
    private static final String KEY_DOWN_PAYMENT = "downPayment";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PROPERTY_TABLE = "CREATE TABLE " + TABLE_PROPERTIES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ADDRESS + " TEXT"
                + KEY_PURCHASE_PRICE + " TEXT" + KEY_TERM + " TEXT"
                + KEY_INTEREST + " TEXT" + KEY_DOWN_PAYMENT + " TEXT" + ")";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROPERTIES);

        // Create table again
        onCreate(db);
    }

    // Add new Property
    public void addProperty(Property property) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ADDRESS, property.get_address());
        values.put(KEY_PURCHASE_PRICE, property.get_purchasePrice());
        values.put(KEY_TERM, property.get_term());
        values.put(KEY_INTEREST, property.get_interest());
        values.put(KEY_DOWN_PAYMENT, property.get_downPayment());

        // Insert Row
        db.insert(TABLE_PROPERTIES, null, values);
        db.close();
    }

    // Get Single Property
    public Property getProperty(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PROPERTIES, new String[] { KEY_ID,
                KEY_ADDRESS, KEY_PURCHASE_PRICE, KEY_TERM, KEY_INTEREST,
                KEY_DOWN_PAYMENT }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Property property = new Property(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getInt(2), cursor.getInt(3),
                cursor.getDouble(4), cursor.getInt(5));

        // Return Property
        return property;

    }

    // Get All Properties
    public List<Property> getAllProperties() {
        // Getting All Properties
        List<Property> propertyList = new ArrayList<Property>();

        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_PROPERTIES;

        SQLiteDatabase db  = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Looping through all the rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Property property = new Property();

                property.set_id(Integer.parseInt(cursor.getString(0)));
                property.set_address(cursor.getString(1));
                property.set_purchasePrice(cursor.getInt(2));
                property.set_term(cursor.getInt(3));
                property.set_interest(cursor.getDouble(4));
                property.set_downPayment(cursor.getInt(5));

                propertyList.add(property);
            } while (cursor.moveToNext());
        }
        // Return Property List
        return propertyList;
    }

    // Getting All Properties Count
    public int getPropertiesCount() {
        String countQuery = "SELECT * FROM " + TABLE_PROPERTIES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // Return Count
        return cursor.getCount();
    }

    // Update Single Property
    public int updateProperty(Property property) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ADDRESS, property.get_address());
        values.put(KEY_PURCHASE_PRICE, property.get_purchasePrice());
        values.put(KEY_TERM, property.get_term());
        values.put(KEY_INTEREST, property.get_interest());
        values.put(KEY_DOWN_PAYMENT, property.get_downPayment());

        // Update Row
        return db.update(TABLE_PROPERTIES, values, KEY_ID + "+?",
                new String[] { String.valueOf(property.get_id()) });
    }

    // Delete Single Property
    public void deleteProperty(Property property) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PROPERTIES, KEY_ID + "=?",
                new String[] { String.valueOf(property.get_id()) });
        db.close();
    }
}
