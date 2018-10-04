package com.example.jason.jrobock_feelsbook;

public class EmotionCounts {
    private static int[] emotionCounts = null;
    static public int[] getEmotionCounts() {
        if (emotionCounts == null){
            emotionCounts =  new int[] {0,0,0,0,0,0};

        }
        return emotionCounts;
    }
    public void addCount(String type){

    }
    public void removeCount(String type){

    }

    /*
    create method to go over EmotionList and get type of every one and add back to
    emotion counts!
     */

}
