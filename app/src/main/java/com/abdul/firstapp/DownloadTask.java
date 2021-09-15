package com.abdul.firstapp;


import android.os.AsyncTask;
import android.util.Log;

//input type = url= string, progress type = int, result type
public class DownloadTask extends AsyncTask<String,Integer,Void> {
    public static String TAG = DownloadTask.class.getSimpleName();

    @Override
    protected Void doInBackground(String... strings) { //this method will run on a background thread
        Log.i(TAG,"downloading--"+strings[0]);
        return null;
    }
}
