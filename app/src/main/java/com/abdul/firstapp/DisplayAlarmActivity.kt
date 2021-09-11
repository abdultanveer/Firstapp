package com.abdul.firstapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class DisplayAlarmActivity : AppCompatActivity() {
    /*
    @Inject
    public lateinit var displayViewModel: DisplayAlarmViewModel
    @Inject
    public lateinit var notificationTools: NotificationTools

    private lateinit var tasksHelper: TaskViewsDisplayHelper
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_alarm)

        //Get reference to button
        val selectTime = findViewById(R.id.selectTime) as Button
        //Get reference to text view
        val timeTv = findViewById(R.id.timeTv) as TextView

        //Button click to show TimePicker Dialog
        selectTime.setOnClickListener {
            Toast.makeText(this,"Selecting time...", Toast.LENGTH_LONG).show()
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker,
                                                                       hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                //Set time to textView
                timeTv.text  = SimpleDateFormat("HH:mm").format(cal.time)

                //var myStringInfo = SimpleDateFormat("HH:mm").format(cal.time)

                // After button click - open dialog
            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }
    }
}