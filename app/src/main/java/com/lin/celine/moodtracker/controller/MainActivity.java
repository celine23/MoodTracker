package com.lin.celine.moodtracker.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.lin.celine.moodtracker.R;
import com.lin.celine.moodtracker.model.Mood;
import com.lin.celine.moodtracker.model.MoodEntry;
import java.util.List;
import java.util.Vector;

//Gestionnaire de mise en page qui permet à l'utilisateur de basculer à gauche et à droite à travers les pages de données.
public class MainActivity extends FragmentActivity implements MoodCommentDialogFragment.OnCommentFilledListener,MoodFragment.OnMoodSelectedListener {
    public PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.viewpager);

        //fragment pour pouvoir slider les mood
        this.mPagerAdapter = new PageAdapter(super.getSupportFragmentManager());
        ViewPager pager = (ViewPager) super.findViewById(R.id.viewpager);
        // Affectation de l'adapter au ViewPager
        pager.setAdapter(this.mPagerAdapter);
    }

    @Override
    public void onCommentFilled(String comment, Mood mood) {
        MoodBddDAO moodBddDAO = new MoodBddDAO(getApplicationContext());
        moodBddDAO.open();
        moodBddDAO.insert(mood,comment);
        Log.d("mood,comment","yes");
    }

    @Override
    public void onMoodSelected(Mood mood) {
        MoodBddDAO moodBddDAO = new MoodBddDAO(getApplicationContext());
        moodBddDAO.open();
        moodBddDAO.insertMood(mood);
        Log.d("mood","yes");
    }
}