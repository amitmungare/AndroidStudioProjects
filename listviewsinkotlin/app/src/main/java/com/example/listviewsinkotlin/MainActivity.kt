package com.example.listviewsinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fruitslistnames.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lvfruits.adapter = ArrayAdapter<String>(
            this,
            R.layout.fruitslistnames,
            R.id.fruitsnames,
            arrayOf("Apple","mango")
        )

        //on click listener
        lvfruits.setOnItemClickListener { parent,view, position, id ->
            Toast.makeText(this,"$position ${view.fruitsnames.text}",Toast.LENGTH_SHORT).show()
        }

    }
}