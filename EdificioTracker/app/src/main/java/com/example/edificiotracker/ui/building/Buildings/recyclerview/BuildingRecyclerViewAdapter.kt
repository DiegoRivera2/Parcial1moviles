package com.example.edificiotracker.ui.building.Buildings.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.edificiotracker.data.buildings
import com.example.edificiotracker.data.model.BuildingModel

class BuildingRecyclerViewAdapter(
    private val clickListener: (BuildingModel) -> Unit
) : RecyclerView.Adapter<BuildingRecyclerViewHolder>()  {
    private val movies = ArrayList<BuildingModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuildingRecyclerViewHolder {
        val binding = BuildingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BuildingRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: BuildingRecyclerViewHolder, position: Int) {
        val building = buildings[position]
        holder.bind(building, clickListener)
    }

    fun setData(BuildingList: List<BuildingModel>) {
        buildings.clear()
        buildings.addAll(buildingsList)
    }
}