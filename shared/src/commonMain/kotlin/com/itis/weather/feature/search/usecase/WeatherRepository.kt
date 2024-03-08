package com.itis.weather.feature.search.usecase

interface WeatherRepository {

    suspend fun getWeatherByName(query: String): Weather
}