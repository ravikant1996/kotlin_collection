package com.example.lifecycleaware.mvvm

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {

    @Query("Select * from quote")
    fun getQuote(): LiveData<List<Quote>>

    @Insert
    fun insertQuote(quote: Quote)
}