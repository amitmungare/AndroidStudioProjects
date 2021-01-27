package com.codewithamit.listviews;

import java.util.ArrayList;

public class Teacher {

    String name;
    String course;

    public Teacher(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public static ArrayList<Teacher> getTeacher(){
        ArrayList<Teacher> teachers = new ArrayList<>();

        teachers.add(new Teacher("amit", "cybersec"));
        teachers.add(new Teacher("sahil", "android"));
        teachers.add(new Teacher("aalia", "android/web"));
        teachers.add(new Teacher("amit", "cybersec"));
        teachers.add(new Teacher("sahil", "android"));
        teachers.add(new Teacher("aalia", "android/web"));
        teachers.add(new Teacher("amit", "cybersec"));
        teachers.add(new Teacher("sahil", "android"));
        teachers.add(new Teacher("aalia", "android/web"));
        teachers.add(new Teacher("amit", "cybersec"));
        teachers.add(new Teacher("sahil", "android"));
        teachers.add(new Teacher("aalia", "android/web"));
        teachers.add(new Teacher("amit", "cybersec"));
        teachers.add(new Teacher("sahil", "android"));
        teachers.add(new Teacher("aalia", "android/web"));
        teachers.add(new Teacher("amit", "cybersec"));
        teachers.add(new Teacher("sahil", "android"));
        teachers.add(new Teacher("aalia", "android/web"));
        teachers.add(new Teacher("amit", "cybersec"));
        teachers.add(new Teacher("sahil", "android"));
        teachers.add(new Teacher("aalia", "android/web"));
        teachers.add(new Teacher("amit", "cybersec"));
        teachers.add(new Teacher("sahil", "android"));
        teachers.add(new Teacher("aalia", "android/web"));
        teachers.add(new Teacher("amit", "cybersec"));
        teachers.add(new Teacher("sahil", "android"));
        teachers.add(new Teacher("aalia", "android/web"));
        teachers.add(new Teacher("amit", "cybersec"));
        teachers.add(new Teacher("sahil", "android"));
        teachers.add(new Teacher("aalia", "android/web"));


        return teachers;
    }

}
