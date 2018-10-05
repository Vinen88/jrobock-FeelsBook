/*
Copyright 2018 Jason Robock

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

package com.example.jason.jrobock_feelsbook;

import java.util.Date;

public class Emotion implements Comparable<Emotion> {
    private String text;
    private String date;
    private String type;

    public Emotion(String comment, String emotionValue) throws textTooLongException{
        this.setText(comment);
        this.type = emotionValue;
        String oldDate = new Date().toString();
        String [] parts = oldDate.split(" ");
        this.date = parts[2]+" "+parts[1]+" "+parts[5]+" "+parts[3]+" "+parts[4];
        EmotionCounts.addCount(this.type);

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

    @Override
    public int compareTo(Emotion emo){
        String outsideDate = emo.getDate();
        String [] outsideParts = outsideDate.split(" ");
        String [] parts = this.date.split(" ");
        String [] outsideTime = outsideParts[3].split(":");
        String [] time = parts[3].split(":");
        if ( Integer.parseInt(outsideParts[2]) <  Integer.parseInt(parts[2])){
            return 1;
        }

        if (getIntMonth(parts[1]) > getIntMonth(outsideParts[1])
                && Integer.parseInt(outsideParts[2]) == Integer.parseInt(parts[2])) {
            return 1;
        }

        if (Integer.parseInt(parts[0]) > Integer.parseInt(outsideParts[0])
                && getIntMonth(parts[1]) == getIntMonth(outsideParts[1])
                && Integer.parseInt(outsideParts[2]) == Integer.parseInt(parts[2])) {
            return 1;
        }

        if (Integer.parseInt(time[0]) > Integer.parseInt(outsideTime[0])
                && Integer.parseInt(parts[0]) == Integer.parseInt(outsideParts[0])
                && getIntMonth(parts[1]) == getIntMonth(outsideParts[1])
                && Integer.parseInt(outsideParts[2]) ==  Integer.parseInt(parts[2])){
            return 1;
        }

        if (Integer.parseInt(time[1]) > Integer.parseInt(outsideTime[1])
                && Integer.parseInt(time[0]) == Integer.parseInt(outsideTime[0])
                && Integer.parseInt(parts[0]) == Integer.parseInt(outsideParts[0])
                && getIntMonth(parts[1]) == getIntMonth(outsideParts[1])
                && Integer.parseInt(outsideParts[2]) ==  Integer.parseInt(parts[2])){
            return 1;
        }

        return -1;
    }

    private int getIntMonth(String month){
        switch (month){
            case "Jan" : return 1;
            case "Feb" : return 2;
            case "Mar" : return 3;
            case "Apr" : return 4;
            case "May" : return 5;
            case "Jun" : return 6;
            case "Jul" : return 7;
            case "Aug" : return 8;
            case "Sep" : return 9;
            case "Oct" : return 10;
            case "Nov" : return 11;
            case "Dec" : return 12;


        }
        return 0;
    }

}

