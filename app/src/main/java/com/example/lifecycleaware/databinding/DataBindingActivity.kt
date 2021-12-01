package com.example.lifecycleaware.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.lifecycleaware.R

class DataBindingActivity : AppCompatActivity() {
    lateinit var binding: ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)

        val bindData = BindData("This is title of data binding", "This is Body of data binding")
//        binding.textView.text = "This is title of data binding"
//        binding.btnUpdate.text = "This is Body of data binding"
        binding.bind = bindData
    }
}