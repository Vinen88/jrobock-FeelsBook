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

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.Serializable;


public class MainActivity extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EmotionListController.loadFromFile(MainActivity.this);
        EmotionCounts.initialize();
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateTextBoxes();

    }
    private void updateTextBoxes(){
        TextView loveView = (TextView) findViewById(R.id.loveCount);
        loveView.setText(Integer.toString(EmotionCounts.emotionCounts[0]));
        TextView joyView = (TextView) findViewById(R.id.JoyCount);
        joyView.setText(Integer.toString(EmotionCounts.emotionCounts[1]));
        TextView surpriseView = (TextView) findViewById(R.id.SurpriseCount);
        surpriseView.setText(Integer.toString(EmotionCounts.emotionCounts[2]));
        TextView angerView = (TextView) findViewById(R.id.AngerCount);
        angerView.setText(Integer.toString(EmotionCounts.emotionCounts[3]));
        TextView sadnessView = (TextView) findViewById(R.id.SadnessCount);
        sadnessView.setText(Integer.toString(EmotionCounts.emotionCounts[4]));
        TextView fearView = (TextView) findViewById(R.id.FearCount);
        fearView.setText(Integer.toString(EmotionCounts.emotionCounts[5]));
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
            updateTextBoxes();
            EmotionListController.saveInFile(MainActivity.this);
        }catch (textTooLongException e){
            Toast.makeText(this,"Text too long",Toast.LENGTH_SHORT).show();
        }

    }
}
