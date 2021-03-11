package com.example.networkinginkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    val originalList = arrayListOf<User>()
    val adapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter.onItemClick = {
            val intent = Intent(this, UserActivity::class.java)
            intent.putExtra("ID", it)
            startActivity(intent)
        }

        userRv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }

        searchView.isSubmitButtonEnabled=true
        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let{searchUsers(it)}
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let{searchUsers(it)}
                return true
            }
        })

        searchView.setOnCloseListener {
            adapter.swapdata(originalList)
            true
        }


        GlobalScope.launch(Dispatchers.Main) {
            val responce = withContext(Dispatchers.IO) { Client.api.getUser() }
            if (responce.isSuccessful) {
                responce.body()?.let {
                    originalList.addAll(it)
                    adapter.swapdata(it)
                }
            }
        }
    }
    fun searchUsers(query:String){

        GlobalScope.launch(Dispatchers.Main) {
            val responce = withContext(Dispatchers.IO){Client.api.searchUser(query)}
            if(responce.isSuccessful){
                responce.body()?.let {
                    it.items?.let { it1 -> adapter.swapdata(it1) }
                }
            }
        }
    }









//        val okHttpClient = OkHttpClient()
//
//        val request =  Request.Builder()
//            .url("https://api.github.com/users/amitmungare")
//            .build()
//
//        val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//                .create()


//        GlobalScope.launch(Dispatchers.Main) {
//            val response = withContext(Dispatchers.IO){okHttpClient.newCall(request).execute().body?.string()}
//
//            val user = gson.fromJson<User>(response,User::class.java)
//
//            tv1.text = user.login
//            tv2.text = user.id.toString()
//            Picasso.get().load(user.avatarUrl).into(imageView)
//
//        }


}