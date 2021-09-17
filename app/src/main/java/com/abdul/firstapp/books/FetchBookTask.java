package com.abdul.firstapp.books;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//ip type is bookname-- string, op type is a jsonString

public class FetchBookTask extends AsyncTask<String, Void, String> {
    TextView titleTv, authorTv;

    public FetchBookTask(TextView mTitleText, TextView mAuthorText) {
        titleTv = mTitleText;
        authorTv = mAuthorText;
    }

    @Override
    protected String doInBackground(String... bookName) {
        return NetworkUtils.getBookInfo(bookName[0]);
    }

  @Override
    protected void onPostExecute(String jsonString) {
        super.onPostExecute(jsonString);

      try {
          JSONObject jsonObject = new JSONObject(jsonString);
          JSONArray weatherJsonArray = jsonObject.getJSONArray("weather");
          for(int i=0; i< weatherJsonArray.length();i++){
              JSONObject mJsonObject = weatherJsonArray.getJSONObject(i);
              String description = mJsonObject.getString("description");
              authorTv.setText(description);
          }

      } catch (JSONException e) {
          e.printStackTrace();
      }


  }
}
