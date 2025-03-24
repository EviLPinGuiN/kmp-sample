package com.itis.weather.feature.search.presentation.city

import androidx.lifecycle.viewModelScope
import com.itis.weather.core.binding.FirebaseCrashlyticsBindings
import com.itis.weather.core.viewmodel.BaseViewModel
import com.itis.weather.di.PlatformSDK
import com.itis.weather.feature.search.usecase.GetWeatherByNameUseCase
import kotlinx.coroutines.launch
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.char
import kotlinx.datetime.toLocalDateTime

class CityWeatherViewModel : BaseViewModel<CityWeatherViewState, CityWeatherAction, CityWeatherEvent>(
    initState = CityWeatherViewState()
) {

    private val getWeatherByNameUseCase: GetWeatherByNameUseCase by PlatformSDK.lazyInstance()
    private val crashlyticsBindings: FirebaseCrashlyticsBindings by PlatformSDK.lazyInstance()

    init {
        loadWeather()
    }

    override fun obtainEvent(event: CityWeatherEvent) {
        when (event) {
            CityWeatherEvent.OnSearchClick -> throw RuntimeException("HELLO")
        }
    }

    private fun loadWeather() {
        viewModelScope.launch {
            try {
                viewState = viewState.copy(isLoading = true)
                val weather = getWeatherByNameUseCase.invoke(query = "Paris")
                with(weather) {
                    viewState = viewState.copy(
                        name = name,
                        isLoading = false,
                        temp = "${temp.toInt()}°",
                        feelTemp = "Feels like: ${feelTemp.toInt()}°",
                        weatherDesc = this.weather.desc,
                        weatherIconUrl = this.weather.imageUrl,
                        humidity = "${humidity}%",
                        pressure = "${pressure}hPa",
                        cloudsPercent = "${cloudsPercent}%",
                        windSpeed = "${wind.speed} km/h",
                        sunrise = day.sunrise.toFormatTime(),
                        sunset = day.sunset.toFormatTime(),
                    )
                }
            } catch (error: Throwable) {
                error.printStackTrace()
                crashlyticsBindings.nonFatal(error)
                viewState = viewState.copy(isLoading = false)
            }
        }
    }

    private fun Long.toFormatTime(): String {
        return Instant.fromEpochSeconds(this)
            .toLocalDateTime(TimeZone.currentSystemDefault())
            .time
            .format(LocalTime.Format {
                hour()
                char(':')
                minute()
            })
    }
}
