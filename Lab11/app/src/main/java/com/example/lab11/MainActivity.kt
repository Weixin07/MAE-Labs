package com.example.lab11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import android.widget.TimePicker
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textData = findViewById<TextView>(R.id.textViewData)
        val btnNoThread = findViewById<Button>(R.id.buttonNoThread)
        val btnThread = findViewById<Button>(R.id.buttonThread)
        val btnWorkMgr = findViewById<Button>(R.id.buttonWorkManager)
        val btnAlarmMgr = findViewById<Button>(R.id.buttonAlarmManager)
        var alarmTP = findViewById<TimePicker>(R.id.alarmTimePicker)

        btnNoThread.setOnClickListener {
            val handler = Handler()
            for (i in 1..10) {
                handler.postDelayed({ textData.text = i.toString()}, 1000)
            }
        }

        btnThread.setOnClickListener {
            Thread(Runnable {
                for (i in 10 downTo 0) {
                    runOnUiThread{ textData.text = i.toString() }
                    Thread.sleep(1000)
                }
            }).start()
        }

        btnWorkMgr.setOnClickListener{
            WorkManager.getInstance().enqueue(OneTimeWorkRequest.Builder(myWorkManager::class.java).build())
        }

        btnAlarmMgr.setOnClickListener {
            val calendar = Calendar.getInstance()
            calendar.set(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                alarmTP.hour,
                alarmTP.minute,
                0
            )
            var alarmObj = myAlarm()
            alarmObj.setAlarm(this, calendar.timeInMillis)
        }

    }
}