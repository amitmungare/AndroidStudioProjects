package com.example.slidingoptionusingfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val viewpageradapter = viewPageAdapter(supportFragmentManager)
        viewpageradapter.apply {
            list.add(oneFragment())
            list.add(twoFragment())
            list.add(threeFragment())
            list.add(fourFragment())
        }
        viewpager.adapter = viewpageradapter
    }


    class viewPageAdapter (fm: FragmentManager): FragmentStatePagerAdapter(fm){

        val list = arrayListOf<Fragment>()

        fun add(fragment: Fragment){
            list.add(fragment)
        }

        override fun getCount(): Int =list.size

        override fun getItem(position: Int): Fragment {
            return list[position]
        }

    }

}