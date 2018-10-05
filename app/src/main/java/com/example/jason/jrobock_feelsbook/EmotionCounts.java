package com.example.jason.jrobock_feelsbook;

import java.util.Collection;
import java.util.Iterator;

public class EmotionCounts {
    protected static int[] emotionCounts =  new int[] {0,0,0,0,0,0};
    static public int[] getEmotionCounts() {
        return emotionCounts;
    }

    static public void removeCount(String type) {
        switch (type){
            case "Love" : emotionCounts[0]--;
                        break;
            case "Joy" : emotionCounts[1]--;
                        break;
            case "Surprise" : emotionCounts[2]--;
                            break;
            case "Anger" : emotionCounts[3]--;
                        break;
            case "Sadness" : emotionCounts[4]--;
                        break;
            case "Fear" : emotionCounts[5]--;
                        break;
        }

    }

    static public void addCount(String type) {
        switch (type){
            case "Love" : emotionCounts[0]++;
                          break;
            case "Joy" : emotionCounts[1]++;
                         break;
            case "Surprise" : emotionCounts[2]++;
                            break;
            case "Anger" : emotionCounts[3]++;
                            break;
            case "Sadness" : emotionCounts[4]++;
                        break;
            case "Fear" : emotionCounts[5]++;
                        break;
        }
    }
    /*
    this shits broken will fix tomrrow
     */
    static public void initialize() {
       for(Emotion em : EmotionListController.getEmotionList().emotionList){
           addCount(em.getType());
        }
    }


}
