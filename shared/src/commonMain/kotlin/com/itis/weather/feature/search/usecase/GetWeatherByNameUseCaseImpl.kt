package com.itis.weather.feature.search.usecase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class GetWeatherByNameUseCaseImpl(
    private val weatherRepository: WeatherRepository
) : GetWeatherByNameUseCase {

    override suspend fun invoke(query: String): CityWeather = withContext(Dispatchers.Default) {
        weatherRepository.getWeatherByName(query)
    }
}
