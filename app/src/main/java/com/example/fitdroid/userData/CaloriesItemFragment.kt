package com.example.fitdroid.userData

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.fitdroid.R

import com.example.fitdroid.database.CaloriesDatabase
import com.example.fitdroid.databinding.CaloriesItemFragmentBinding

/**
 * Fragment that displays a single calories.
 */
class CaloriesItemFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Retrieve arguments passed from the RecyclerView
        val args = CaloriesItemFragmentArgs.fromBundle(
            requireArguments()
        )

        // Create data binding
        val binding: CaloriesItemFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.calories_item_fragment, container, false)

        // Get reference to this application
        val application = requireNotNull(this.activity).application

        // Retrieve Calories data access object.
        val dataSource = CaloriesDatabase.getInstance(application).caloriesDao

        // Create a factory that generates an CaloriesViewModel connected to the database. The
        // caloriesId passed from the RecyclerView is used to display the corresponding
        // information.
        val viewModelFactory =
            CaloriesItemViewModelFactory(args.caloriesId, dataSource, application)

        // Generate an CaloriesViewModel using the factory.
        val caloriesItemViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(CaloriesItemViewModel::class.java)

        // Connect the CaloriesViewModel with the variable in the layout
        binding.caloriesItemViewModel = caloriesItemViewModel
        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this

        return binding.root
    }
}