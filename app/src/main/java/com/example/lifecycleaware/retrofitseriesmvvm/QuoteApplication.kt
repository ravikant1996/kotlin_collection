package com.example.lifecycleaware.retrofitseriesmvvm

import android.app.Application
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.lifecycleaware.retrofitseriesmvvm.roomdb.QuoteDatabase
import com.example.lifecycleaware.retrofitseriesmvvm.workmanager.QuoteWorkManager
import java.util.concurrent.TimeUnit

class QuoteApplication : Application() {
    lateinit var repository: Repository
    override fun onCreate() {
        super.onCreate()
        initialize()
        setupWorker()
    }

    private fun setupWorker() {
        val constraint = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
        val workerRequest =
            PeriodicWorkRequest.Builder(QuoteWorkManager::class.java, 2, TimeUnit.HOURS)
                .setConstraints(constraint)
                .build()
        WorkManager.getInstance(this).enqueue(workerRequest)
    }

    private fun initialize() {
        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
        val database = QuoteDatabase.getDatabase(applicationContext)
        repository = Repository(quotesApi, database, applicationContext)
    }
}