package com.example.lab_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("activity_lifecycle","execute onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("activity_lifecycle", "execute onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("activity_lifecycle", "execute onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("activity_lifecycle", "execute onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("activity_lifecycle", "execute onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("activity_lifecycle", "execute onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("activity_lifecycle", "execute onDestroy")
    }

}