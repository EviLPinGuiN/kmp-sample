package com.itis.weather.feature.search.usecase

data class Weather(
    val name: String,
    val lat: Double,
    val lon: Double,
    val temp: Double,
    val humidity: Int,
    val pressure: Int,
    val cloudsPercent: Int
)
