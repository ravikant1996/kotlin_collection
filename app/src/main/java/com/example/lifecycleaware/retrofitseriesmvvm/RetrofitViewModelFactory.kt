package com.example.lifecycleaware.retrofitseriesmvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RetrofitViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RetrofitViewModel(repository) as T
    }
}