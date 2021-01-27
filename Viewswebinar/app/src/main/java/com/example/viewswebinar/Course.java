package com.example.viewswebinar;

import java.util.ArrayList;
import java.util.Random;

public class Course {

    String name;
    String teacherName;
    int lectures;

    public Course(String name, String teacherName, int lectures) {
        this.name = name;
        this.teacherName = teacherName;
        this.lectures = lectures;
    }

    public String getName() {
        return name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public int getLectures() {
        return lectures;
    }

    public static final String[] teachers ={"Amit","sumit","raj","pavan"};

    public static final String[] coursename ={"java","js","python","android"};

    public static ArrayList<Course> generateCourses(int n){
        ArrayList<Course> courses =new ArrayList<>();
        Random r = new Random();

        for(int i=0; i<n; i++){
            Course cs = new Course(teachers[r.nextInt(3)], coursename[r.nextInt(3)], 10+r.nextInt(4));
            courses.add(cs);
        }
        return courses;
    }

}

























