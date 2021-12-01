package com.example.lifecycleaware.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycleaware.R
import com.example.lifecycleaware.databinding.ActivityMvvmactivityBinding

class MVVMActivity : AppCompatActivity() {
    lateinit var binding: ActivityMvvmactivityBinding
    lateinit var viewModel: MVVMViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvmactivity)

        val dao = QuoteDatabase.getDatabase(applicationContext).quoteDao()
        val repository = QuoteRepository(dao)
        viewModel =
            ViewModelProvider(this, MVVMViewModeFactory(repository)).get(MVVMViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer {
            binding.quotes = it.toString()
        })
        binding.insert.setOnClickListener {
            val quote = Quote(0, "This is new quote", "Inserted")
            viewModel.insertQuotes(quote)
        }
    }
}