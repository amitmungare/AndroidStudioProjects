package com.example.viewswebinar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.viewswebinar.R.id.tvlecture;

public class courseRecycleAdapter extends RecyclerView.Adapter<courseRecycleAdapter.CourseViewHolder> {

    ArrayList<Course> courses;

    public courseRecycleAdapter(ArrayList<Course> courses) {
        this.courses = courses;
    }

    @Override
    public CourseViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemVIew = li.inflate(R.layout.list_item_course_card,parent,false);
        return new CourseViewHolder(itemVIew);
    }

    @Override
    public void onBindViewHolder( courseRecycleAdapter.CourseViewHolder holder, int position) {

        Course course = courses.get(position);
        holder.tvlecture.setText(String.valueOf(course.getLectures()));
        holder.tvcourse.setText(course.getName());
        holder.tvteacher.setText(course.getTeacherName());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }


    class CourseViewHolder extends RecyclerView.ViewHolder{

        TextView tvcourse, tvteacher , tvlecture;

        public CourseViewHolder( View itemView) {
            super(itemView);
            tvcourse =itemView.findViewById(R.id.tvcoursename);
            tvteacher = itemView.findViewById(R.id.tvteacher);
            tvlecture = itemView.findViewById(R.id.tvlecture);
        }
    }

}
