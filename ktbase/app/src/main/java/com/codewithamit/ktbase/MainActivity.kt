package com.codewithamit.ktbase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

//import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (findViewById<Button>(R.id.button)).setOnClickListener(View.OnClickListener{

//            val result = editTextNumber.text.toString().toInt() + editTextNumber2.text.toString().toInt()
//            textView2.text=result.toString()

//            Toast.makeText(this@MainActivity, "welcome", Toast.LENGTH_SHORT).show()
        })


    }
}