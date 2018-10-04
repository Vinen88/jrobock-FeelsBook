package com.example.jason.jrobock_feelsbook;

public class EmotionCounts {
    private static int[] emotionCounts = null;
    static public int[] getEmotionCounts() {
        if (emotionCounts == null){
            emotionCounts =  new int[] {0,0,0,0,0,0};

        }
        return emotionCounts;
    }

}
