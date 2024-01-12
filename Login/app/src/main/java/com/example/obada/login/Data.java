package com.example.obada.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class Data extends SQLiteOpenHelper {
    private static final int version=1;
    private static final String name="Users.db";
    public Data(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table IF NOT EXISTS Clent (id INTEGER Primary key ,username TEXT ,password INTEGER,email TEXT,age INTEGER,country TEXT ,type TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
             db.execSQL("Drop table if EXISTS Clent");
             onCreate(db);
    }
    public void insertrow(clent c)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",c.username);
        contentValues.put("password",c.password);
        contentValues.put("email",c.email);
        contentValues.put("age",c.age);
        contentValues.put("country",c.country);
        contentValues.put("type",c.type);
        db.insert("Clent",null,contentValues);

    }
    public ArrayList getdata()
    {
        ArrayList arrayList=new ArrayList();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select*from Clent",null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false)
        {

            arrayList.add(cursor.getString(cursor.getColumnIndex("username")));
            cursor.moveToNext();
        }
        return arrayList;
    }
    public ArrayList getdatapassword()
    {
        ArrayList arrayList=new ArrayList();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select*from Clent",null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false)
        {

            arrayList.add(cursor.getInt(cursor.getColumnIndex("password")));
            cursor.moveToNext();
        }
        return arrayList;
    }
    public ArrayList<clent> getalldata()
    {
        ArrayList <clent>arrayList=new ArrayList<clent>();
        clent c=new clent();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select*from Clent",null);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false)
        {
         c.username =cursor.getString(cursor.getColumnIndex("username"));
         c.country =cursor.getString(cursor.getColumnIndex("country"));
         c.type =cursor.getString(cursor.getColumnIndex("type"));
         c.email =cursor.getString(cursor.getColumnIndex("email"));
         c.password =cursor.getInt(cursor.getColumnIndex("password"));
         c.age =cursor.getInt(cursor.getColumnIndex("age"));
            arrayList.add(c);
            cursor.moveToNext();
        }
        return arrayList;
    }
    public void deleteAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM Clent"); //delete all rows in a table
        db.close();
    }
}
