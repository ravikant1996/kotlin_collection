package com.example.lifecycleaware.LiveData1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycleaware.R

class LiveData1Activity : AppCompatActivity() {

    lateinit var liveData1Activity: LiveData1ViewModel

    private val btnUpdate: Button
        get() = findViewById(R.id.btnUpdate)
    private val textView: TextView
        get() = findViewById(R.id.textView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data1)

        liveData1Activity = ViewModelProvider(this)[LiveData1ViewModel::class.java]

        liveData1Activity.factLiveData.observe(this, Observer {
            textView.text = it
        })

        btnUpdate.setOnClickListener {
            liveData1Activity.updateLiveData()
        }

    }
}