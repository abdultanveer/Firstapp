package com.abdul.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity  implements  View.OnClickListener{
    Button toastButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        View toastButton = findViewById(R.id.btnMessenger);
        //Clerk.getSomething(mobilePhone)
        //Button is user who's clicking the switch onClick
        toastButton.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view){
        Toast.makeText(this, "Button clicked", Toast.LENGTH_LONG).show();
    }

}