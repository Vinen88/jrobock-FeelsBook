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

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collection;


public class History extends Activity {
    private History activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ListView listView = (ListView) findViewById(R.id.Emotion_dynamic);
        Collection<Emotion> emotions = EmotionListController.getEmotionList().getEmotions();
        final ArrayList<Emotion> list = new ArrayList<Emotion>(emotions);
        final ArrayAdapter<Emotion> emotionAdapter = new ArrayAdapter<Emotion>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(emotionAdapter);

        EmotionListController.getEmotionList().addListener(new Listener() {
            @Override
            public void update() {
                list.clear();
                Collection<Emotion> emotions = EmotionListController.getEmotionList().getEmotions();
                list.addAll(emotions);
                emotionAdapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(History.this, EditEmotionActivity.class);
                //intent.putExtra("Emotion",list.get(position));
                EmotionListController.saveEmotion(list.get(position));
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(History.this);
                adb.setMessage("DELETE "+list.get(position).toString());
                final int finalPosition = position;
                adb.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Emotion emotion = list.get(finalPosition);
                        EmotionListController.getEmotionList().removeEmotion(emotion);
                    }
                });
                adb.setCancelable(true);
                adb.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        }
                });
                adb.show();
                return true;
            }
        });


    }



    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        ListView listView = (ListView) findViewById(R.id.Emotion_dynamic);
        Collection<Emotion> emotions = EmotionListController.getEmotionList().getEmotions();
        final ArrayList<Emotion> list = new ArrayList<Emotion>(emotions);
        final ArrayAdapter<Emotion> emotionAdapter = new ArrayAdapter<Emotion>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(emotionAdapter);
        //loadFromFile();
        //adapter = new ArrayAdapter<Emotion>(this, R.layout.list_item, Emotions);
        //oldEmotionList.setAdapter(adapter);
    }
}
