package com.abdul.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class CounterActivity : AppCompatActivity() {
    var TAG = CounterActivity::class.java.simpleName
    //TODO: Add Abdullah's method!
    lateinit var tvCounter: TextView
    var counter = 0
    lateinit var etContact:EditText

    fun add(){

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)
        Log.i(TAG,"oncreate")
        tvCounter = findViewById(R.id.tvCounter)
        etContact = findViewById(R.id.etContact)
       /* var name = intent.getStringExtra("nkey")
        tvCounter.setText(name)*/
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG,"onstart")

    }

    override fun onPause() {
        super.onPause()
        Log.w(TAG,"onpause")
    }

    override fun onResume() {
        super.onResume()
        Log.w(TAG,"onResume")

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onstop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"ondestroy")

    }




    fun updateCounter(view: View) {
        var currentValue = Integer.parseInt(tvCounter.text.toString())
        tvCounter.setText(""+counter++)
    }

    fun showToast(view: View) {
        var contact = etContact.text.toString()
        var intent = Intent()
        intent.putExtra("ckey",contact)
        setResult(RESULT_OK,intent)
        finish()
        //Toast.makeText(this,""+counter++,Toast.LENGTH_SHORT).show()
    }
}