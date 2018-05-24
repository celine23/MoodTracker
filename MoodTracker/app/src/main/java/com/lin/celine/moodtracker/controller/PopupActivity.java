package com.lin.celine.moodtracker.controller;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lin.celine.moodtracker.R;

/**
 * Created by celine on 17/11/2017.
 */

public class PopupActivity extends AppCompatActivity {
    private TextView mTextView;
    private EditText editText;
    final Context context = this;
    private static final int DIALOG_ALERT = 10;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {
        showDialog(DIALOG_ALERT);

        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.activity_popup, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);


        alertDialogBuilder.setView(promptsView);
        final EditText userInput = (EditText) promptsView;
        findViewById(R.id.editText);
        userInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //   mValidate.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        // message
        //Rajouter l'edit text
        alertDialogBuilder
                .setCancelable(true)
                .setPositiveButton("Validate", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        // Si ce bouton est appuyer , quitter
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        // fermer le popup
                        dialog.cancel();

                    }
                });


        // crée alerte dialogue
        AlertDialog alertDialog = alertDialogBuilder.create();

        final class CancelOnClickListener implements
                DialogInterface.OnClickListener {
            public void onClick(DialogInterface dialog, int which) {

            }

        }
        final class OkOnClickListener implements
                DialogInterface.OnClickListener {
            public void onClick(DialogInterface dialog, int which) {
                PopupActivity.this.finish();
            }
        }

        // Montrer
        alertDialog.show();
    }
}