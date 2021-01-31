package com.example.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val psr = PowerStartReceiver()
    val iFilter = IntentFilter().apply {
        addAction(Intent.ACTION_POWER_CONNECTED)
        addAction(Intent.ACTION_POWER_DISCONNECTED)
    }
        registerReceiver(psr,iFilter)

    }

    inner class PowerStartReceiver: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if(intent == null)return

            if(intent.action == Intent.ACTION_POWER_CONNECTED){
                tvstate.text = "CHARGER CONNECTED"
//                Toast.makeText(context,"CHARGER CONNECTED",Toast.LENGTH_SHORT).show()
            }
            if(intent.action == Intent.ACTION_POWER_DISCONNECTED){
                tvstate.text = "CHARGER DISCONNECTED"
//                Toast.makeText(context,"CHARGER DISCONNECTED",Toast.LENGTH_SHORT).show()
            }
        }

    }

}

































