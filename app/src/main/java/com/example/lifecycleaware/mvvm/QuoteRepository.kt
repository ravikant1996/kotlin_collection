package com.example.lifecycleaware.mvvm

import androidx.lifecycle.LiveData
import androidx.room.Insert

class QuoteRepository(private val quoteDao: QuoteDao) {

    fun getQuote(): LiveData<List<Quote>> {
        return quoteDao.getQuote()
    }

    suspend fun insertQuote(quote: Quote) {
        quoteDao.insertQuote(quote)
    }
}