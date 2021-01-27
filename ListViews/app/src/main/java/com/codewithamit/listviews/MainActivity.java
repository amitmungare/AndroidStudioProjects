package com.codewithamit.listviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String[] name;
    ListView lvname;

    ArrayList<Teacher> teachers =Teacher.getTeacher();
    ListView lvteachers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //part 1
        name = new String[]{"mango", "orange", "apple","mango", "orange", "apple","mango", "orange", "apple","mango", "orange", "apple","mango", "orange", "apple"};
        lvname = findViewById(R.id.lvname);
        ArrayAdapter<String> na = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,android.R.id.text1,name);
        lvname.setAdapter(na);


        //part 2
        lvteachers = findViewById(R.id.lvteachers);
        TeacherAdapter ta = new TeacherAdapter();
        lvteachers.setAdapter(ta);

    }

    class TeacherAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return teachers.size();
        }

        @Override
        public Teacher getItem(int position) {
            return teachers.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View itemView = getLayoutInflater().inflate(R.layout.list_item_teacher,parent,false);

            TextView tvname = itemView.findViewById(R.id.tvname);
            TextView tvcourse = itemView.findViewById(R.id.tvcourse);
            tvname.setText(getItem(position).getName());
            tvcourse.setText(getItem(position).getCourse());

            return itemView;
        }
    }

}






















