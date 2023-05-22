package com.example.edificiotracker.data

import com.example.edificiotracker.data.model.BuildingModel

//Edificio 1
val name = "Edificio San Jose"
val location = "75av norte, colonia escalon"

//Edificio 2
val name2 = "Edificio La Fuente"
val location2 = "Bulevar Merliot"

var buildings = mutableListOf(
    BuildingModel(name, location),
    BuildingModel(name2,location2)
)