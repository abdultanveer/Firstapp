package com.abdul.firstapp

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity(){
    lateinit var wordsRecyclerView: RecyclerView
    var words = arrayOf("first","second","third")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        wordsRecyclerView = findViewById(R.id.wordsRecyclerview)
        var adapter = WordsAdapter(words)
        wordsRecyclerView.layoutManager = LinearLayoutManager(this)
        wordsRecyclerView.adapter = adapter
    }
}