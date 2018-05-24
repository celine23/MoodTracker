package com.lin.celine.moodtracker.model;

/**
 * Created by celine on 23/11/2017.
 */

public class MoodEntry {
    public String comment;
    private String date;
    private Mood mood;

    //Return
    public String getComment() {
        return comment;
    }

    public String getDate() {
        return date;
    }

    public Mood getMood() {
        return mood;
    }

    public void setComment(String mComment) {
        comment = mComment;

    }
    public void setDate(String mDate) {
        date = mDate;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }
}