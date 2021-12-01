package com.example.lifecycleaware.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycleaware.ViewModel1.ViewModel1Factory

class MVVMViewModeFactory(private val repository: QuoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MVVMViewModel(repository) as T
    }

}