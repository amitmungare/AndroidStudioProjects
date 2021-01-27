package com.example.seetry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addnum.setOnClickListener( {
            val result = num1.text.toString().toInt() + num2.text.toString().toInt()
            textView2.text = result.toString()
        })


    }

//    fun addnum(view: View) {
//
//        val num1=0;
//        val result = num1.text.toString().toInt() + num2.text.toString().toInt()
//        textView2.text = result.toString()
//
//    }


}