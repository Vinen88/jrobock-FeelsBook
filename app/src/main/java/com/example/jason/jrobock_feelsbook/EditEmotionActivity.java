/*
Activity for editing Emotion classes mainly calls on other classes to do actual work

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

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;

public class EditEmotionActivity extends AppCompatActivity {
    private Emotion emotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_emotion);
        emotion = EmotionListController.getSave();
        //Intent intent = getIntent();
        //emotion = intent.getParcelableExtra("Emotion");
        TextView dateView = (TextView) findViewById(R.id.dateView);
        dateView.setText(emotion.getDate());
        TextView emView = (TextView) findViewById(R.id.emotionTypeView);
        emView.setText(emotion.getType());
        TextView commentView = (TextView) findViewById(R.id.commentText);
        commentView.setText(emotion.getText());

    }
    public void EditComment(View view){
        TextView commentView = (TextView) findViewById(R.id.commentText);
        emotion.setText(commentView.getText().toString());
        Toast.makeText(this,"Updated Comment",Toast.LENGTH_SHORT).show();
        EmotionListController.getEmotionList().notifyListeners();
        EmotionListController.saveInFile(EditEmotionActivity.this);
    }
    public void editDate(View view) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog newDate = new DatePickerDialog(EditEmotionActivity.this, android.R.style.Theme, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int newYear, int newMonth, int newDayOfMonth) {
                String oldDate = emotion.getDate();
                String[] parts = oldDate.split(" ");
                String date = Integer.toString(newDayOfMonth)+" "+getMonth(newMonth)+" "+Integer.toString(newYear)+" "+parts[3]+" "+parts[4];
                emotion.setDate(date);
                TextView dateView = (TextView) findViewById(R.id.dateView);
                dateView.setText(emotion.getDate());
                EmotionListController.getEmotionList().notifyListeners();
                EmotionListController.saveInFile(EditEmotionActivity.this);
            }
        },year,month,day);
        newDate.show();

    }

    public void EditTime(View view){
        TimePickerDialog pickTime = new TimePickerDialog(EditEmotionActivity.this, android.R.style.Theme_Black, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String oldDate = emotion.getDate();
                String [] parts = oldDate.split(" ");
                String [] time = parts[3].split(":");
                if (hourOfDay < 10) {  time[0] = "0"+Integer.toString(hourOfDay); }
                else { time[0] = Integer.toString(hourOfDay); }
                if (minute < 10) { time [1] = "0"+Integer.toString(minute); }
                else {  time[1] = Integer.toString(minute); }
                parts[3] = time[0]+":"+time[1]+":"+time[2];
                oldDate = parts[0]+" "+parts[1]+" "+parts[2]+" "+parts[3]+" "+parts[4];
                emotion.setDate(oldDate);
                TextView dateView = (TextView) findViewById(R.id.dateView);
                dateView.setText(emotion.getDate());
                EmotionListController.getEmotionList().notifyListeners();
                EmotionListController.saveInFile(EditEmotionActivity.this);

            }
        },1,1,true);
        pickTime.show();
    }

    private String getMonth(int numMonth){
        switch (numMonth){
            case 0: return "Jan";
            case 1: return "Feb";
            case 2: return "Mar";
            case 3: return "Apr";
            case 4: return "May";
            case 5: return "Jun";
            case 6: return "Jul";
            case 7: return "Aug";
            case 8: return "Sep";
            case 9: return "Oct";
            case 10: return "Nov";
            case 11: return "Dec";


        }
        return "Opps";
    }

}
