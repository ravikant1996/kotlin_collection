package com.example.lifecycleaware.retrofitseriesmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycleaware.R
import com.example.lifecycleaware.retrofitseriesmvvm.sealedclass.Response
import kotlinx.coroutines.*
import java.lang.StringBuilder

class Retrofit1Activity : AppCompatActivity() {
    lateinit var retrofitViewModel: RetrofitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit1)
        val textView: TextView = findViewById<TextView>(R.id.textView)

        val repository = (application as QuoteApplication).repository
        retrofitViewModel = ViewModelProvider(
            this,
            RetrofitViewModelFactory(repository)
        )[RetrofitViewModel::class.java]

        retrofitViewModel.quotes.observe(this, Observer { it ->
            when (it) {
                is Response.Loading -> {
                    Toast.makeText(this@Retrofit1Activity, "Loading", Toast.LENGTH_SHORT)
                        .show()
                }
                is Response.Success -> {
                    it.data.let {
                        Toast.makeText(
                            this@Retrofit1Activity,
                            it!!.results.size.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                        textView.text = it.results.toString()
                    }
                }
                is Response.Failure -> {
                    Toast.makeText(this@Retrofit1Activity, it.errorMessage, Toast.LENGTH_SHORT)
                        .show()
                }
            }
//            Log.e("QuoteList", it.toString())
//            textView.text = it.results.toString()
        })

//        GlobalScope.launch {
//            val result = quotesApi.getQuotes(1)
//            if (result != null) {
//                val quoteList = result.body()
////                var stringBuilder = StringBuilder()
//                quoteList!!.results.forEach {
//                    Log.e("results", it.author)
////                    stringBuilder.append(it.author)
//                }
////                GlobalScope.launch(Dispatchers.Main) {
////                    textView.text = quoteList.toString()
////                }
//            } else {
//                Log.e("results", "null")
//            }
//        }
    }
}