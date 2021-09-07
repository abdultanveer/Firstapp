package com.abdul.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast

class CounterActivity : AppCompatActivity() {
    lateinit var tvCounter: TextView
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)
        tvCounter = findViewById(R.id.tvCounter)
    }

    fun updateCounter(view: android.view.View) {
        var currentValue = Integer.parseInt(tvCounter.text.toString())
        counter++
        tvCounter.setText("" + counter)
        Log.d("CounterActivity", "updateCounter: current value" + counter)
    }

    fun showToast(view: android.view.View) {
        updateCounter(view)
        tvCounter.setText("" + counter)
        Toast.makeText(this, "" + counter, Toast.LENGTH_SHORT).show()
        Log.d("CounterActivity", "updateCounter: current value")
    }
}