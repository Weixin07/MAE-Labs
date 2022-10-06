package com.example.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtMessage  = findViewById<EditText>(R.id.editTextMessage)
        val btnEnter  = findViewById<Button>(R.id.buttonEnter)
        btnEnter.setOnClickListener {
            val intent = Intent(applicationContext, mainactivity2::class.java)
            intent.putExtra("data", txtMessage.text.toString())
            startActivity(intent)
        }
    }
}