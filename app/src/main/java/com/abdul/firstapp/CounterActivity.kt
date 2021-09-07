package com.abdul.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast

class CounterActivity : AppCompatActivity() {
    private val LOG_TAG: String = "CounterActivity"
    lateinit var tvCounter: TextView
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val LOG_TAG = "onCreate"
        Log.d(LOG_TAG, "------")
        Log.d(LOG_TAG, "onCreate")
        setContentView(R.layout.activity_counter)
        tvCounter = findViewById(R.id.tvCounter)
    }

    fun updateCounter(view: android.view.View) {
        var currentValue = Integer.parseInt(tvCounter.text.toString())
        tvCounter.setText("" + ++counter)
        Log.d("CounterActivity", "updateCounter: current value" + counter)
    }

    fun showToast(view: android.view.View) {
        updateCounter(view)
        tvCounter.setText("" + counter)
        Toast.makeText(this, "" + counter, Toast.LENGTH_SHORT).show()
        Log.d("CounterActivity", "updateCounter: current value")
    }

    fun returnReply(){
        Log.d(LOG_TAG, "End counter activity")
    }
}