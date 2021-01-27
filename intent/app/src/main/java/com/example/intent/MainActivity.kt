package com.example.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnmail.setOnClickListener {
            val email =editText.text.toString()
            val i=Intent()
            i.action=Intent.ACTION_SENDTO
            i.data = Uri.parse(("mailto:$email"))
            startActivity(i)
        }

        btnbrw.setOnClickListener {
            val address =editText.text.toString()
            val i=Intent()
            i.action=Intent.ACTION_VIEW
            i.data = Uri.parse(("https://$address"))
            startActivity(i)
        }

        btndial.setOnClickListener {
            val num =editText.text.toString()
            val i=Intent()
            i.action=Intent.ACTION_DIAL
            i.data = Uri.parse(("tel://$num"))
            startActivity(i)
        }

    }

    fun btnclick(view: View) {
        val i = Intent(this, MainActivity2::class.java)
        i.putExtra("name","sam")
        i.putExtra("roll_no",12)
        i.putExtra("pass",true)
        startActivity(i)
    }
}