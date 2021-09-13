package com.abdul.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button toastButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toastButton = findViewById(R.id.btnMessage);
        //clerk.getSomething(mobilePhone)
        toastButton.setOnClickListener(this); //button is user who's clicking the switch onclick

    }

    @Override
    public void onClick(View view) { //switch
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show();
       /* SmsManager  manager = SmsManager.getDefault();
        manager.sendTextMessage("5556",null,"your otp is",null,null);*/
    }
}