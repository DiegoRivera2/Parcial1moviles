package com.example.edificiotracker.ui.building.Buildings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.edificiotracker.R
import com.example.edificiotracker.data.model.BuildingModel
import com.example.edificiotracker.databinding.FragmentBuildingsBinding
import com.example.edificiotracker.ui.building.Buildings.recyclerview.BuildingRecyclerViewAdapter
import com.example.edificiotracker.ui.building.viewmodel.BuildingViewModel

class BuildingsFragment : Fragment() {

    private val buildingViewModel: buildingViewModel by activityViewModels {
        BuildingViewModel.Factory
    }

    private lateinit var adapter: BuildingRecyclerViewAdapter

    private lateinit var binding: FragmentBuildingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBuildingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)



    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = BuildingRecyclerViewAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)
        }

        binding.recyclerView.adapter = adapter
        displayBuildings()
    }

    private fun displayBuildings() {
        adapter.setData(ViewModel.getBuildings())
        adapter.notifyDataSetChanged()
    }

    private fun showSelectedItem(building: BuildingModel) {
        builsingViewModel.setSelectedMovie(building)

    }

}