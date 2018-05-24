package com.lin.celine.moodtracker.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.lin.celine.moodtracker.model.Mood;
import com.lin.celine.moodtracker.model.MoodEntry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by celine on 30/03/2018.
 */

public class MoodBddDAO {

    protected final static int VERSION = 1;
    // Le nom du fichier qui représente ma base
    protected final static String KEY_NOM = "database.db";
    protected SQLiteDatabase bdd = null;
    protected SQLite sqLite = null;
    public static final String TABLE_MOOD = "mood";
    public static final String KEY = "id";
    public static final String COMMENT = "comment";
    public static final String DATE = "date";
    public static final String MOOD = "mood";

    public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_MOOD + " (" + KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " + MOOD + " TEXT," + COMMENT + " TEXT, " + DATE + " DATE);";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS " + TABLE_MOOD + ";";

    public MoodBddDAO(Context pContext) {
        this.sqLite = new SQLite(pContext, KEY_NOM, null, VERSION);
    }

    //on ouvre la BDD en écriture
    public void open() {
        bdd = sqLite.getWritableDatabase();
    }

    //on ferme l'accès à la BDD
    public void close() {
        bdd.close();
    }

    public SQLiteDatabase getBDD() {
        return bdd;
    }

   public long insertMood(MoodEntry comment, Date date, Mood mood) {
        //long insert(String table, String nullColumnHack, ContentValues values){
        // pour insérer des données dans la base
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(DATE, date.getDate());
        values.put(COMMENT, comment.getComment());
        values.put(MOOD, mood.name());
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(String.valueOf(TABLE_MOOD), null, values);
    }

    public long insert(Mood mood) {
        ContentValues values = new ContentValues();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(MOOD, mood.name());
        values.put(DATE, sdf.format(new Date(System.currentTimeMillis())));

        return bdd.insert(String.valueOf(TABLE_MOOD), null, values);
    }

    //mise à jour
    public int updateMood(int id, MoodEntry mood) {
        //La mise à jour d'un mood dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simplement préciser quel mood on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        values.put(DATE, sdf.format(new Date(System.currentTimeMillis())));
        values.put(COMMENT, mood.getComment());
        values.put(MOOD, mood.getMood().name());
        return bdd.update(String.valueOf(TABLE_MOOD), values, MOOD + " = " + id, null);
    }

    //Suppression d'un mood de la BDD grâce à l'ID
    public int removeMoodWithID(int id) {
        return bdd.delete(String.valueOf(TABLE_MOOD), MOOD + " = " + id, null);
    }

    public MoodEntry getMoodWithDate(String date) {

        //Récupère dans un Cursor les valeurs correspondant à un mood contenu dans la BDD
        Cursor c = bdd.query(String.valueOf(TABLE_MOOD), new String[]{COMMENT, DATE, MOOD}, DATE + " LIKE \"" + date + "\"", null, null, null, null);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
        }

        //Récupérer le contenu d'une colonne
        String mood = c.getString(1);
        String commentaire = c.getString(2);
        String mDate = c.getString(3);

        Log.v("Mood", mood);
        Log.v("Commentaire", commentaire);
        Log.v("Date", mDate);

        //valueOf() peut convertir une chaine en objet Enum
        Mood moodMood = Mood.valueOf(mood);

        // parametre dans MoodEntry
        MoodEntry moodEntry = new MoodEntry();

        moodEntry.setMood(moodMood);
        moodEntry.setComment(commentaire);
        moodEntry.setDate(mDate);

        Log.v("Mood", String.valueOf(moodMood));
        Log.v("Commentaire",commentaire);
        Log.v("Date",mDate);
        
        c.close();

        return moodEntry;
    }

    //mood à ajouter à la base
    public void add(MoodEntry addMood) {
    }

    // id l'identifiant du mood à supprimer
    public void delete(long id) {
    }

    //mood modifié
    public void modifier(MoodEntry moodBdd) {

        long sevenDaysAgo = System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 7;

        Cursor curs = bdd.query(TABLE_MOOD, null, DATE + " > " + sevenDaysAgo, null, null, null, null);

        //Lire la mood depuis la base de données
        String mdString = curs.getString(curs.getColumnIndex(MOOD));
        //LOG
        Log.v("mood",mdString);

        //lire la date depuis la base de données
        String tmpString = curs.getString(curs.getColumnIndex(DATE));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateVariable = sdf.parse(tmpString);
            //LOG
            Log.v("date",tmpString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // id l'identifiant du mood à récupérer
    public MoodEntry select(long id) {
        return select(id);
    }
}