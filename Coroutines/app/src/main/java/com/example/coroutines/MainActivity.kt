package com.example.coroutines

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private  lateinit var counterTask: CounterTask

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnstart.setOnClickListener {
            val n = etnumber.text.toString().toInt()
            counterTask=CounterTask()
            counterTask.execute(n)
        }

        btnstop.setOnClickListener {
            counterTask.cancel(false)
        }

    }


    inner class CounterTask : CoroutineAsyncTask<Int, Int, String>() {

        override fun doInBackground(vararg params: Int?): String {
            var count = params[0] ?: 0
            while (count >= 0) {
                if (isCancelled) {
                    return "STOPPED"
                }
                Thread.sleep(1000)
                publishProgress(count--)
            }
            return "DONE"
        }

        override fun onProgressUpdate(vararg values: Int?) {
            val progress = values[0] ?: 0
            tvready.text = progress.toString()
        }


            override fun onPostExecute(result: String?) {
            super.onProgressUpdate()
            tvready.text = result
        }

        override fun onCancelled(result: String?) {
            super.onCancelled(result)
            tvready.text = result
        }
    }
}



