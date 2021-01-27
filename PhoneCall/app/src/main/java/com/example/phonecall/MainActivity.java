package com.example.phonecall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView etnumber;
    Button btncall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnumber =findViewById(R.id.etNumber);
        btncall = findViewById(R.id.btncall);

        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //check if we have the permission
                int perm = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE);
                if(perm == PackageManager.PERMISSION_GRANTED){
                    String telNo= etnumber.getText().toString();
                    Uri uri = Uri.parse("tel:"+telNo);
                    Intent i = new Intent(Intent.ACTION_CALL,uri);
                    startActivity(i);
                }else{
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{ Manifest.permission.CALL_PHONE }, 121);
                }

            }
        });
    }
}