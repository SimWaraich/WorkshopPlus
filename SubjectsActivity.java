package com.example.workshop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SubjectsActivity extends AppCompatActivity {

    String[] subjects = { "MATH", "CMPT", "MACM", "STAT"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);
        Spinner spin = (Spinner) findViewById(R.id.subjectSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, subjects);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
    }

    // Selects subject in spinner and goes to next activity, passing subject selected
    public void selectSubject(View v){
        Spinner subject = (Spinner)findViewById(R.id.subjectSpinner);
        String subj = subject.getSelectedItem().toString();
        Log.d("Subject", subj);
        Toast.makeText(this, "Selected subject: ", Toast.LENGTH_LONG).show();
        Toast.makeText(this, subj, Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, CourseActivity.class);
        i.putExtra("Subject", subj);
        startActivity(i);
    }

    public void goToSettings(View v){
        Intent i = new Intent(this,SettingsActivity.class);
        startActivity(i);
    }
}