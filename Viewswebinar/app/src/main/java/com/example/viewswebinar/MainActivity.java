package com.example.viewswebinar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvCourses;
    ArrayList<Course> courses = Course.generateCourses(100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCourses = findViewById(R.id.lvcourse);
        CourseAdapter ca = new CourseAdapter();
        lvCourses.setAdapter(ca);

    }

    class CourseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return courses.size();
        }

        @Override
        public Course getItem(int position) {
            return courses.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            courseViewHolder holder;
            if(convertView ==null){
                convertView = getLayoutInflater().inflate(R.layout.list_item_course, parent, false);

                holder = new courseViewHolder(convertView);
                convertView.setTag(holder);
            }else{
                holder=(courseViewHolder) convertView.getTag();
            }

            Course course = getItem(position);

            holder.tvcoursename.setText(course.getName());
            holder.tvteachername.setText(course.getTeacherName());
            holder.tvlecture.setText(String.valueOf(course.getLectures()));

            return convertView;
        }
        class courseViewHolder {
            TextView tvcoursename, tvteachername , tvlecture;

            courseViewHolder(View convertView){
                tvcoursename = convertView.findViewById(R.id.tvcoursename);
                tvteachername = convertView.findViewById(R.id.tvteacher);
                tvlecture = convertView.findViewById(R.id.tvlecture);
            }

        }
    }

}




























