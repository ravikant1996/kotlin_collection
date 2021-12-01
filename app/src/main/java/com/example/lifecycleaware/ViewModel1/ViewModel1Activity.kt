package com.example.lifecycleaware.ViewModel1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycleaware.R

class ViewModel1Activity : AppCompatActivity() {
    lateinit var txtCounter: TextView
    lateinit var viewMode1: ViewMode1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model1)
        viewMode1 = ViewModelProvider(this, ViewModel1Factory(15))[ViewMode1::class.java]

        txtCounter = findViewById(R.id.textView)
        setText()
    }

    private fun setText() {
        txtCounter.text = viewMode1.count.toString()
    }

    fun increment(view: View) {
        viewMode1.increment()
        setText()
    }
}