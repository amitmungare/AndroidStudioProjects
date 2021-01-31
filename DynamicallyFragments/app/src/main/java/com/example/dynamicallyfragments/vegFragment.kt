package com.example.dynamicallyfragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_veg.view.*


class vegFragment : Fragment() {

    val veg = arrayOf("potato","onion","tomato")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {

        val fragmentView = inflater.inflate(R.layout.fragment_veg, container, false)
        fragmentView.lvveg.adapter = context?.let {
            ArrayAdapter<String>(
                    it,
                    android.R.layout.simple_list_item_1,
                    android.R.id.text1,
                    veg
        )
        }
        return fragmentView
    }


}