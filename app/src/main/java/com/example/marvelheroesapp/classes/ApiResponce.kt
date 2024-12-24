package com.example.marvelheroesapp.classes

data class ApiResponse(
    val data: HeroData
)

data class HeroData(
    val results: List<Hero>
)