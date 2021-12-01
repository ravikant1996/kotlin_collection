package com.example.lifecycleaware.ViewModel1

import android.view.View
import androidx.lifecycle.ViewModel

class ViewMode1(private val initialValue: Int) : ViewModel() {
    var count: Int = initialValue

    fun increment() {
        count++
    }
}