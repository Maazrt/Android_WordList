package com.example.mywordlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Wordlist extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> word,meaning;
    DBHelper DB;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wordlist);
        DB = new DBHelper(this);
        word = new ArrayList<>();
        meaning = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new Adapter(this, word, meaning);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();
    }

    private void displaydata() {
        Cursor cursor = DB.getdata();
        if (cursor.getCount() == 0){
            Toast.makeText(Wordlist.this,"NO Entry Exists",Toast.LENGTH_LONG).show();
            return;
        }
        else{
            while (cursor.moveToNext()){
                word.add(cursor.getString(0));
                meaning.add(cursor.getString(1));
            }
        }
    }
}