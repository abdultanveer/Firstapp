package com.abdul.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var etName: EditText   //declartion
    lateinit var tvRes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.etName) //initialization
        tvRes = findViewById(R.id.tvResult)
    }

    fun clickHandler(view: View) {
        var intent = Intent(this,CounterActivity::class.java)
        var name = etName.text.toString()
       // tvRes.setText(name)
        intent.putExtra("nkey",name)
        startActivity(intent)
    }
}