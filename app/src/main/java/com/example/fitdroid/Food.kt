package com.example.fitdroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.fitdroid.databinding.FoodBinding
import com.example.fitdroid.adapter.FoodListAdapter
import com.google.android.material.internal.ContextUtils.getActivity

class Food : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FoodBinding.inflate(layoutInflater)

        binding.homeButton.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_food_to_homepage)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
// TODO: ADD UNIQUE CODE TO FUNCTION ABOVE
        var binding = FoodBinding.inflate(layoutInflater)
        // root is a property holding the view of the inflated XML and is set as the contentView


        var foodListAdapter = FoodListAdapter(requireContext())
        binding.recyclerView.adapter = foodListAdapter


        binding.addFood.setOnClickListener {

            val toast = Toast.makeText(
                requireContext(),
                "Adding ${binding.foodName.text} @ ${binding.foodAddress.text}",
                Toast.LENGTH_SHORT
            )
            toast.show()

            // We can access the data through the dataset property inside foodListAdapter.the d
            foodListAdapter.dataset.add("${binding.foodName.text} @ ${binding.foodAddress.text}")

            // Inform the adapter that we made changes so the visual representation can be updated.
            foodListAdapter.notifyDataSetChanged()

        }
    }
}