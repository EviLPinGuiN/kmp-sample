package com.itis.weather.feature.search.data.model

import com.itis.weather.feature.search.usecase.Weather

fun WeatherResponse.mapToEntity(): Weather {
    return Weather(
        name = requireNotNull(name),
        lat = coord?.lat ?: 0.0,
        lon = coord?.lon ?: 0.0,
        temp = main?.temp ?: 0.0,
        humidity = main?.humidity ?: 0,
        pressure = main?.pressure ?: 0,
        cloudsPercent = clouds?.all ?: 0,
    )
}
