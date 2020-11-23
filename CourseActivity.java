package com.example.workshop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CourseActivity extends AppCompatActivity {

    String[] MATH_COURSES = { "MATH150", "MATH154", "MATH232", "MATH251"};
    String[] CMPT_COURSES = { "CMPT120", "CMPT213", "CMPT276", "CMPT307"};
    String[] MACM_COURSES = { "MACM101", "MACM201", "MACM316", "MACM400"};
    String[] STAT_COURSES = { "STAT100", "STAT180", "STAT270", "STAT285"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        Intent i = getIntent();
        String subject = i.getStringExtra("Subject");
        ((TextView)findViewById(R.id.subject)).setText(subject);
        Spinner spin = (Spinner) findViewById(R.id.courseSpinner);
        String[] courses = new String[4];
        courses = CMPT_COURSES;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, courses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
    }

    public void selectCourse(View v){
        Spinner course = (Spinner)findViewById(R.id.courseSpinner);
        String courseID = course.getSelectedItem().toString();
        Log.d("CourseID", courseID);
        Toast.makeText(this, "Selected subject: ", Toast.LENGTH_LONG).show();
        Toast.makeText(this, courseID, Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, AssignmentActivity.class);
        i.putExtra("Course", courseID);
        startActivity(i);
    }
    public void goToSettings(View v){
        Intent i = new Intent(this,SettingsActivity.class);
        startActivity(i);
    }
}