package com.lin.celine.moodtracker.controller;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.lin.celine.moodtracker.R;
import com.lin.celine.moodtracker.model.Mood;
import com.lin.celine.moodtracker.model.MoodEntry;
import static com.lin.celine.moodtracker.R.layout.mood;
import static com.lin.celine.moodtracker.model.Mood.BAD;
import static com.lin.celine.moodtracker.model.Mood.GOOD;
import static com.lin.celine.moodtracker.model.Mood.GREAT;
import static com.lin.celine.moodtracker.model.Mood.NORMAL;
import static com.lin.celine.moodtracker.model.Mood.REALLY_BAD;

public class MoodFragment extends Fragment {

    public ImageView mSuperHappy;
    public ImageView mHappy;
    public ImageView mNormal;
    public ImageView mDisappointed;
    public ImageView mSad;
    public ImageButton mhistory1;
    public ImageButton maddnote1;
    public ImageButton mhistory2;
    public ImageButton maddnote2;
    public ImageButton mhistory3;
    public ImageButton maddnote3;
    public ImageButton mhistory4;
    public ImageButton maddnote4;
    public ImageButton mhistory5;
    public ImageButton maddnote5;
    public RelativeLayout relativeSHappy;
    public RelativeLayout relativeHappy;
    public RelativeLayout relativeNormal;
    public RelativeLayout relativeDisappointed;
    public RelativeLayout relativeSad;
    public RelativeLayout allRelative;

    public static MoodFragment newInstance(Mood mood) {
        MoodFragment moodFragment = new MoodFragment();
        return moodFragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(mood, container, false);

        mhistory1 = (ImageButton) view.findViewById(R.id.history);
        maddnote1 = (ImageButton) view.findViewById(R.id.addnote);
        mSuperHappy = (ImageView) view.findViewById(R.id.super_happy);
        mHappy = (ImageView) view.findViewById(R.id.happy);
        mhistory2 = (ImageButton) view.findViewById(R.id.history1);
        maddnote2 = (ImageButton) view.findViewById(R.id.addnote1);
        mNormal = (ImageView) view.findViewById(R.id.normal);
        mhistory3 = (ImageButton) view.findViewById(R.id.history2);
        maddnote3 = (ImageButton) view.findViewById(R.id.addnote2);
        mDisappointed = (ImageView) view.findViewById(R.id.disappointed);
        mhistory4 = (ImageButton) view.findViewById(R.id.history3);
        maddnote4 = (ImageButton) view.findViewById(R.id.addnote3);
        mSad = (ImageView) view.findViewById(R.id.sad);
        mhistory5 = (ImageButton) view.findViewById(R.id.history4);
        maddnote5 = (ImageButton) view.findViewById(R.id.addnote4);
        relativeSHappy = (RelativeLayout) view.findViewById(R.id.relative);
        relativeHappy = (RelativeLayout) view.findViewById(R.id.relative1);
        relativeNormal = (RelativeLayout) view.findViewById(R.id.relative2);
        relativeDisappointed = (RelativeLayout) view.findViewById(R.id.relative3);
        relativeSad = (RelativeLayout) view.findViewById(R.id.relative4);
        allRelative = (RelativeLayout) view.findViewById(R.id.relativeLayout);

        MoodEntry moodEntry1 = new MoodEntry();
        MoodEntry moodEntry2 = new MoodEntry();
        MoodEntry moodEntry3 = new MoodEntry();
        MoodEntry moodEntry4 = new MoodEntry();
        MoodEntry moodEntry5 = new MoodEntry();

        moodEntry1.setMood(GREAT);
        moodEntry2.setMood(GOOD);
        moodEntry3.setMood(NORMAL);
        moodEntry4.setMood(BAD);
        moodEntry5.setMood(REALLY_BAD);

        differentMood(moodEntry1.getMood(), relativeNormal); //couleur verte
        differentMood(moodEntry2.getMood(), relativeHappy);
        differentMood(moodEntry3.getMood(), relativeNormal);
        differentMood(moodEntry4.getMood(), relativeDisappointed);
        differentMood(moodEntry5.getMood(), relativeSad);

        //Add a comment and history button
        mhistory1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent historyIntent = new Intent(getActivity(), HistoryActivity.class);
                startActivity(historyIntent);
            }
        });
        maddnote1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MoodCommentDialogFragment myDialogFragment = new MoodCommentDialogFragment();
                myDialogFragment.show(fragmentManager, "dialog");
            }
        });
        mhistory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent historyIntent1 = new Intent(getActivity(), HistoryActivity.class);
                startActivity(historyIntent1);
            }
        });
        maddnote2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager1 = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                MoodCommentDialogFragment myDialogFragment = new MoodCommentDialogFragment();
                myDialogFragment.show(fragmentManager1, "dialog");
            }
        });
        mhistory3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Intent historyIntent2 = new Intent(getActivity(), HistoryActivity.class);
                startActivity(historyIntent2);
            }
        });
        maddnote3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager2 = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                MoodCommentDialogFragment myDialogFragment = new MoodCommentDialogFragment();
                myDialogFragment.show(fragmentManager2, "dialog");
            }
        });
        mhistory4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                Intent historyIntent3 = new Intent(getActivity(), HistoryActivity.class);
                startActivity(historyIntent3);
            }
        });
        maddnote4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager3 = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                MoodCommentDialogFragment myDialogFragment = new MoodCommentDialogFragment();
                myDialogFragment.show(fragmentManager3, "dialog");
            }
        });
        mhistory5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v4) {
                Intent historyIntent4 = new Intent(getActivity(), HistoryActivity.class);
                startActivity(historyIntent4);
            }
        });
        maddnote5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager4 = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction4 = fragmentManager4.beginTransaction();
                MoodCommentDialogFragment myDialogFragment = new MoodCommentDialogFragment();
                myDialogFragment.show(fragmentManager4, "dialog");
            }
        });

        return view;
    }

    MoodBddDAO moodBddDAO = new MoodBddDAO(getContext()) {

        @Override
        public void open() {

            final ContentValues values = new ContentValues();

            mSuperHappy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                  moodBddDAO.insert(GREAT);
                }
            });
            mHappy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    moodBddDAO.insert(GOOD);
                }
            });
            mNormal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    moodBddDAO.insert(NORMAL);
                }
            });
            mDisappointed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    moodBddDAO.insert(BAD);
                }
            });
            mSad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    moodBddDAO.insert(REALLY_BAD);
                }
            });
        }
    };

    private void differentMood(final Mood dMood, RelativeLayout rLayout) {

        switch (dMood) {
            case GREAT:
                rLayout.setBackgroundColor(R.color.light_sage);
              //  rLayout.setBackgroundResource(R.drawable.super_happy);
            case GOOD:
                rLayout.setBackgroundColor(R.color.banana_yellow);
             //   rLayout.setIconResource(R.drawable.smiley_happy);
            case NORMAL:
                rLayout.setBackgroundColor(R.color.warm_grey);
               // rLayout.setIconResource(R.drawable.smiley_normal);
            case BAD:
                rLayout.setBackgroundColor(R.color.cornflower_blue_65);
                //rLayout.setIconResource(R.drawable.smiley_disappointed);
            case REALLY_BAD:
                rLayout.setBackgroundColor(R.color.faded_red);
               // rLayout.setIconResource(R.drawable.smiley_sad);
        }
    }
}