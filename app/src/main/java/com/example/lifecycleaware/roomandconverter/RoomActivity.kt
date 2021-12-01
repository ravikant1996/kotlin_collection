package com.example.lifecycleaware.roomandconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.lifecycleaware.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class RoomActivity : AppCompatActivity() {
    private lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        database = ContactDatabase.getDatabase(this)

        GlobalScope.launch() {
            database.contactDao().insertContact(
                Contact(0, "Ravi kant", "9717038110", Date(), 0)
            )
        }
    }

    fun getData(view: android.view.View) {
        database.contactDao().getContact().observe(this, Observer {
            Log.e("Database", it.toString())
        })
    }
}