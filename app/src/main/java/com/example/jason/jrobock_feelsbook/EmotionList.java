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
        EmotionCounts.removeCount(emotion.getType());
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

