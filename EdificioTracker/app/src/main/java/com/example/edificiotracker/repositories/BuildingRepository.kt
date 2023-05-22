package com.example.edificiotracker.repositories

import com.example.edificiotracker.data.model.BuildingModel

class BuildingRepository(private val buildings: MutableList<BuildingModel>) {

    fun getBuildings() = buildings

    fun addBuildings(building: BuildingModel) = buildings.add(building)

}