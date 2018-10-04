package com.example.jason.jrobock_feelsbook;

public class EmotionListController {
    private static EmotionList emotionList = null;
    private static Emotion emotion = null;
    static public EmotionList getEmotionList() {
        if (emotionList == null){
            emotionList = new EmotionList();
        }
        return emotionList;
    }
    public void addEmotion(Emotion emotion) {
        getEmotionList().addEmotion(emotion);
    }
    static public Emotion getEmotion(){
        return emotion;
    }
    static public void saveEmotion(Emotion em){
        emotion = em;
    }
    static public Emotion getSave(){ return emotion;}
}
