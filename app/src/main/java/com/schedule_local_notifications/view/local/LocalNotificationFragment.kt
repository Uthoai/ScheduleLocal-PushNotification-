package com.schedule_local_notifications.view.local

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.schedule_local_notifications.Counter
import com.schedule_local_notifications.databinding.FragmentLocalNotificationBinding
import com.schedule_local_notifications.service.CounterNotificationService

class LocalNotificationFragment : Fragment() {
    private lateinit var binding: FragmentLocalNotificationBinding

    private val appContext = requireContext().applicationContext
    private val notificationService = CounterNotificationService(appContext)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocalNotificationBinding.inflate(inflater, container, false)

        binding.setNotification.setOnClickListener {
            notificationService.showNotification(Counter.value)
        }

        return binding.root
    }

    /*@RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel() {
        val name = "Schedule Notify Channel"
        val desc = "A description of the channel"
        val important = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelID, name, important)
        channel.description = desc

        val notificationManager = requireContext().getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }

    @SuppressLint("ScheduleExactAlarm")
    private fun scheduleNotification() {
        val title = binding.etTitle.text.toString()
        val message = binding.etMessage.text.toString()

        val intent = Intent(requireContext(), Notification::class.java)
        intent.putExtra(TITLE_EXTRA, title)
        intent.putExtra(MESSAGE_EXTRA, message)

        val pendingIntent = PendingIntent.getBroadcast(
            requireContext(),
            notificationID,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = requireContext().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val time = getTime()
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            time,
            pendingIntent
        )

        showAlert(time, title, message)

    }

    private fun showAlert(time: Long, title: String, message: String) {
        val date = Date(time)
        val dateFormat = android.text.format.DateFormat.getLongDateFormat(requireContext())
        val timeFormat = android.text.format.DateFormat.getTimeFormat(requireContext())

        AlertDialog.Builder(requireContext())
            .setTitle("Notification Schedule")
            .setMessage(
                "Title: $title \nMessage: $message " +
                "\nAt: ${dateFormat.format(date)} ${timeFormat.format(date)}")
            .setPositiveButton("Okay"){_,_ ->}
            .show()
    }


    private fun getTime(): Long {
        val minute = binding.setTimePicker.minute
        val hour = binding.setTimePicker.hour
        val day = binding.setDatePicker.dayOfMonth
        val month = binding.setDatePicker.month
        val year = binding.setDatePicker.year

        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, hour, minute)
        return calendar.timeInMillis
    }*/
}