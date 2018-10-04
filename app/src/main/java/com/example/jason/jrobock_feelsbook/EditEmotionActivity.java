package com.example.jason.jrobock_feelsbook;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

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
    }
    public void EditDate(View view) {
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
            }
        },year,month,day);
        newDate.show();
    }

    public void EditTime(View view){
            
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
