package com.schedule_local_notifications.service

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.schedule_local_notifications.MainActivity
import com.schedule_local_notifications.R

class CounterNotificationService(
    private val context: Context
) {
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    companion object {
        const val COUNTER_CHANNEL_ID = "counter_channel"
    }

    fun showNotification(counter: Int){
        val activityIntent = Intent(context, MainActivity::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )
        val incrementIntent = PendingIntent.getBroadcast(
            context,
            2,
            Intent(context,CounterNotificationReceiver::class.java),
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )
        val notification = NotificationCompat.Builder(context, COUNTER_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_coronavirus_24)
            .setContentTitle("Message Title")
            .setContentText("Total Message...$counter")
            .setContentIntent(activityPendingIntent)
            .addAction(R.drawable.ic_done_24, "Increment", incrementIntent)
            .build()

        notificationManager.notify(1, notification)

    }
}