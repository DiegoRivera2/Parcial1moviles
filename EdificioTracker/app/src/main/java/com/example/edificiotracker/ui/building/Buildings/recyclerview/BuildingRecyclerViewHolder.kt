package com.example.edificiotracker.ui.building.Buildings.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.example.edificiotracker.data.model.BuildingModel

class BuildingRecyclerViewHolder(private val binding: BuildingItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: BuildingModel, clickListener: (BuildingModel) -> Unit) {


        binding.BuildingItemCardView.setOnClickListener {
            clickListener(movie)
        }
    }
}