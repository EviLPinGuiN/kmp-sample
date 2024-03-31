package com.itis.weather.feature.search.usecase

interface GetWeatherByNameUseCase {

    suspend operator fun invoke(query: String): CityWeather
}
