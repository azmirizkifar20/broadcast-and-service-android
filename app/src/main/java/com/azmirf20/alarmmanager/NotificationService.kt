package com.azmirf20.alarmmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class NotificationService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        Log.i("testService", "Service berjalann")
        displayNotification()

        return START_STICKY
    }

    private fun displayNotification() {
        val manager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel("notifyme", "notifyme", NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }

        val builder = NotificationCompat.Builder(applicationContext, "notifyme")
            .setContentTitle("Reminder buat kamu!")
            .setContentText("Jangan lupa bahagia hari ini, jangan lupa sarapan jugaa")
            .setSmallIcon(R.drawable.ic_launcher_foreground)

        manager.notify(1, builder.build())
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        Log.i("testService", "Task berakhir, memulai service")
        startService(Intent(this, NotificationService::class.java))
        super.onTaskRemoved(rootIntent)
    }
}