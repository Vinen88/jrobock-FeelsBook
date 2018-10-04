package com.example.jason.jrobock_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Serializable {
    private static final String FILENAME = "file.sav";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void selectJoy(View view) {
        Toast.makeText(this,"Selected Joy",Toast.LENGTH_SHORT).show();
        work("Joy");
    }
    public void selectLove(View view){
        Toast.makeText(this,"Selected Love",Toast.LENGTH_SHORT).show();
        work("Love");
    }
    public void selectSurprise(View view){
        Toast.makeText(this,"Selected Surprise",Toast.LENGTH_SHORT).show();
        work("Surprise");
    }
    public void selectAnger(View view){
        Toast.makeText(this,"Selected Anger",Toast.LENGTH_SHORT).show();
        work("Anger");
    }
    public void selectSadness(View view){
        Toast.makeText(this,"Selected Sadness",Toast.LENGTH_SHORT).show();
        work("Sadness");
    }
    public void selectFear(View view){
        Toast.makeText(this,"Selected Fear",Toast.LENGTH_SHORT).show();
        work("Fear");
    }
    public void selectHistory(View view){
        Intent intent = new Intent(this, History.class);
        startActivity(intent);

    }
    private void work(String em){
        EmotionListController ec = new EmotionListController();
        EditText textView = (EditText) findViewById(R.id.commentText);
        String comment = "";
        if (textView.getText().toString().contentEquals("Comment (optional)")){ comment = " ";
        } else {
            comment = textView.getText().toString();
            textView.setText(" ");
        }

        try {
            ec.addEmotion(new Emotion(comment, em));
        }catch (textTooLongException e){
            Toast.makeText(this,"Text too long",Toast.LENGTH_SHORT).show();
        }

    }
    private void loadFromFile(){
        try {
            EmotionList emotionList = EmotionListController.getEmotionList();
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Emotion>>() {
            }.getType();
            emotionList = gson.fromJson(in, listType);
        }
        catch (FileNotFoundException e) {
            EmotionList emotionList = EmotionListController.getEmotionList();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    private void saveInFile() {
        try {
            EmotionList emotionList = EmotionListController.getEmotionList();
            FileOutputStream fos = openFileOutput(FILENAME, 0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(emotionList, writer);
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
}
