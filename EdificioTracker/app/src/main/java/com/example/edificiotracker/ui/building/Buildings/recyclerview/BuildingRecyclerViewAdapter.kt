package com.example.edificiotracker.ui.building.Buildings.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
        val movie = movies[position]
        holder.bind(movie, clickListener)
    }

    fun setData(moviesList: List<BuildingModel>) {
        movies.clear()
        movies.addAll(moviesList)
    }
}