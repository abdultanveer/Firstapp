package com.abdul.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class CounterActivity : AppCompatActivity() {
    //private val LOG_TAG: String = "CounterActivity"
    var TAG = CounterActivity::class.java.simpleName
    lateinit var etContact: EditText
    lateinit var tvCounter: TextView
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val LOG_TAG = "onCreate"
        Log.d(LOG_TAG, "------")
        Log.d(LOG_TAG, "onCreate")
        setContentView(R.layout.activity_counter)
        tvCounter = findViewById(R.id.tvCounter)

        //tvCounter.setText(name)
        etContact = findViewById(R.id.contactID)
        //var name = intent.getStringExtra("nkey")
    }
    override fun onStart() {
      super.onStart()
      Log.e(TAG, "onStart")
    }

  override fun onPause() {
      super.onPause()
      Log.e(TAG, "onPause")
  }

  override fun onStop() {
      super.onStop()
      Log.e(TAG, "onStop")
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
        Log.d(TAG, "End counter activity")
    }
}