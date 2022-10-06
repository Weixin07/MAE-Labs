package com.example.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class mainactivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainactivity2)

        val txtNum1 = findViewById<EditText>(R.id.editTextNumber1)
        val txtNum2 = findViewById<EditText>(R.id.editTextNumber2)
        val txtRes = findViewById<TextView>(R.id.textViewResult)
        val btnAdd = findViewById<Button>(R.id.buttonAdd)
        val title = findViewById<TextView>(R.id.textView)
        val btnNext = findViewById<Button>(R.id.buttonNextPage)

        val msg = intent.getStringExtra("data")
        title.setText("Welcome $msg to basic calculation")

        btnAdd.setOnClickListener {
            val res = mathoperation().addNumber(
                txtNum1.text.toString().toInt(),
                txtNum2.text.toString().toInt()
            )
            txtRes.setText(res.toString())
        }

        btnNext.setOnClickListener {
            val intent = Intent(applicationContext, mainactivity3::class.java)
            startActivity(intent)

        }
    }
}