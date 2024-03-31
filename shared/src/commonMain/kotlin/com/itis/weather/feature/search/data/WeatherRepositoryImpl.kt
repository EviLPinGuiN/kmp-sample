package com.itis.weather.feature.search.data

import com.itis.weather.feature.search.data.model.mapToEntity
import com.itis.weather.feature.search.usecase.CityWeather
import com.itis.weather.feature.search.usecase.WeatherRepository

internal class WeatherRepositoryImpl(
    private val remoteWeatherSource: RemoteWeatherSource
) : WeatherRepository {

    override suspend fun getWeatherByName(query: String): CityWeather {
        return remoteWeatherSource.getWeatherByName(query = query).mapToEntity()
    }
}