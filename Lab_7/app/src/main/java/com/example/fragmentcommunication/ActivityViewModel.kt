package com.example.fragmentcommunication

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ActivityViewModel : AppCompatActivity() {
    lateinit var model: myViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        val CountrylistView: ListView = findViewById<View>(R.id.listViewCountry) as ListView
        val progressBar = findViewById<View>(R.id.progressBar) as ProgressBar
        progressBar.visibility = View.VISIBLE

        model = listOf(ViewModel::myViewModel)
        model!!.getCountryList().observe(this) { CountryList ->
            val adapter = ArrayAdapter<String>(
                this,
                R.layout.country_list_item,
                R.id.textViewCountryName,
                CountryList
            )
            CountrylistView.setAdapter(adapter)
            progressBar.visibility = View.GONE
        }
        val btnAdd = findViewById<FloatingActionButton>(R.id.fabAdd)
        btnAdd.setOnClickListener {
            showdialog()
        }
    }

    fun showdialog(){
        val alert =  AlertDialog.Builder(this)
        alert.setTitle("Title")

        val input = EditText(this)
        input.setHint("Enter Country")
        alert.setView(input)
        alert.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            model.addCountry(input.text.toString())

        })
        alert.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

        alert.show()
    }
}
