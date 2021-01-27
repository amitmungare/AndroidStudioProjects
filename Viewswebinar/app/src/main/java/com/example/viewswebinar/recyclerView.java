package com.example.viewswebinar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class recyclerView extends AppCompatActivity {

    ArrayList<Course> courses =Course.generateCourses(100);
    RecyclerView rvCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        rvCourses = findViewById(R.id.rvCourses);
        rvCourses.setLayoutManager(
//                new LinearLayoutManager(this)
                new GridLayoutManager(this,1,RecyclerView.HORIZONTAL,false)
        );

        courseRecycleAdapter ca = new courseRecycleAdapter(courses);
        rvCourses.setAdapter(ca);

    }
}