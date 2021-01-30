package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_count_down.view.*


class CountDownFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        var count =0
        val fragmentView = inflater.inflate(R.layout.fragment_count_down, container, false)

        fragmentView.btndec.setOnClickListener {
            count--
            fragmentView.tvcountdown.text = count.toString()
        }

        return fragmentView
    }


}