package com.azmirf20.alarmmanager

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        createNotificationChannel()

//        btn_notif.setOnClickListener {
//            val intent = Intent(this, ReminderBroadcast::class.java)
//            val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
//
//            val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
//            val timeButton = System.currentTimeMillis()
//            val tenSecs = 1000
//            alarmManager.set(
//                AlarmManager.RTC_WAKEUP,
//                timeButton + tenSecs,
//                pendingIntent
//            )
//        }
    }

    override fun onStop() {
        Log.i("testService", "Kill apps, send broadcast")
        val broadcastIntent = Intent()
        broadcastIntent.action = "RestartService"
        broadcastIntent.setClass(this, ReminderBroadcast::class.java)
        this.sendBroadcast(broadcastIntent)
        super.onStop()
    }

//    private fun createNotificationChannel() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val name = "ReminderChannel"
//            val description = "Nyobain dulu aja"
//            val importance = NotificationManager.IMPORTANCE_DEFAULT
//            val channel = NotificationChannel("notifyme", name, importance).apply {
//                this.description = description
//            }
//
//            val notificationManager = getSystemService(NotificationManager::class.java)
//            notificationManager.createNotificationChannel(channel)
//        }
//    }
}