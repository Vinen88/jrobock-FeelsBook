package com.example.jason.jrobock_feelsbook;

import java.util.Date;

public class Emotion {
    private String text;
    private String date;
    private String type;

    public Emotion(String comment, String emotionValue) throws textTooLongException{
        this.setText(comment);
        this.type = emotionValue;
        this.date = new Date().toString();

    }

    public String getDate(){ return date; }
    public String getText() { return text; }
    public String getType() {return type;}

    public void setType(String type){
        this.type = type;
    }
    public void setText(String text) throws textTooLongException {
        if (text.length() <= 100){
            this.text = text;
        }
        else{
            throw new textTooLongException();
        }
    }
    public void setDate (Date date){
        this.date = date.toString();
    }
    public String toString(){
        return getType()+"\n"+getDate()+"\n"+getText();
    }

}

