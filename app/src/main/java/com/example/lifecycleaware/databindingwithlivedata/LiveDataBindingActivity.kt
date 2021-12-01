package com.example.lifecycleaware.databindingwithlivedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.lifecycleaware.R
import com.example.lifecycleaware.databinding.ActivityLiveDataBindingBinding

class LiveDataBindingActivity : AppCompatActivity() {
    lateinit var liveDataBindingViewModel: LiveDataBindingViewModel
    lateinit var binding: ActivityLiveDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_live_data_binding)
        liveDataBindingViewModel = ViewModelProvider(this)[LiveDataBindingViewModel::class.java]

//        liveDataBindingViewModel.factLiveData.observe(this, Observer {
//            binding.textView.text = it
//        })

        binding.viewmodel = liveDataBindingViewModel
        binding.lifecycleOwner = this

    }
}