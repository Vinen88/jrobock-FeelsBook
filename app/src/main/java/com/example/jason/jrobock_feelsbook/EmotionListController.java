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

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class EmotionListController {
    private static final String FILENAME = "file.sav";
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

    /* load and save from file taken from https://github.com/shidahe/lonelyTwitter */

    static public void saveInFile(Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, 0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(EmotionListController.getEmotionList().emotionList, writer);
            writer.flush();
            fos.close();
        }
        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static public void loadFromFile(Context context){
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Emotion>>() {}.getType();
            EmotionListController.getEmotionList().emotionList = gson.fromJson(in, listType);
        }
        catch (FileNotFoundException e) {
            EmotionListController.getEmotionList();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

}
