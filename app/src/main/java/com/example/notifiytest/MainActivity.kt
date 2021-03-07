package com.example.notifiytest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit private var editTextInput:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextInput = findViewById(R.id.edit_text_input)
    }

    fun startService(view: View) {
        var input:String = editTextInput.text.toString()
        var serviceIntent:Intent = Intent(this, NotificationService::class.java)
        serviceIntent.putExtra("inputExtra", input)
        startService(serviceIntent)
    }
    fun stopService(view: View) {
        var serviceIntent:Intent = Intent(this, NotificationService::class.java)
    }
}