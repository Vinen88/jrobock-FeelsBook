package com.example.jason.jrobock_feelsbook;

import java.util.Collection;
import java.util.Iterator;

public class EmotionCounts {
    private static int[] emotionCounts = null;
    static public int[] getEmotionCounts() {
        if (emotionCounts == null){
            /*Love,Joy,Surprise,Anger,Sadness,Fear I should just use a dict god damn it.*/
            emotionCounts =  new int[] {0,0,0,0,0,0};

        }
        return emotionCounts;
    }

    public void removeCount(String type) {
        switch (type){
            case "Love" : emotionCounts[0]--;
            case "Joy" : emotionCounts[1]--;
            case "Surprise" : emotionCounts[2]--;
            case "Anger" : emotionCounts[3]--;
            case "Sadness" : emotionCounts[4]--;
            case "Fear" : emotionCounts[5]--;
        }

    }

    public void addCount(String type) {
        switch (type){
            case "Love" : emotionCounts[0]++;
            case "Joy" : emotionCounts[1]++;
            case "Surprise" : emotionCounts[2]++;
            case "Anger" : emotionCounts[3]++;
            case "Sadness" : emotionCounts[4]++;
            case "Fear" : emotionCounts[5]++;
        }
    }

    public void initialize() {
       for(Emotion em : EmotionListController.getEmotionList().emotionList){
           addCount(em.getType());
        }
    }


}
