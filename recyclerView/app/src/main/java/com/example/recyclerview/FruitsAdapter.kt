package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_fruits.view.*

class FruitsAdapter(
    val fruits: ArrayList<Fruits>
) : RecyclerView.Adapter<FruitsAdapter.FruitViewHolder>(){

    class FruitViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_fruits,parent,false
        )
        return FruitViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {

        holder.itemView.tvfruitname.text = fruits[position].name
        holder.itemView.tvorigin.text = fruits[position].origin
        holder.itemView.tvqunitity.text = fruits[position].quantity.toString()
    }

    override fun getItemCount(): Int {
        return fruits.size
    }

}
