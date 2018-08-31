package com.lin.celine.moodtracker.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.lin.celine.moodtracker.R;
import com.lin.celine.moodtracker.model.Mood;

import static com.lin.celine.moodtracker.model.Mood.GREAT;

/**
 * Created by celine on 17/02/2018.
 */
public class MoodCommentDialogFragment extends DialogFragment {
    private Button mValidade;
    private Button mCancel;
    private EditText mEdit;
    private OnCommentFilledListener listener;

    //Crée une interface
    public interface OnCommentFilledListener {
        public void onCommentFilled(String comment, Mood mood);
    }

    //Méthode onAttach , communication de fragment à activité
    //on récupère un pointeur vers l'activité contenante
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // il garantit que l'activité de conteneur a été implémentée
        // l'interface de rappel. Sinon, il émet une exception
        try {
            listener = (OnCommentFilledListener) getActivity();
        } catch (ClassCastException e) {
        }
    }

  /*  public static MoodCommentDialogFragment newInstance(Mood mood) {
        MoodCommentDialogFragment moodCommentDialogFragment = new MoodCommentDialogFragment();

        Bundle args = new Bundle();
        args.putString("mood", mood.name());

        moodCommentDialogFragment.setArguments(args);

        return moodCommentDialogFragment;
    }*/

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_popup, container, false);

        mValidade = (Button) view.findViewById(R.id.validade);
        mCancel = (Button) view.findViewById(R.id.cancel);
        mEdit = (EditText) view.findViewById(R.id.editTextDialogUserInput);
        mValidade.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Récuperer le contenu de l'edit
                // il n'y a que great ...
                final Mood mood = Mood.GREAT;
                String str = mEdit.getText().toString();
                listener.onCommentFilled(str, mood);
                Log.d("str,mood","yes");

                //fermer le dialogue
                dismiss();
            }
        });

        mCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getDialog().cancel();
            }
        });

        return view;
    }
}
