package com.example.bankingsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    private final String TABLE_NAME = "user_table";
    private final String TABLE_NAME1 = "transfers_table";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "User.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" (PHONENUMBER INTEGER PRIMARY KEY ,NAME TEXT,BALANCE DECIMAL,EMAIL VARCHAR,ACCOUNT_NO VARCHAR,IFSC_CODE VARCHAR)");
        db.execSQL("create table " + TABLE_NAME1 +" (TRANSACTIONID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,FROMNAME TEXT,TONAME TEXT,AMOUNT DECIMAL,STATUS TEXT)");
        db.execSQL("insert into user_table values(8547458474,'Sandy',8000.00,'sandy@gmail.com','XXXXXXXXXXXX1234','ABC09876543')");
        db.execSQL("insert into user_table values(7955486466,'kamal',14000.21,'kamal@gmail.com','XXXXXXXXXXXX2411','BOE154133115')");
        db.execSQL("insert into user_table values(8451213548,'Sanket',350.21,'sanket@gmail.com','XXXXXXXXXXXX2431','BOE154133115')");
        db.execSQL("insert into user_table values(8525534321,'Shubham',4740.21,'shubham@gmail.com','XXXXXXXXXXXX2441','BOE154143115')");
        db.execSQL("insert into user_table values(9847515846,'Sumeet',2400.21,'sumeet@gmail.com','XXXXXXXXXXXX1231','BOB154215415')");
        db.execSQL("insert into user_table values(9958435468,'Ajay',9000.21,'ajay@gmail.com','XXXXXXXXXXXX1431','BOB154215115')");
        db.execSQL("insert into user_table values(9958473843,'Sai',6000.00,'sai@gmail.com','XXXXXXXXXXXX1132','BOB154215115')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
    }

    public Cursor readalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table", null);
        return cursor;
    }

    public Cursor readparticulardata(String phonenumber){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public Cursor readselectuserdata(String phonenumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table except select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public void updateAmount(String phonenumber, String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update user_table set balance = " + amount + " where phonenumber = " +phonenumber);
    }

    public Cursor readtransferdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from transfers_table", null);
        return cursor;
    }

    public boolean insertTransferData(String date,String from_name, String to_name, String amount, String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE", date);
        contentValues.put("FROMNAME", from_name);
        contentValues.put("TONAME", to_name);
        contentValues.put("AMOUNT", amount);
        contentValues.put("STATUS", status);
        long result = db.insert(TABLE_NAME1, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
}

//    private String TABLE_NAME ="user_table";
//    private String TABLE_NAME1 ="transfers_table";
//
//
//    public DataBaseHelper(@Nullable Context context) {
//        super(context,"user.db",null,1);
//    }
//

//
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
//        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
//        onCreate(db);
//    }
//
//    public Cursor readalldata(){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("select * from user_table", null);
//        return cursor;
//    }
//
//    public Cursor readparticulardata(String phonenumber){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("select * from user_table where phonenumber = " +phonenumber, null);
//        return cursor;
//    }
//
//    public Cursor readselectuserdata(String phonenumber) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("select * from user_table except select * from user_table where phonenumber = " +phonenumber, null);
//        return cursor;
//    }
//
//    public void updateAmount(String phonenumber, String amount){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("update user_table set balance = " + amount + " where phonenumber = " +phonenumber);
//    }
//
//    public Cursor readtransferdata(){
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cursor = db.rawQuery("select * from transfers_table", null);
//        return cursor;
//    }
//
//    public boolean insertTransferData(String date,String from_name, String to_name, String amount, String status){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("DATE", date);
//        contentValues.put("FROMNAME", from_name);
//        contentValues.put("TONAME", to_name);
//        contentValues.put("AMOUNT", amount);
//        contentValues.put("STATUS", status);
//        Long result = db.insert(TABLE_NAME1, null, contentValues);
//        if(result == -1){
//            return false;
//        }else{
//            return true;
//        }
//    }
//
////    @Override
////    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
////        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
////        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
////        onCreate(db);
////    }
////
////    public Cursor readAllData()
////    {
////        SQLiteDatabase db=this.getWritableDatabase();
////        Cursor cursor=db.rawQuery("select * from user_table",null);
////        return cursor;
////    }
////
////    public Cursor readparticulardata(String phonenumber){
////        SQLiteDatabase db = this.getWritableDatabase();
////        Cursor cursor = db.rawQuery("select * from user_table where phonenumber = " +phonenumber, null);
////        return cursor;
////    }
//}
