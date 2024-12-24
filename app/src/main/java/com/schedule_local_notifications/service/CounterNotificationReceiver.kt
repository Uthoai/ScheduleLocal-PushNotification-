package com.schedule_local_notifications.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.schedule_local_notifications.Counter

class CounterNotificationReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val service = CounterNotificationService(context)
        service.showNotification(++Counter.value)
    }
}