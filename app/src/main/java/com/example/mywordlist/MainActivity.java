package com.example.mywordlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText word, meaning;
    Button insert, view, delete;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        word = findViewById(R.id.word);
        meaning = findViewById(R.id.meaning);
        insert = findViewById(R.id.btnInsert);
        delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        DB = new DBHelper(this);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Wordlist.class));
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wordTXT = word.getText().toString();
                String meaningTXT = meaning.getText().toString();

                Boolean checkinsertdata = DB.insertworddata(wordTXT,meaningTXT);
                if(checkinsertdata == true){
                    Toast.makeText(MainActivity.this,"New Word Inserted : YES", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"New Word Inserted : NO", Toast.LENGTH_LONG).show();
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wordTXT = word.getText().toString();
                String meaningTXT = meaning.getText().toString();
                int checkdeletedata = DB.deleteworddata(wordTXT,meaningTXT);
                if(checkdeletedata > 0){
                    Toast.makeText(MainActivity.this,"Word Delete : YES", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Word Delete : NO", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}