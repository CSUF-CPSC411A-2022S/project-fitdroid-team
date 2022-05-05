package com.example.fitdroid.calorieslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.fitdroid.R
import com.example.fitdroid.database.CaloriesDatabase
import com.example.fitdroid.databinding.CaloriesListFragmentBinding

/**
 * Fragment that displays the input text fields and calories list
 */
class CaloriesListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Create data binding
        val binding: CaloriesListFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.calories_list_fragment, container, false)

        // Get reference to the application
        val application = requireNotNull(this.activity).application

        // Retrieve Calories data access object.
        val dataSource = CaloriesDatabase.getInstance(application).caloriesDao

        // Create a factory that generates CaloriesViewModels connected to the database.
        val viewModelFactory = CaloriesViewModelFactory(dataSource, application)

        // Generate an CaloriesViewModel using the factory.
        val caloriesViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(CaloriesViewModel::class.java)

        // Connect the CaloriesViewModel with the variable in the layout
        binding.caloriesViewModel = caloriesViewModel
        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this

        // Provide a lambda function that is called when the RecyclerView item is selected.
        var caloriesAdapter = CaloriesListAdapter(CaloriesListener {
            caloriesId ->
            // Navigate to the calories view and provide the id of the calories referenced
            // by the select RecyclerView item.
            this.findNavController().navigate(
                CaloriesListFragmentDirections
                    .actionCaloriesListFragmentToCaloriesItemFragment(caloriesId)
            )
        })
        // Attach calories adapter.
        binding.caloriesRecyclerview.adapter = caloriesAdapter

        // Submit an updated list to the calories listAdapter whenever it changes. Take note
        // caloriesList is a LiveData object.
        caloriesViewModel.caloriesList.observe(viewLifecycleOwner, Observer {
            it?.let {
                caloriesAdapter.submitList(it)
            }
        })
        return binding.root
    }
}