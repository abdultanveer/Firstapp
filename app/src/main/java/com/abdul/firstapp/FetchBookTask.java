package com.abdul.firstapp;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

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
            JSONObject rootJsonObject = new JSONObject(jsonString);
            JSONArray itemsArray = rootJsonObject.getJSONArray("items");
            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject book = itemsArray.getJSONObject(i);
                String title = null;
                String authors = null;
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (title != null && authors != null) {
                    titleTv.setText(title);
                    authorTv.setText(authors);
                    return;
                }

                titleTv.setText("No Results Found");
                authorTv.setText("");

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
