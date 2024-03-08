package com.itis.weather.feature.search.data

import com.itis.weather.feature.search.data.model.mapToEntity
import com.itis.weather.feature.search.usecase.Weather
import com.itis.weather.feature.search.usecase.WeatherRepository

internal class WeatherRepositoryImpl(
    private val remoteWeatherSource: RemoteWeatherSource
) : WeatherRepository {

    override suspend fun getWeatherByName(query: String): Weather {
        return remoteWeatherSource.getWeatherByName(query = query).mapToEntity()
    }
}