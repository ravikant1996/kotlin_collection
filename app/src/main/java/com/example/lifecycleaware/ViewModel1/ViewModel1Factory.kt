package com.example.lifecycleaware.ViewModel1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

open class ViewModel1Factory(private val counter: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ViewMode1(counter) as T
    }
}