package com.lin.celine.moodtracker.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.lin.celine.moodtracker.R;
import com.lin.celine.moodtracker.model.Mood;
import com.lin.celine.moodtracker.model.MoodEntry;

public class MoodFragment extends Fragment {

    public ImageView moodSmiley;
    public ImageButton buttonHistory;
    public ImageButton buttonAddnote;
    public RelativeLayout relativeLayout;
    OnMoodSelectedListener mCallback;

    //grace a l'interface on peut communiquer fragment-activité avec la méthode onArticleSeleted() en utilisant mCallBack
    public interface OnMoodSelectedListener {
        public void onMoodSelected(Mood mood);
    }

    // Cela garantit que l'activité de conteneur a été implémentée
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (OnMoodSelectedListener) activity;

        } catch (ClassCastException e) {
        }
    }

    //créer et initialiser une nouvelle instance de la classe déclarante du constructeur
    //Passe en parametre le mood puis configure l'image et la couleure de fond
    public static MoodFragment newInstance(Mood mood) {
        MoodFragment moodFragment = new MoodFragment();
        //Un mappage des clés de chaîne vers différentes valeurs.
        //Passer le mood en parametre
        //setArguments est une méthode pour définir des données de groupe sur un fragment
        // Bundle est un mappage de valeurs String à divers types Parcelable
        Bundle args = new Bundle();
        args.putString("mood", mood.name());
        //définie des données de groupe sur un fragment
        moodFragment.setArguments(args);

        return moodFragment;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mood, container, false);

        buttonHistory = (ImageButton) view.findViewById(R.id.history);
        buttonAddnote = (ImageButton) view.findViewById(R.id.addnote);
        moodSmiley = (ImageView) view.findViewById(R.id.moodSmiley);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.relativeLayout);

        //Add a comment and history button
        buttonHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent historyIntent = new Intent(getActivity(), HistoryActivity.class);
                startActivity(historyIntent);
            }
        });
        buttonAddnote.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                MoodCommentDialogFragment myDialogFragment = new MoodCommentDialogFragment();
                myDialogFragment.show(fragmentManager, "dialog");
            }
        });

        //Récupère la mood pour la mettre en énum en récupérent l'argument du bundle
        final Mood mood = Mood.valueOf(getArguments().getString("mood"));
        differentMood(mood, relativeLayout);
        moodSmiley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MoodBddDAO moodBddDAO = new MoodBddDAO(getContext());

                mCallback.onMoodSelected(mood);
                moodBddDAO.open();
                moodBddDAO.updateMood(1, mood);
                Log.d("mcallback","yes");
            }
        });
        return view;
    }

    private void differentMood(final Mood dMood, RelativeLayout rLayout) {
        switch (dMood) {
            case GREAT:
                moodSmiley.setImageResource(R.drawable.super_happy);
                //getColor() récupère la couleur puis l'attribue setBackgroundColor()
                rLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.light_sage));
                break;
            case GOOD:
                moodSmiley.setImageResource(R.drawable.smiley_happy);
                rLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.banana_yellow));
                break;
            case NORMAL:
                moodSmiley.setImageResource(R.drawable.smiley_normal);
                rLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.warm_grey));
                break;
            case BAD:
                moodSmiley.setImageResource(R.drawable.smiley_disappointed);
                rLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.cornflower_blue_65));
                break;
            case REALLY_BAD:
                moodSmiley.setImageResource(R.drawable.smiley_sad);
                rLayout.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.faded_red));
                break;
        }
    }
}