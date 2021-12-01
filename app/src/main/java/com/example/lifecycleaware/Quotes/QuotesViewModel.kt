package com.example.lifecycleaware.Quotes

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import java.nio.charset.Charset

class QuotesViewModel(val context: Context) : ViewModel() {
    private var quoteList: Array<Quotes> = emptyArray()
    private var index = 0

    init {
        quoteList = loadQuotesFromAsset()
    }

    private fun loadQuotesFromAsset(): Array<Quotes> {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        return gson.fromJson(json, Array<Quotes>::class.java)
    }

    fun getQuotes() = quoteList[index]

    fun nextQuotes(): Quotes {
        if ((index + 1) == quoteList.size) {
            return quoteList[0]
        }
        return quoteList[++index]
    }

    fun previousQuotes(): Quotes {
        if (index == 0) {
            return quoteList[quoteList.size-1]
        }
        return quoteList[--index]
    }

}