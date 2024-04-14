package com.itis.weather.feature.search.data

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.itis.weather.Database
import com.itis.weather.WeatherDB
import com.itis.weather.feature.search.usecase.Weather
import com.russhwolf.settings.Settings
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.withContext

internal class LocalWeatherSource(
    private val settings: Settings,
    private val database: Database,
) {

    suspend fun test(weather: Weather) = withContext(Dispatchers.IO) {
        database.weatherQueries.insert(
            WeatherDB(
                id = 2321,
                name = weather.name,
                temp = null,
            )
        )

        database.weatherQueries.getAll()
            .executeAsList()
            .asFlow()

        var temp = 0.0
        database.weatherQueries.getWeatherWithTemp(
            temp = temp
        )
            .asFlow()
            .mapToList(Dispatchers.IO)
    }
}
