package com.itis.weather.feature.search.presentation.city

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
        scope.launch {
            try {
                viewState = viewState.copy(isLoading = true)
                val weather = getWeatherByNameUseCase.invoke(query = "Paris")
                viewState = viewState.copy(
                    name = weather.name,
                    isLoading = false,
                    temp = "${weather.temp.toInt()}°",
                    feelTemp = "Feels like: ${weather.feelTemp.toInt()}°",
                    weatherDesc = weather.weather.desc,
                    weatherIconUrl = weather.weather.imageUrl,
                    humidity = "${weather.humidity}%",
                    pressure = "${weather.pressure}hPa",
                    cloudsPercent = "${weather.cloudsPercent}%",
                    windSpeed = "${weather.wind.speed} km/h",
                    sunrise = weather.day.sunrise.toFormatTime(),
                    sunset = weather.day.sunset.toFormatTime(),
                )
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
