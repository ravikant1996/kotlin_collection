package com.example.lifecycleaware.databindingadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.lifecycleaware.R
import com.example.lifecycleaware.databinding.ActivityBindingAdapterBinding

class BindingAdapterActivity : AppCompatActivity() {
    lateinit var binding: ActivityBindingAdapterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding_adapter)

        val post = Post(
            "Introduction to Kotlin",
            "Kotlin is a very easy language",
            "https://ih1.redbubble.net/image.1060767194.0684/pp,840x830-pad,1000x1000,f8f8f8.jpg"
        )

        binding.post = post
    }
}