package com.lin.celine.moodtracker.controller;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.lin.celine.moodtracker.R;

public class MainActivity extends AppCompatActivity {

//Declarer la classe

    private TextView mTextView;
    final Context context = this;
    private ImageButton mhistory;
    private ImageButton maddnote;
    private ImageButton mhistory1;
    private ImageButton maddnote1;
    private ImageButton mhistory2;
    private ImageButton maddnote2;
    private ImageButton mhistory3;
    private ImageButton maddnote3;
    private ImageButton mhistory4;
    private ImageButton maddnote4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //acceder aux vues


        mhistory = (ImageButton) findViewById(R.id.history);
        maddnote = (ImageButton) findViewById(R.id.addnote);
        mhistory1 = (ImageButton) findViewById(R.id.history1);
        maddnote1 = (ImageButton) findViewById(R.id.addnote1);
        mhistory2 = (ImageButton) findViewById(R.id.history2);
        maddnote2 = (ImageButton) findViewById(R.id.addnote2);
        mhistory3 = (ImageButton) findViewById(R.id.history3);
        maddnote3 = (ImageButton) findViewById(R.id.addnote3);
        mhistory4 = (ImageButton) findViewById(R.id.history4);
        maddnote4 = (ImageButton) findViewById(R.id.addnote4);

        // Ajout des clicks sur les boutons
        mhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent historyIntent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(historyIntent);
            }
        });
        maddnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent promptsIntent = new Intent(MainActivity.this, PopupActivity.class);
                startActivity(promptsIntent);
            }
        });
        mhistory1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent historyIntent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(historyIntent);
            }
        });
        maddnote1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent promptsIntent = new Intent(MainActivity.this, PopupActivity.class);
                startActivity(promptsIntent);
            }
        });
        mhistory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent historyIntent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(historyIntent);
            }
        });
        maddnote2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent promptsIntent = new Intent(MainActivity.this, PopupActivity.class);
                startActivity(promptsIntent);
            }
        });
        mhistory3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent historyIntent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(historyIntent);
            }
        });
        maddnote3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent promptsIntent = new Intent(MainActivity.this, PopupActivity.class);
                startActivity(promptsIntent);
            }
        });
        mhistory4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent historyIntent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(historyIntent);
            }
        });
        maddnote4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent promptsIntent = new Intent(MainActivity.this, PopupActivity.class);
                startActivity(promptsIntent);
            }
        });




    }
}
