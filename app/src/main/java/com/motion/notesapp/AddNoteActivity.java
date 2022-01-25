package com.motion.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class AddNoteActivity extends AppCompatActivity {
    RadioGroup radioGroupPriorety;
    Spinner spinner;
    EditText editTitle,editDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        initViews();
    }

    private void initViews() {
        radioGroupPriorety=findViewById(R.id.radio_group);
        spinner=findViewById(R.id.spinner_day_of_week);
        editTitle=findViewById(R.id.add_title);
        editDesc=findViewById(R.id.add_description);
    }

    public void add_note_click(View view) {
        String title=editTitle.getText().toString();
        String desc=editDesc.getFontFeatureSettings().toString();
        String dayOfWeek=spinner.getSelectedItem().toString();
        int radioButtonId=radioGroupPriorety.getCheckedRadioButtonId();
        RadioButton radioButton=findViewById(radioButtonId);
        int priority=Integer.parseInt(radioButton.getText().toString());
        Note note=new Note(title,desc,dayOfWeek,priority);
        MainActivity.noteList.add(note);
        startActivity(new Intent(AddNoteActivity.this,MainActivity.class));
    }
}