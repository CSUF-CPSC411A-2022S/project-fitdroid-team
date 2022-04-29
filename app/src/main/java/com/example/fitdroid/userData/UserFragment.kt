package com.example.fitdroid.userData

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.fitdroid.R
import com.example.fitdroid.database.UserDatabase
import com.example.fitdroid.databinding.UsersFragmentBinding


class UserFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: UsersFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.users_fragment, container,false)

        val application = requireNotNull(this.activity).application

        val dataSource = UserDatabase.getInstance(application).userDao

        val viewModelFactory = UserViewModelFactory(dataSource, application)

        val userViewModel =
            ViewModelProvider(this, viewModelFactory).get(UserViewModel::class.java)

        binding.userViewModel = userViewModel
        binding.lifecycleOwner = this


        binding.homeButton.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_userModel_to_homepage)
        }
        //binding.nextButton.setOnClickListener{onNextPage()}
        return binding.root
    }
}