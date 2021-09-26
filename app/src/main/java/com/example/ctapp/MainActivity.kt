package com.example.ctapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.clevertap.android.sdk.CleverTapAPI
import java.util.*
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    var cleverTapDefaultInstance: CleverTapAPI? = null
    lateinit var editText: EditText
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cleverTapDefaultInstance = CleverTapAPI.getDefaultInstance(applicationContext)
        editText = findViewById(R.id.input_field)
        button = findViewById(R.id.buttonclick)
        button.setOnClickListener {
            sendEvent()
            Toast.makeText(this, "Event pushed to CleaverTap", Toast.LENGTH_LONG).show()

        }
    }
    

    private fun sendEvent(){
        val hashMap : HashMap<String, Any> = HashMap()

        hashMap["Product ID"] = 1
        hashMap["Product Image"] = "https://d35fo82fjcw0y8.cloudfront.net/2018/07/26020307/customer-success-clevertap.jpg"
        hashMap["Product Name"] = "CleverTap"
        hashMap["Name"] = "Chaitali Choudhary" // String hashMap["Identity"] = 61026032 // String or number
        hashMap["Email"] = "chaitali.choudhary@gmail.com" // Email address of the user
        hashMap["Phone"] = "+919987310817" // Phone (with the country code, starting with +)
        hashMap["Gender"] = "F" // Can be either M or

        hashMap["Email"] = editText.text
        cleverTapDefaultInstance?.pushEvent("Product Viewed", hashMap)
    }
}