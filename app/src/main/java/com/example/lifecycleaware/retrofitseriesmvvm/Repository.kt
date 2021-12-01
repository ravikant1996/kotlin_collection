package com.example.lifecycleaware.retrofitseriesmvvm

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.lifecycleaware.retrofitseriesmvvm.Utill.NetworkUtil
import com.example.lifecycleaware.retrofitseriesmvvm.roomdb.QuoteDatabase
import com.example.lifecycleaware.retrofitseriesmvvm.sealedclass.Response

class Repository(
    private val quotesApi: QuotesApi,
    private val quoteDatabase: QuoteDatabase,
    private val applicationContext: Context
) {

    private val quoteLiveData = MutableLiveData<Response<QuoteList>>()

    val quotes: LiveData<Response<QuoteList>>
        get() = quoteLiveData


    suspend fun getQuotes(page: Int) {
        if (NetworkUtil.isInternetAvailable(applicationContext)) {
            try {
                val result = quotesApi.getQuotes(page)
                if (result.body() != null) {
                    quoteDatabase.quoteDao().addQuote(result.body()!!.results)
                    quoteLiveData.postValue(Response.Success(result.body()))
                } else {
                    quoteLiveData.postValue(Response.Failure("api error"))
                }
            } catch (e: Exception) {
                quoteLiveData.postValue(Response.Failure(e.message.toString()))
            }
        } else {
            val quotes = quoteDatabase.quoteDao().getQuotes()
            val quoteList = QuoteList(1, 1, 1, quotes, 1, 1)
            quoteLiveData.postValue(Response.Success(quoteList))
        }
    }

    suspend fun getQuoteBackground() {
        val randomNumber = (Math.random()).toInt()
        val result = quotesApi.getQuotes(randomNumber)
        if (result.body() != null) {
            quoteDatabase.quoteDao().addQuote(result.body()!!.results)
        }
    }
}