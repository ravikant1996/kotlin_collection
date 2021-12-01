package com.example.lifecycleaware.Quotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycleaware.R

class QuotesActivity : AppCompatActivity() {
    lateinit var quotesViewModel: QuotesViewModel

    private val quotesText: TextView get() = findViewById(R.id.quoteText)
    private val quoteAuthor: TextView get() = findViewById(R.id.quoteAuthor)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        quotesViewModel = ViewModelProvider(
            this,
            QuotesViewModelFactory(application)
        )[QuotesViewModel::class.java]

        setQuotes(quotesViewModel.getQuotes())
    }

    private fun setQuotes(quotes: Quotes) {
        quotesText.text = quotes.text
        quoteAuthor.text = quotes.author
    }

    fun onPrevious(view: View) {
        setQuotes(
            quotesViewModel.previousQuotes()
        )
    }

    fun onNext(view: View) {
        setQuotes(
            quotesViewModel.nextQuotes()
        )
    }

    fun onShare(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "tΘxt/plain"
        intent.putExtra(Intent.EXTRA_TEXT, quotesViewModel.getQuotes().text)
        startActivity(intent)
    }
}