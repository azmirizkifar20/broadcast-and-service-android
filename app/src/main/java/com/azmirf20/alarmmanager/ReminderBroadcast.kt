package com.azmirf20.alarmmanager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log

class ReminderBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i("testService", "Broadcast diterima")
        // start service
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context?.startForegroundService(Intent(context, NotificationService::class.java))
        } else {
            context?.startService(Intent(context, NotificationService::class.java))
        }
    }
}