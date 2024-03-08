package com.itis.weather.feature.search.usecase

internal class GetWeatherByNameUseCaseImpl(
    private val weatherRepository: WeatherRepository
): GetWeatherByNameUseCase {

    override suspend fun invoke(query: String): Weather {
        return weatherRepository.getWeatherByName(query)
    }
}
