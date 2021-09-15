package com.abdul.firstapp;


import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

//input type = url= string, progress type = int, result type
public class DownloadTask extends AsyncTask<String,Integer,Void> {
    public static String TAG = DownloadTask.class.getSimpleName();
    ProgressBar progressBar;

    public DownloadTask(ProgressBar mProgressBar) {
        progressBar = mProgressBar;
    }

    @Override
    protected Void doInBackground(String... strings) { //this method will run on a background worker thread
        Log.i(TAG,"downloading--"+strings[0]);
        publishProgress(75); //sending a message
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) { //receiving message -- this method runs on ui thread
        super.onProgressUpdate(values);
        progressBar.setProgress(values[0]);
    }
}
