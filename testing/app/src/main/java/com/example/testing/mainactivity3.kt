package com.example.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class mainactivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainactivity3)

        val wv = findViewById<WebView>(R.id.webView1)
        wv.settings.loadsImagesAutomatically = true
        wv.settings.javaScriptEnabled = true
        wv.loadUrl("https://www.google.com/")

    }
}