package com.example.lifecycleaware.LifeCycleAware

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lifecycleaware.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(Observer())
    }
}