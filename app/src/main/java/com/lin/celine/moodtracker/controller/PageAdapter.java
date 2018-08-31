package com.lin.celine.moodtracker.controller;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.ImageView;
import com.lin.celine.moodtracker.R;
import com.lin.celine.moodtracker.model.Mood;
import java.util.List;

/**
 * Created by celine on 07/03/2018.
 */
//Génère les pages des vues affichés et des adaptateurs standards sont implémentés pour utiliser des fragments avec ViewPager.
public class PageAdapter extends FragmentPagerAdapter {

    //On fournit à l'adapter la liste des fragments à afficher
    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    //Obtient l'élément à l'emplacement spécifié
    public Fragment getItem(int position) {
        Fragment fragment = null;

        //crée les moodfragment et l'instancier les mood
        MoodFragment fragment1 = MoodFragment.newInstance(Mood.GREAT);
        MoodFragment fragment2 = MoodFragment.newInstance(Mood.GOOD);
        MoodFragment fragment3 = MoodFragment.newInstance(Mood.NORMAL);
        MoodFragment fragment4 = MoodFragment.newInstance(Mood.BAD);
        MoodFragment fragment5 = MoodFragment.newInstance(Mood.REALLY_BAD);

        if (position == 0) {
            fragment = fragment1;
        } else if (position == 1) {
            fragment = fragment2;
        } else if (position == 2) {
            fragment = fragment3;
        } else if (position == 3) {
            fragment = fragment4;
        } else if (position == 4) {
            fragment = fragment5;
        }
        return fragment;
        //  return (Fragment) this.fragments.get(position);
    }

    //NB d'elements représenter par l'adapteur
    public int getCount() {
        return 5;
    }
}