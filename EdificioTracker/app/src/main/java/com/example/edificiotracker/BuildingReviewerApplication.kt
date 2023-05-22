package com.example.edificiotracker

import android.app.Application
import com.example.edificiotracker.data.buildings
import com.example.edificiotracker.repositories.BuildingRepository

class BuildingReviewerApplication: Application(){
        val buildingRepository: BuildingRepository by lazy {
            BuildingRepository(buildings)
        }

}