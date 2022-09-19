package com.example.passingdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.fragmentcommunication.FragmentA
import com.example.fragmentcommunication.R


class MainActivityPage2 : AppCompatActivity(), FragmentA.DialogInputListener {

    lateinit var tViewName : TextView
    lateinit var tViewValue : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page2)
        tViewName = findViewById<TextView>(R.id.textViewName)
        tViewValue = findViewById<TextView>(R.id.textViewNumber)

        val intent = intent
        var name = intent.getStringExtra("Username").toString()
        var value = intent.getIntExtra("Value", 0)

        tViewName.setText(name)
        tViewValue.setText(value.toString())


        var btnPassF = findViewById<Button>(R.id.buttonPassFragment)
        btnPassF.setOnClickListener {
            FragmentA.newInstance(tViewName.text.toString(),tViewValue.text.toString()).show(supportFragmentManager, FragmentA.TAG)

        }
    }

    override fun returnInput(text: String, value: Int) {
        Log.d("Page 2 Activity", "sendInput: got the input: $text : $value")

        tViewName.setText(text)
        tViewValue.setText(value.toString())
    }

}
