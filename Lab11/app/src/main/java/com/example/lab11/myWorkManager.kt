package com.example.lab11

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.annotation.NonNull
import androidx.core.app.NotificationCompat

import androidx.work.Worker;
import androidx.work.WorkerParameters;

class myWorkManager(context: Context, params: WorkerParameters) : Worker(context, params) {

    @NonNull
    override fun doWork(): Result {
        displayNotification("WorkManager Notification", "This is the notification of a Work Manager");
        return Result.success();
    }

    fun displayNotification(title: String, task:String) {
        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel("workMgrChl", "Notification Manager Channel", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }

        val notification = NotificationCompat.Builder(getApplicationContext(), "workMgrChl")
            .setContentTitle(title)
            .setContentText(task)
            .setSmallIcon(R.drawable.ic_launcher_foreground);

        notificationManager.notify(1, notification.build());
    }
}
