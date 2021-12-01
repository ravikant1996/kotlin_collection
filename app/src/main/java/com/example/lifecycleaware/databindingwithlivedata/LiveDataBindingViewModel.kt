package com.example.lifecycleaware.databindingwithlivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataBindingViewModel : ViewModel() {
    val factLiveData = MutableLiveData<String>("This is a fact")
    val liveData: LiveData<String>
        get() = factLiveData

    fun updateLiveData() {
        factLiveData.value = "Another fact"
    }

}