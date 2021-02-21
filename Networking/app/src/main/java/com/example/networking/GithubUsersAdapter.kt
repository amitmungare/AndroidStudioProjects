package com.example.networking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class GithubUsersAdapter(private val githubUser: ArrayList<GithubUser>):RecyclerView.Adapter<GithubUsersAdapter.GithubViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
            GithubViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_row,parent,false))

    override fun getItemCount()=githubUser.size

    override fun onBindViewHolder(holder: GithubUsersAdapter.GithubViewHolder, position: Int) {
        holder?.bind(githubUser[position])
    }

    class GithubViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {

        fun bind(githubUser: GithubUser){
            itemView?.tvlogin?.text = githubUser.login
            itemView?.tvScore?.text = githubUser.score.toString()
            itemView?.tvUrl?.text = githubUser.html_url
        }
    }

}
