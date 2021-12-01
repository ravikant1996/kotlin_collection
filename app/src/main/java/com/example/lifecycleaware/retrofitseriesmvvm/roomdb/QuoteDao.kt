package com.example.lifecycleaware.retrofitseriesmvvm.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lifecycleaware.mvvm.Quote
import com.example.lifecycleaware.retrofitseriesmvvm.Result

@Dao
interface QuoteDao {

    @Insert
    suspend fun addQuote(quotes: List<Result>)

    @Query("Select * from quote")
    suspend fun getQuotes(): List<Result>
}