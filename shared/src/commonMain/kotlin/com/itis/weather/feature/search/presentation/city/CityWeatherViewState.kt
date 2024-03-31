package com.itis.weather.feature.search.presentation.city

data class CityWeatherViewState(
    val name: String = "City",
    val isLoading: Boolean = false,
    val temp: String = "0°",
    val feelTemp: String = "Feels like 0°",
    val weatherDesc: String = "",
    val weatherIconUrl: String = "",
    val humidity: String = "0%",
    val pressure: String = "0hPa",
    val cloudsPercent: String = "0%",
    val windSpeed: String = "0km/h",
    val sunrise: String = "00:00",
    val sunset: String = "00:00",
)

sealed class CityWeatherAction {
    data object Close : CityWeatherAction()
}

sealed class CityWeatherEvent {
    data object OnSearchClick : CityWeatherEvent()
}
