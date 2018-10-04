package com.example.jason.jrobock_feelsbook;

import java.util.Date;

public class Emotion {
    private String text;
    private String date;
    private String type;

    public Emotion(String comment, String emotionValue) throws textTooLongException{
        this.setText(comment);
        this.type = emotionValue;
        String oldDate = new Date().toString();
        String [] parts = oldDate.split(" ");
        this.date = parts[2]+" "+parts[1]+" "+parts[5]+" "+parts[3]+" "+parts[4];

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
    public void setDate (String date){
        this.date = date;
    }
    public String toString(){
        return getType()+"\n"+getDate()+"\n"+getText();
    }

}

