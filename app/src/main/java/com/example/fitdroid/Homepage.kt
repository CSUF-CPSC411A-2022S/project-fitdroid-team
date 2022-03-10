package com.example.fitdroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.fitdroid.databinding.ActivityMainBinding
import com.example.fitdroid.databinding.HomepageBinding

class Homepage : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = HomepageBinding.inflate(layoutInflater)

        binding.goalsButton.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_homepage_to_goals)
        }

        return binding.root
    }
}