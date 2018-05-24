package com.lin.celine.moodtracker.controller;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.lin.celine.moodtracker.R;
/**
 * Created by celine on 17/02/2018.
 */
public class MoodCommentDialogFragment extends DialogFragment {
    private Button mValidade;
    private Button mCancel;
    private EditText mEdit;
    private OnDataPass dataPasser;

    static MoodCommentDialogFragment newInstance() {
        MoodCommentDialogFragment mdf = new MoodCommentDialogFragment();
        return mdf;
    }

    //Crée une interface
    public interface OnDataPass {
        public void passDataToActivity(String comment);
    }

    //Méthode onAttach , communication de fragment à activité
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // il garantit que l'activité de conteneur a été implémentée
        // l'interface de rappel. Sinon, il émet une exception
        try {
            dataPasser = (OnDataPass) getActivity();
        } catch (ClassCastException e) {
            // throw new ClassCastException(getActivity().toString());
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_popup, container, false);

        mValidade = (Button) view.findViewById(R.id.validade);
        mCancel = (Button) view.findViewById(R.id.cancel);
        mEdit = (EditText) view.findViewById(R.id.editTextDialogUserInput);
        mValidade.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Récuperer le contenu de l'edit
                String str = mEdit.getText().toString();
                dataPasser.passDataToActivity(str);

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
