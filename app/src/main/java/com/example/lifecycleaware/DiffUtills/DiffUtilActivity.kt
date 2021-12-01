package com.example.lifecycleaware.DiffUtills

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lifecycleaware.R

class DiffUtilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff_util)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        val adapter = ProgrammingAdapter()
        val p1 = ProgramItems(1, "A", "Angular")
        val p2 = ProgramItems(2, "B", "Bash")
        val p3 = ProgramItems(3, "C", "Kotlin")

        adapter.submitList(listOf(p1, p2, p3))
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val p3 = ProgramItems(3, "C", "CPP")
            val p4 = ProgramItems(4, "D", "Docker")
            val p5 = ProgramItems(5, "E", "Elastic")
            val p6 = ProgramItems(6, "F", "Future")
            val p2 = ProgramItems(2, "B", "Bash")

            adapter.submitList(listOf(p2, p3, p4, p5, p6))
        }, 4000)
    }
}