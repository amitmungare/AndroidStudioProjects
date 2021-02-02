package com.example.sharepreferences

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var sp = getPreferences(Context.MODE_PRIVATE)

        var color = sp.getInt("COLOR",Color.WHITE)
        llbackground.setBackgroundColor(color)

        fun saveColor(color: Int){
            var editor = sp.edit()
            editor.putInt("COLOR",color)
            editor.apply()
        }

        btnred.setOnClickListener {
            llbackground.setBackgroundColor(Color.RED)
            saveColor(Color.RED)
        }

        btnblue.setOnClickListener {
            llbackground.setBackgroundColor(Color.BLUE)
            saveColor(Color.BLUE)
        }

        btngreen.setOnClickListener {
            llbackground.setBackgroundColor(Color.GREEN)
            saveColor(Color.GREEN)
        }

    }
}