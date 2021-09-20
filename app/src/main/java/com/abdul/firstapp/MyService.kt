package com.abdul.firstapp

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    var TAG = MyService::class.java.simpleName
    override fun onCreate() {
        super.onCreate()
        Log.i(TAG,"service created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
         super.onStartCommand(intent, flags, startId)
        var name = intent?.getStringExtra("musicfile")
        Log.i(TAG,"i am going to play--"+name)
        var mediaPlayer: MediaPlayer = MediaPlayer.create(this,R.raw.music)
        mediaPlayer.start()
        return START_STICKY

    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"service destroyed")

    }
}