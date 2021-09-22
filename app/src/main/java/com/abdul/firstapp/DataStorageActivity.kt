package com.abdul.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import com.abdul.firstapp.database.NotesDao
import com.abdul.firstapp.database.model.TodoNote

class DataStorageActivity : AppCompatActivity() {

    lateinit var titleEditText: EditText
    lateinit var  notesEditText: EditText
    lateinit var rpCheckBox: CheckBox
    lateinit var notesDao: NotesDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_storage)

        titleEditText = findViewById(R.id.etTitle);
        notesEditText = findViewById(R.id.etNotes)
        rpCheckBox = findViewById(R.id.checkBoxRP)
        notesDao = NotesDao(applicationContext)
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

    fun dbHandler(view: View) {
        var title = titleEditText.text.toString()
        var notes = notesEditText.text.toString()
        var note:TodoNote = TodoNote(title, notes);

        notesDao.createRow(note)


    }
}