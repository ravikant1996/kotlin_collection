package com.example.lifecycleaware.LiveData1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveData1ViewModel : ViewModel() {
    val factLiveData = MutableLiveData<String>("This is a fact")
    val liveData: LiveData<String>
        get() = factLiveData

    fun updateLiveData() {
        factLiveData.value = "Another fact"
    }

}