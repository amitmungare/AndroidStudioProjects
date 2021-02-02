package com.example.datastorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_data_storage_in_kotlin.*
import java.io.File


class dataStorageInKotlin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_storage_in_kotlin)

        btnwrite.setOnClickListener {
            val dataDir = ContextCompat.getDataDir(this)
            val myFile = File(dataDir, "file1.txt")
            myFile.writeText(ettext.text.toString())
        }

        btnread.setOnClickListener {
            val dataDir = ContextCompat.getDataDir(this)
            val myFile = File(dataDir, "file1.txt")
            tvtext.text = myFile.readText()
        }

    }
}

















