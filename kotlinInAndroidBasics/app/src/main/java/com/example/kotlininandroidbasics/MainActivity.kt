package com.example.kotlininandroidbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener({

            val a = editTextNumber.text.toString().toInt()
            val b = editTextNumber2.text.toString().toInt()

            val result = a + b
            textView.text=result.toString()
        })

    }


}