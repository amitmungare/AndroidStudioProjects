package com.example.addingdataintofragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bundle =Bundle()
        bundle.putString("KEY", "Amit")
        val fragment = FirstFragment()
        fragment.arguments = bundle

//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.flcontainer,fragment)
//            .commit()


        val viewPageAdapter = viewPageAdapter(supportFragmentManager)
        viewPageAdapter.apply {
            add(fragment)
            add(oneFragment())
            add(twoFragment())
        }
        viewpager.adapter =viewPageAdapter

    }
}