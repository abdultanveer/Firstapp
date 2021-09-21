package com.abdul.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText

class DataStorageActivity : AppCompatActivity() {

    lateinit var titleEditText: EditText
    lateinit var  notesEditText: EditText
    lateinit var rpCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_storage)

        titleEditText = findViewById(R.id.etTitle);
        notesEditText = findViewById(R.id.etNotes)
        rpCheckBox = findViewById(R.id.checkBoxRP)
    }

    override fun onPause() {
        super.onPause()
        storeData()
    }

    private fun storeData() {
        //get the text/data from those 2 edittexts
        var title = titleEditText.text.toString()
        var notes = notesEditText.text.toString()
        var isChecked: Boolean = rpCheckBox.isChecked
        //create a file
        var sharedPreferences = getSharedPreferences("myfilename", MODE_PRIVATE)
        //open the file in edit mode
        var editor = sharedPreferences.edit()
        //write to the file
        editor.putString("mtitle",title)
        editor.putString("mnotes",notes)
        editor.putBoolean("rpCb",isChecked)
        //save the file
        editor.apply()
    }

    override fun onResume() {
        super.onResume()
        restoreData()
    }

    private fun restoreData() {
        //open the file
        var sharedPreferences = getSharedPreferences("myfilename", MODE_PRIVATE)
        //read data from file
        var title = sharedPreferences.getString("mtitle","")
        var notes = sharedPreferences.getString("mnotes","")
        var isChecked: Boolean = sharedPreferences.getBoolean("rpCb",false)
        rpCheckBox.isChecked = isChecked
        //write to the edittexts
        titleEditText.setText(title)
        notesEditText.setText(notes)
    }
}