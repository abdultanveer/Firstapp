package com.abdul.firstapp

import android.content.Intent
import android.net.Uri
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
        //startCounterActivity()
        startDialer()
    }

    private fun startDialer() {
        var dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9880979732")) //implicit intent
        startActivity(dialIntent)
    }

    private fun startCounterActivity() {
        var intent = Intent(this, CounterActivity::class.java) //explicit intent -- name of the class to be invoked
        var name = etName.text.toString()
        // tvRes.setText(name)
        intent.putExtra("nkey", name)
        startActivity(intent)
    }


}