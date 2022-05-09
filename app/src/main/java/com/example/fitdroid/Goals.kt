package com.example.fitdroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.fitdroid.databinding.GoalsBinding
import com.example.fitdroid.databinding.HomepageBinding
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class Goals : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = GoalsBinding.inflate(layoutInflater)

        binding.homeButton.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_goals_to_homepage)
        }

        fun setLineChartData() {

            val linevalues = ArrayList<Entry>()
            linevalues.add(Entry(20f, 0.0F))
            linevalues.add(Entry(30f, 3.0F))
            linevalues.add(Entry(40f, 2.0F))
            linevalues.add(Entry(50f, 1.0F))
            linevalues.add(Entry(60f, 8.0F))
            linevalues.add(Entry(70f, 10.0F))


            val linedataset = LineDataSet(linevalues, "First")
            //We add features to our chart
            linedataset.color = resources.getColor(R.color.purple_200)

            linedataset.circleRadius = 10f
            linedataset.setDrawFilled(true)
            linedataset.valueTextSize = 20F
            linedataset.fillColor = resources.getColor(R.color.black)
            linedataset.setMode(LineDataSet.Mode.CUBIC_BEZIER);

            //We connect our data to the UI Screen
            val data = LineData(linedataset)
            binding.lineChart.data = data
            binding.lineChart.setBackgroundColor(resources.getColor(R.color.white))
            binding.lineChart.animateXY(2000, 2000, Easing.EaseInCubic)
        }

        setLineChartData()

        return binding.root
    }


}