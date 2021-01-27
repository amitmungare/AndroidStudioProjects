package com.example.androidviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1.isVisible = true
        tv1.visibility = View.VISIBLE
        tv1.text = "Amit Mungare"
        tv1.requestFocus()

        checkBox.setOnClickListener {
            Toast.makeText(this,"hello amit",Toast.LENGTH_SHORT).show()
        }

        radiogroup.setOnCheckedChangeListener { group, checkedId ->

            when(checkedId){
                R.id.radioButton->{
                    Toast.makeText(this,"radio button 1",Toast.LENGTH_SHORT).show()
                }
                R.id.radioButton2->{
                    Toast.makeText(this,"radio button 2",Toast.LENGTH_SHORT).show()
                }
                R.id.radioButton3->{
                    Toast.makeText(this,"radio button 3",Toast.LENGTH_SHORT).show()
                }
                R.id.radioButton4->{
                    Toast.makeText(this,"radio button 4",Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}