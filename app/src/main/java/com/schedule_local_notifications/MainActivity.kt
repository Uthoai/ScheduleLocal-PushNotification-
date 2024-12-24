package com.schedule_local_notifications

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.schedule_local_notifications.databinding.ActivityMainBinding
import com.schedule_local_notifications.service.CounterNotificationService

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val service = CounterNotificationService(this.applicationContext)

        binding.btnNotification.setOnClickListener {
            service.showNotification(Counter.value)
        }

    }
}