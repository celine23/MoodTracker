package com.lin.celine.moodtracker.controller;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

import com.lin.celine.moodtracker.R;

import java.util.List;
import java.util.Vector;

public class MainActivity extends FragmentActivity implements MoodCommentDialogFragment.OnDataPass {
    final Context context = this;
    public PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.viewpager);
        List fragments = new Vector();

        {

            fragments.add(Fragment.instantiate(this, MoodFragment.class.getName()));
            this.mPagerAdapter = new PageAdapter(super.getSupportFragmentManager(), fragments);
            ViewPager pager = (ViewPager) super.findViewById(R.id.viewpager);
            // Affectation de l'adapter au ViewPager
            pager.setAdapter(this.mPagerAdapter);
        }
    }

    MoodBddDAO moodBddDAO = new MoodBddDAO(context) {

    };

    @Override
    public void passDataToActivity(String comment) {
        Log.d("Coucou", comment);

   //     moodBddDAO.insertMood(comment);
    }

}