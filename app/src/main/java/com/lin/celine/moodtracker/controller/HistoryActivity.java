package com.lin.celine.moodtracker.controller;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.annotation.TransitionRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lin.celine.moodtracker.R;
import com.lin.celine.moodtracker.model.Mood;
import com.lin.celine.moodtracker.model.MoodEntry;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.lin.celine.moodtracker.R.layout.mood;
import static com.lin.celine.moodtracker.model.Mood.BAD;
import static com.lin.celine.moodtracker.model.Mood.GOOD;
import static com.lin.celine.moodtracker.model.Mood.GREAT;
import static com.lin.celine.moodtracker.model.Mood.NORMAL;
import static com.lin.celine.moodtracker.model.Mood.REALLY_BAD;

public class HistoryActivity extends AppCompatActivity {

    private TextView mTextView;
    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;
    private TextView mTextView4;
    private TextView mTextView5;
    private TextView mTextView6;
    private ImageButton mImageButton;
    private ImageButton mImageButton1;
    private ImageButton mImageButton2;
    private ImageButton mImageButton3;
    private ImageButton mImageButton4;
    private ImageButton mImageButton5;
    private ImageButton mImageButton6;
    public RelativeLayout mSeven;
    public RelativeLayout mSix;
    public RelativeLayout mFive;
    public RelativeLayout mFour;
    public RelativeLayout mThree;
    public RelativeLayout mTwo;
    public RelativeLayout mOne;
    public LinearLayout layout;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        //identifiant
        mImageButton = (ImageButton) findViewById(R.id.imageButton);
        mImageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        mImageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        mImageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        mImageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        mImageButton5 = (ImageButton) findViewById(R.id.imageButton5);
        mImageButton6 = (ImageButton) findViewById(R.id.imageButton6);
        mTextView = (TextView) findViewById(R.id.textView);
        mTextView1 = (TextView) findViewById(R.id.textView1);
        mTextView2 = (TextView) findViewById(R.id.textView2);
        mTextView3 = (TextView) findViewById(R.id.textView3);
        mTextView4 = (TextView) findViewById(R.id.textView4);
        mTextView5 = (TextView) findViewById(R.id.textView5);
        mTextView6 = (TextView) findViewById(R.id.textView6);
        mSeven = (RelativeLayout) findViewById(R.id.seven);
        mSix = (RelativeLayout) findViewById(R.id.six);
        mFive = (RelativeLayout) findViewById(R.id.five);
        mFour = (RelativeLayout) findViewById(R.id.four);
        mThree = (RelativeLayout) findViewById(R.id.three);
        mTwo = (RelativeLayout) findViewById(R.id.two);
        mOne = (RelativeLayout) findViewById(R.id.one);
        layout = (LinearLayout) findViewById(R.id.linear);

        //crée les nouveau moodEntry
        MoodEntry moodEntry1 = new MoodEntry();
        MoodEntry moodEntry2 = new MoodEntry();
        MoodEntry moodEntry3 = new MoodEntry();
        MoodEntry moodEntry4 = new MoodEntry();
        MoodEntry moodEntry5 = new MoodEntry();

        //nommer
        moodEntry1.setMood(GREAT);
        moodEntry2.setMood(GOOD);
        moodEntry3.setMood(NORMAL);
        moodEntry4.setMood(BAD);
        moodEntry5.setMood(REALLY_BAD);

        displayMood(moodEntry1.getMood(), mOne);
        displayMood(moodEntry2.getMood(), mTwo);
        displayMood(moodEntry3.getMood(), mThree);
        displayMood(moodEntry4.getMood(), mFour);
        displayMood(moodEntry5.getMood(), mFive);

    }

    //switch pour définir les couleurs et la largueur du layout selon le mood
    private void displayMood(Mood mood, RelativeLayout layout) {
        Display display = getWindowManager().getDefaultDisplay();
        int width = 0;
        switch (mood) {
            case GREAT:
                layout.setBackgroundColor(getColor(R.color.light_sage));
                width = (display.getWidth() / 1);
                break;
            case GOOD:
                layout.setBackgroundColor(getColor(R.color.banana_yellow));
                width = (display.getWidth() / 2);
                break;
            case NORMAL:
                layout.setBackgroundColor(getColor(R.color.warm_grey));
                width = (display.getWidth() / 3);
                break;
            case BAD:
                layout.setBackgroundColor(getColor(R.color.cornflower_blue_65));
                width = (display.getWidth() / 4);
                break;
            case REALLY_BAD:
                layout.setBackgroundColor(getColor(R.color.faded_red));
                width = (display.getWidth() / 5);
                break;
        }
        int height = layout.getLayoutParams().height;
        LinearLayout.LayoutParams parms = (LinearLayout.LayoutParams) layout.getLayoutParams();
        parms.width = width;
        layout.setLayoutParams(parms);
       // layout.setVisibility(View.VISIBLE);
    }

    MoodBddDAO moodBddDAO = new MoodBddDAO(this) {

        public MoodEntry getMood(String date) {

            //fournit le système de calendrier standard
            Calendar cal = GregorianCalendar.getInstance();
            //Adopte le format que l'on souhaite
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //Crée une String pour que le calendrier récupère la date avec le format définit
            final String formatedDate = simpleDateFormat.format(cal.getTime());

            displayMood(getMoodWithDate(formatedDate).getMood(), mOne);

            Log.v("getMood","yes");
            displayMood(getMoodWithDate(formatedDate).getMood(), mTwo);

            //le mettre dans les imageButton
            mImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getMoodWithDate(formatedDate).getComment();
                    Log.d("getComment","yes");
                }
            });
            mImageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                 //  Toast.makeText(getMoodWithDate(date).getComment(),(c), Toast.LENGTH_LONG).show();
                }
            });
            mImageButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
            mImageButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
            mImageButton4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
            mImageButton5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
            mImageButton6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });

            return super.getMoodWithDate(date);
        }
    };

}