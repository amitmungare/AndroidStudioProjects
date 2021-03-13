package com.example.jetpacks.ui

import android.icu.util.TimeUnit
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.jetpacks.GithubWorker
import com.example.jetpacks.R
import kotlinx.android.synthetic.main.activity_main.*
import javax.xml.datatype.DatatypeConstants.DAYS
import javax.xml.datatype.DatatypeConstants.HOURS

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        workerBtn.setOnClickListener {
            setupGithubWorker()
        }
    }

    private fun setupGithubWorker() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .build()

//        val worker = OneTimeWorkRequestBuilder<GithubWorker>()
//                .setInitialDelay(5,TimeUnit.SECONDS)
//                .setConstraints(constraints)
//                .build()

        val worker = PeriodicWorkRequestBuilder<GithubWorker>(1, java.util.concurrent.TimeUnit.DAYS)
            .setInitialDelay(8, java.util.concurrent.TimeUnit.HOURS)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(this).enqueue(worker)

    }
}