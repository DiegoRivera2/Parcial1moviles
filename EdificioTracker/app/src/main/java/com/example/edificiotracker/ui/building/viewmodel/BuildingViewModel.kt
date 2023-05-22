package com.example.edificiotracker.ui.building.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.edificiotracker.BuildingReviewerApplication
import com.example.edificiotracker.data.model.BuildingModel
import com.example.edificiotracker.repositories.BuildingRepository

class BuildingViewModel(private val repository: BuildingRepository) : ViewModel() {
    var name = MutableLiveData("")
    var location = MutableLiveData("")

    fun getBuildings() = repository.getBuildings()

    private fun addBuildings(building: ViewModel) = repository.addBuildings(building)

    fun createBuilding() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val building = BuildingModel(
            name.value!!,
            location.value!!,
        )

        addBuildings(building)
        clearData()

        status.value = MOVIE_CREATED
    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            location.value.isNullOrEmpty() -> return false

        }
        return true
    }

    fun clearData() {
        name.value = ""
        location.value = ""

    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun setSelectedMovie(building: BuildingModel) {
        name.value = building.name
        location.value = building.location

    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as BuildingReviewerApplication
                BuildingViewModel(app.buildingRepository)
            }
        }

        const val MOVIE_CREATED = "Movie created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }

}