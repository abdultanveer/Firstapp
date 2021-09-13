package com.abdul.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button toastButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        View toastButton = findViewById(R.id.btnMessenger);
        //Clerk.getSomething(mobilePhone)
        //Button is user who's clicking the switch onClick
        toastButton.setOnClickListener((View.OnClickListener) this);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerCountries);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

    }

    @Override
    public void onClick(View view){
        Toast.makeText(this, "Button clicked", Toast.LENGTH_LONG).show();
        /*
        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage("5556", null, "Your top is", null, null);
        */
    }

    /**
     * <p>Callback method to be invoked when an item in this view has been
     * selected. This callback is invoked only when the newly selected
     * position is different from the previously selected position or if
     * there was no selected item.</p>
     * <p>
     * Implementers can call getItemAtPosition(position) if they need to access the
     * data associated with the selected item.
     *
     * @param parent   The AdapterView where the selection happened
     * @param view     The view within the AdapterView that was clicked
     * @param position The position of the view in the adapter
     * @param id       The row id of the item that is selected
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Item was selected!",Toast.LENGTH_LONG).show();
    }

    /**
     * Callback method to be invoked when the selection disappears from this
     * view. The selection can disappear for instance when touch is activated
     * or when the adapter becomes empty.
     *
     * @param parent The AdapterView that now contains no selected item.
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}