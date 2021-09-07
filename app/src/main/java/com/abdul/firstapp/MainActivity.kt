package com.abdul.firstapp

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

    fun clickHandler(view: View) {
        var name = etName.text.toString()
        Toast.makeText(this@MainActivity, name, Toast.LENGTH_LONG).show()
        tvRes.setText("Welcome " + name)
        setContentView(R.layout.logged_in)
    }
}