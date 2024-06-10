package com.example.mywordlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {
        super(context, "Worddata.db" , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
    DB.execSQL("create Table WordTable(word TEXT PRIMARY KEY, meaning TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("Drop Table if exists WordTable");
    }
    public boolean insertworddata(String word, String meaning){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("word", word);
        contentValues.put("meaning", meaning);
        long result = DB.insert("WordTable",null,contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor getdata(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * From WordTable",null);
        return cursor;
    }

    public int deleteworddata(String word,String meaning){
        SQLiteDatabase DB = this.getWritableDatabase();
        int result = DB.delete("WordTable","word",new String[] {word} );
        return result;
    }
}
