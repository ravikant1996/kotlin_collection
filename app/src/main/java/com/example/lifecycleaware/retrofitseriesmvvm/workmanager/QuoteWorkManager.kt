package com.example.lifecycleaware.retrofitseriesmvvm.workmanager

import android.content.Context
import android.content.ContextParams
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.lifecycleaware.retrofitseriesmvvm.QuoteApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteWorkManager(private val context: Context, params: WorkerParameters) :
    Worker(context, params) {
    override fun doWork(): Result {
        Log.e("Worker manager", "Called")
        val repository = (context as QuoteApplication).repository
        CoroutineScope(Dispatchers.IO).launch {
            repository.getQuoteBackground()
        }
        return Result.success()
    }
}