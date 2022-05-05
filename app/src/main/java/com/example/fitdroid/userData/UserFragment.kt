package com.example.fitdroid.userData

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.fitdroid.R
import com.example.fitdroid.databinding.UsersBinding


class UserFragment : Fragment() {
    private val viewViewModel: UserViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = UsersBinding.inflate(layoutInflater)
        binding.homeButton.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_userModel_to_homepage)
        }
        //binding.nextButton.setOnClickListener{onNextPage()}
        return binding.root
    }
    //create next button listener to go to the next page
    //TODO
    private fun onNextPage(){}
}