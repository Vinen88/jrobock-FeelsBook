package com.example.jason.jrobock_feelsbook;

import java.util.ArrayList;
import java.util.Collection;

public class EmotionList {
    protected ArrayList<Emotion> emotionList;
    protected ArrayList<Listener> listeners;
    private Emotion mostRecent;

    public EmotionList(){
        emotionList = new ArrayList<Emotion>();
        listeners = new ArrayList<Listener>();
    }
    public Collection<Emotion> getEmotions() {
        return emotionList;
    }
    public void addEmotion(Emotion emotion){
        emotionList.add(emotion);
        mostRecent = emotion;
    }
    public void removeEmotion(Emotion emotion){
        emotionList.remove(emotion);
        notifyListeners();
    }
    public int size() { return emotionList.size(); }
    public Emotion getMostRecent() { return mostRecent; }
    public boolean contains(Emotion emotion){
        return emotionList.contains(emotion);
    }
    public void notifyListeners(){
        for (Listener listener : listeners) {
            listener.update();
        }
    }
    public void addListener(Listener listener){
        listeners.add(listener);
    }
    public void removeListener(Listener listener){
        listeners.remove(listener);
    }

}

