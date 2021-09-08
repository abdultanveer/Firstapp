package com.abdul.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class CounterActivity : AppCompatActivity() {
    lateinit var tvCounter: TextView
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)
        tvCounter = findViewById(R.id.tvCounter)
        var name = intent.getStringExtra("nkey")
        tvCounter.setText(name)
    }

    fun updateCounter(view: View) {
        var currentValue = Integer.parseInt(tvCounter.text.toString())
        tvCounter.setText(""+counter++)
    }

    fun showToast(view: View) {
        Toast.makeText(this,""+counter++,Toast.LENGTH_SHORT).show()
    }
}