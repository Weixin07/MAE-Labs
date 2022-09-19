package com.example.fragmentcommunication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.passingdata.MainActivityPage2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textName = findViewById<EditText>(R.id.editTextName)
        var textNumber = findViewById<EditText>(R.id.editTextNumber)
        var buttonPass = findViewById<Button>(R.id.buttonPass)
        var buttonTVM = findViewById<Button>(R.id.buttonTestVM)
        var buttonOpenFrag = findViewById<Button>(R.id.buttonOpenFragment)

        buttonPass.setOnClickListener {
            var intent = Intent(this, MainActivityPage2::class.java)
            intent.putExtra("Username",textName.text.toString())
            intent.putExtra("Value",textNumber.text.toString().toInt())
            startActivity(intent)
        }
        buttonTVM.setOnClickListener {
            var intent = Intent(this, ActivityViewModel::class.java)
            startActivity(intent)
        }
        buttonOpenFrag.setOnClickListener {
            val intent = Intent(this, ActivityFragment::class.java)
            startActivity(intent)
        }

    }
}
