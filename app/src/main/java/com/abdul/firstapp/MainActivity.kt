package com.abdul.firstapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var etName: EditText   //declartion
    lateinit var tvRes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.etName) //initialization
        tvRes = findViewById(R.id.tvResult)
        Log.d("MainActivity", "Hello World")
    }

    @Override
    public override fun onStart(){
        super.onStart()
        val LOG_TAG = "MainActivity"
        Log.d(LOG_TAG, "onStart")
    }

    fun clickHandler(view: View) {
        //startCounterActivity()
        //Implicit intent
        var dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:988097932"))
        startActivity(dialIntent)
    }

    private fun startCounterActivity() {
        //Explicit intent -- name of the class to be invoked
        var intent = Intent(this, CounterActivity::class.java)

        var name = etName.text.toString()
        /*
        Toast.makeText(this@MainActivity, name, Toast.LENGTH_LONG).show()
        tvRes.setText("Welcome " + name)
        setContentView(R.layout.logged_in)
        */
        intent.putExtra("nkey", name)
        startActivity(intent)
    }

}