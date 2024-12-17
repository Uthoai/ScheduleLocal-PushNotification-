package com.schedule_local_notifications

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.schedule_local_notifications.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        binding.apply {
            btnLocalNotification.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_localNotificationFragment)
            }
            btnPushNotification.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_pushNotificationFragment)
            }
        }



        return binding.root
    }

}