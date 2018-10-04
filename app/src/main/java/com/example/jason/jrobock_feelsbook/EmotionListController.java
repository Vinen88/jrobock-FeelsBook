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
    /*
    Might want to move load/save file into here and use this to call it.
    also might want to add a removeEmotion method so all emotion list activity
    is done through here and saved right away
     */
}
