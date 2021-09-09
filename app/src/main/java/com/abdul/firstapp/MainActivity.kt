package com.abdul.firstapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var etName: EditText   //declartion
    lateinit var tvRes: TextView
    lateinit var IVPreviewImage: ImageView
    private var imageUri: Uri? = null

    // One Button
    var BSelectImage: Button? = null
    val pickImage = 100
    // constant to compare
    // the activity result code
    var SELECT_PICTURE = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // register the UI widgets with their appropriate IDs
        // register the UI widgets with their appropriate IDs
        BSelectImage = findViewById(R.id.BSelectImage)
        IVPreviewImage = findViewById(R.id.imageView)

        // handle the Choose Image button to trigger
        // the image chooser function

        // handle the Choose Image button to trigger
        // the image chooser function
        //BSelectImage.setOnClickListener(View.OnClickListener { imageChooser() })
        etName = findViewById(R.id.etName) //initialization
        tvRes = findViewById(R.id.tvResult)
        title = "KotlinApp"
        BSelectImage?.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }
        Log.d("MainActivity", "Hello World")
    }

    // this function is triggered when
    // the Select Image Button is clicked
    fun imageChooser(view: android.view.View) {

        // create an instance of the
        // intent of the type image
        val i = Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE)
    }


    @Override
    public override fun onStart(){
        super.onStart()
        val LOG_TAG = "MainActivity"
        Log.d(LOG_TAG, "onStart")
    }

    fun clickHandler(view: View) {
        //startCounterActivity()
        //Implicit intent
        var dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:988097932"))
        startActivity(dialIntent)
    }

    private fun startCounterActivity() {
        //Explicit intent -- name of the class to be invoked
        var intent = Intent(this, CounterActivity::class.java)

        var name = etName.text.toString()
        /*
        Toast.makeText(this@MainActivity, name, Toast.LENGTH_LONG).show()
        tvRes.setText("Welcome " + name)
        setContentView(R.layout.logged_in)
        */
        intent.putExtra("nkey", name)
        startActivity(intent)
    }

    // this function is triggered when user
    // selects the image from the imageChooser
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            IVPreviewImage.setImageURI(imageUri)
        }
    }

}