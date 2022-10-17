package com.example.lab11

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import android.os.PowerManager

class myAlarm : BroadcastReceiver() {

    @SuppressLint("InvalidWakeLockTag")
    override fun onReceive(context: Context, intent: Intent?) {
        val sysSvc = context.getSystemService(Context.POWER_SERVICE) as PowerManager
        val wakeLck = sysSvc.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "")
        wakeLck.acquire()
        Toast.makeText(context,"Wake up...", Toast.LENGTH_LONG).show()
        wakeLck.release()
    }

    fun setAlarm(context: Context, timeInMillis : Long) {
        val alarmtime = (timeInMillis/System.currentTimeMillis())
        Toast.makeText(context,"Alarm rang off in $alarmtime seconds", Toast.LENGTH_SHORT).show()

        val alarmMgr = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val i = Intent(context, myAlarm::class.java)
        val pIntent = PendingIntent.getBroadcast(context, 0, i, 0)
        alarmMgr.setExact(AlarmManager.RTC_WAKEUP, timeInMillis, pIntent);
    }

}
