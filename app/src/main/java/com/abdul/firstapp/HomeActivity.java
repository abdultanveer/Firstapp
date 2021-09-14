package com.abdul.firstapp;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static java.sql.DriverManager.println;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button toastButton;
    //Data-- plug
    String[] languages  = {"Arabic", "English"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Android Cafe");
        /*try {
            //throw IllegalStateException();
            //println("Hello World")
        } catch (exc: Throwable) {
            println("Something went wrong")
        }*/
        //Layout inflater
        setContentView(R.layout.activity_home);
        //Socket
        ListView langsListView = findViewById(R.id.languageslv);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,languages);
        langsListView.setAdapter(adapter);

        View toastButton = findViewById(R.id.btnMessenger);
        //Clerk.getSomething(mobilePhone)
        //Button is user who's clicking the switch onClick
        toastButton.setOnClickListener((View.OnClickListener) this);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerCountries);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        //spinner.

    }
    @Override
    public void onClick(View view){
        Toast.makeText(this, "Button clicked", Toast.LENGTH_LONG).show();
        //Intent i = new Intent(HomeActivity.this, MainActivity.class);
        //String strName = null;
        //i.putExtra("Gender", strName);

        //String newString;
        /*
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("STRING_I_NEED");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("STRING_I_NEED");
        }
        */
        //Toast.makeText(this, "Gender: " + spinner., Toast.LENGTH_LONG).show();
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
        //Toast.makeText(this, "Item was selected!",Toast.LENGTH_LONG).show();
        String itemSelected = parent.getSelectedItem().toString();
        Toast.makeText(this, itemSelected, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Button mButton = new Button(this);
        mButton.setText("send");
        mButton.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        ConstraintLayout cl = findViewById(R.id.homeConstraintLayout);
        cl.addView(mButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.home_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.miFirst:
                Toast.makeText(this, "first", Toast.LENGTH_SHORT).show();
                break;
            case R.id.miSecond:
                Toast.makeText(this, "second", Toast.LENGTH_SHORT).show();

                break;
            case R.id.miThird:
                Toast.makeText(this, "third", Toast.LENGTH_SHORT).show();

                break;
        }
        return true;
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