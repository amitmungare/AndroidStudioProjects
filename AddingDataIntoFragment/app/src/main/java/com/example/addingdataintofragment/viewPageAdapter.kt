package com.example.addingdataintofragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class viewPageAdapter(fm:FragmentManager):FragmentStatePagerAdapter(fm) {

    val list = arrayListOf<Fragment>()

    fun add(fragment: Fragment){
        list.add(fragment)
    }

    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Fragment {
        return list[position]
    }


}