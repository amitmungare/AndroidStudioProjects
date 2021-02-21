package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText edtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtext = (EditText) findViewById(R.id.etdata);
        Button btngetdata = findViewById(R.id.btngetdata);

        btngetdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getdata();
            }
        });
    }

    private void getdata() {

        NetworkTask networkTask = new NetworkTask();
//        networkTask.execute("https://www."+edtext.getText().toString()+".com");
        networkTask.execute("https://api.github.com/search/users?q="+edtext.getText().toString());

    }

    class NetworkTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            String stringurl = strings[0];

            try {
                URL url = new URL(stringurl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                Scanner scanner = new Scanner(inputStream);
                scanner.useDelimiter("\\A");

                if (scanner.hasNext()){
                    String s= scanner.next();
                    return s;
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "Failed to load";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            ArrayList<GithubUser> users = parseJson(s);

            GithubUsersAdapter githubUsersAdapter = new GithubUsersAdapter(users);
            RecyclerView recyclerView = findViewById(R.id.rvUser);
            recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
            recyclerView.setAdapter(githubUsersAdapter);

//            TextView tvgetdata  =findViewById(R.id.tvdata);
//            tvgetdata.setText(s);
        }
    }

    ArrayList<GithubUser> parseJson(String s){
        ArrayList<GithubUser> githubUsers = new ArrayList<>();

        try {
            JSONObject root = new JSONObject(s);
            JSONArray items = root.getJSONArray("items");

            for (int i=0;i< items.length();i++){
                JSONObject object = items.getJSONObject(i);
                String login = object.getString("login");
                Integer id = object.getInt("id");
                String avatar = object.getString("avatar_url");
                Double score = object.getDouble("score");
                String html = object.getString("html_url");
                GithubUser githubUser = new GithubUser(login,id, html,score,avatar);
                githubUsers.add(githubUser);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  githubUsers;
    }
}