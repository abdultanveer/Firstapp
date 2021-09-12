package com.abdul.firstapp

import android.app.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast
import java.util.*
import android.view.View
import android.media.RingtoneManager

import android.net.Uri

import android.os.Vibrator

import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService
import com.abdul.firstapp.util.Constants


class DisplayAlarmActivity : AppCompatActivity() {
    /*
    @Inject
    public lateinit var displayViewModel: DisplayAlarmViewModel
    @Inject
    public lateinit var notificationTools: NotificationTools

    private lateinit var tasksHelper: TaskViewsDisplayHelper
    */
    lateinit var btnSetAlarm: Button
    lateinit var timePicker: TimePicker
    var myCalendar = Calendar.getInstance()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_alarm)
        title = "Alarm"
        //var alarmService = AlarmService()
        /*btnSetAlarm?.setOnClickListener{
            setAlarm()
        }
        */
        timePicker = findViewById(R.id.timePicker)
        val timeInMillis = System.currentTimeMillis()
        //alarmService.setExactAlarm(timeInMillis)
        setAlarm(timeInMillis)
        //setExactAlarm(timeInMillis)
    }

    private fun setAlarm(callback: Long){
        Calendar.getInstance().apply {
            DatePickerDialog(
                this@DisplayAlarmActivity,
                0,
                { _, year, month, day ->
                    this.set(Calendar.YEAR, year)
                    this.set(Calendar.MONTH, month)
                    this.set(Calendar.DAY_OF_MONTH, day)

                    TimePickerDialog(
                        this@DisplayAlarmActivity,
                        0,
                        TimePickerDialog.OnTimeSetListener { _, hour, min ->
                            this.set(Calendar.HOUR_OF_DAY, hour)
                            this.set(Calendar.MINUTE, min)
                        },
                        this.get(Calendar.HOUR_OF_DAY),
                        this.get(Calendar.MINUTE),
                        false
                    ).show()
                },
                this.get(Calendar.YEAR),
                this.get(Calendar.MONTH),
                this.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }


    // OnToggleClicked() method is implemented the time functionality
    @RequiresApi(Build.VERSION_CODES.M)
    fun OnToggleClicked(view: View) {
        myCalendar.set(Calendar.YEAR, 2021);
        myCalendar.set(Calendar.MONTH, 9);
        myCalendar.set(Calendar.DAY_OF_MONTH, 11);
        val alarmId = System.currentTimeMillis().toInt()
        val pi = PendingIntent.getBroadcast(
            this,
            alarmId,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        if(getSystemService(ALARM_SERVICE) != null)
        {
            val manager = getSystemService(ALARM_SERVICE) as AlarmManager
            manager[AlarmManager.RTC_WAKEUP, myCalendar.getTimeInMillis()] = pi
        }

        Toast.makeText(this@DisplayAlarmActivity, "ALARM ON", Toast.LENGTH_SHORT).show()



        }
    }

class AlarmReceiver : BroadcastReceiver() {
    @RequiresApi(api = Build.VERSION_CODES.Q)  // implement onReceive() method
    override fun onReceive(context: Context, intent: Intent) {

        // we will use vibrator first
        if(context.getSystemService(Context.VIBRATOR_SERVICE) != null) {
            val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibrator.vibrate(4000)
        }

        Toast.makeText(context, "Alarm! Wake up! Wake up!", Toast.LENGTH_LONG).show()
        var alarmUri: Uri? = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        }

        // setting default ringtone
        val ringtone = RingtoneManager.getRingtone(context, alarmUri)

        // play ringtone
        ringtone.play()
    }
}

