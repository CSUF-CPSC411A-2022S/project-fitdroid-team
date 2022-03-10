package com.example.fitdroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.fitdroid.databinding.GoalsBinding
import com.example.fitdroid.databinding.HomepageBinding

class Goals : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = GoalsBinding.inflate(layoutInflater)

        binding.homeButton.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_goals_to_homepage)
        }

        return binding.root
    }
}