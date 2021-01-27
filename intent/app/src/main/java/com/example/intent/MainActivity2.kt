package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val name = intent.getStringExtra("name")
        val roll_no = intent.getIntExtra("roll_no",0)
        val pass = intent.getBooleanExtra("pass",false)
        textView.text = "$name  $roll_no  $pass"

    }



}