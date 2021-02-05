package com.example.androidroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Observer

class MainActivity : AppCompatActivity() {

    val db by lazy {
        Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "User.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnsave.setOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                db.UserDao().inster(User("amit", "7875709937", "goa", 20))
            }
        }


        db.UserDao().getAllUser().observe(this, androidx.lifecycle.Observer { list ->

            if (list.isNotEmpty()) {
                with(list[list.size - 1]) {
                    tvname.text = name + id
                    tvadr.text = address
                    tvnumber.text = number
                    tvage.text = age.toString()
                }
            }

        })
    }

}
