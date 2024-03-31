package com.itis.weather.feature.search.presentation.search

import com.itis.weather.feature.search.usecase.CityWeather
import com.itis.weather.feature.search.usecase.Day
import com.itis.weather.feature.search.usecase.Weather
import com.itis.weather.feature.search.usecase.Wind

data class SearchViewState(
    val title: String = "",
    val isLoading: Boolean = true,
    val query: String = "",
    val weather: CityWeather = CityWeather(
        name = "Paris",
        lat = 0.0,
        lon = 0.0,
        temp = 0.0,
        feelTemp = 0.0,
        humidity = 0,
        pressure = 0,
        cloudsPercent = 0,
        wind = Wind(speed = 4.5, deg = 6287),
        day = Day(sunrise = 0, sunset = 0),
        weather = Weather(
            name = "Noelle Ferrell",
            desc = "tellus",
            imageUrl = "https://www.google.com/#q=quaestio"
        ),
    )
)

sealed class SearchAction {
    data object Close : SearchAction()
    data class OpenDetailsScreen(val id: String) : SearchAction()
    data class ShowError(val title: String, val desc: String) : SearchAction()
}

sealed class SearchEvent {
    data object OnCloseClick : SearchEvent()
    data object OnSearchClick : SearchEvent()
    data class OnQueryChange(val text: String) : SearchEvent()
}

/*
swift if we use sealed interface
- WeatherEventOnCloseClick()
- WeatherEventOnSearchClick()
- WeatherEventOnQueryChange()

swift if we use sealed class:
- WeatherEvent.OnCloseClick()
- WeatherEvent.OnSearchClick()
- WeatherEvent.OnQueryChange()
*/
