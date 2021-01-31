package com.example.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nm: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            nm.createNotificationChannel(NotificationChannel("first", "default" , NotificationManager.IMPORTANCE_DEFAULT))
//        }


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = (NotificationChannel("first", "default" , NotificationManager.IMPORTANCE_HIGH))
            channel.apply {
                enableLights(true)
                enableVibration(true)
            }
            nm.createNotificationChannel(channel)
        }


        button1.setOnClickListener {

            val builder =
                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
                    Notification.Builder(this,"first")
                }else{
                    Notification.Builder(this)
                        .setPriority(Notification.PRIORITY_MAX)
                        .setDefaults(Notification.DEFAULT_VIBRATE or Notification.DEFAULT_LIGHTS)
                }

            val snof  = builder
                .setContentTitle("Simple Title")
                .setContentText("amit mungare")
                .setSmallIcon(R.drawable.nof)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()

            nm.notify(1,snof)
        }

        button2.setOnClickListener {
            val i = Intent()
            i.action = Intent.ACTION_VIEW
            i.data = Uri.parse("https://www.google.com")

            val pi = PendingIntent.getActivity(this,123,i,PendingIntent.FLAG_UPDATE_CURRENT)

            val cnof  = NotificationCompat.Builder(this,"first")
                .setContentTitle("Simple Title")
                .setContentIntent(pi)
                .setAutoCancel(true)
                .setContentText("amit mungare")
                .setSmallIcon(R.drawable.nof)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()

            nm.notify(2,cnof)


        }

        button3.setOnClickListener {
            val i = Intent()
            i.action = Intent.ACTION_VIEW
            i.data = Uri.parse("https://www.google.com")

            val pi = PendingIntent.getActivity(this,123,i,PendingIntent.FLAG_UPDATE_CURRENT)

            val cnof  = NotificationCompat.Builder(this,"first")
                .setContentTitle("Simple Title")
                .addAction(R.drawable.nof,"Click Me",pi)
                .setAutoCancel(true)
                .setContentText("amit mungare")
                .setSmallIcon(R.drawable.nof)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()

            nm.notify(3,cnof)


        }

    }
}