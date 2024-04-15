package com.itis.weather.feature.search

import com.itis.weather.feature.search.data.LocalWeatherSource
import com.itis.weather.feature.search.data.RemoteWeatherSource
import com.itis.weather.feature.search.data.WeatherRepositoryImpl
import com.itis.weather.feature.search.usecase.GetWeatherByNameUseCase
import com.itis.weather.feature.search.usecase.GetWeatherByNameUseCaseImpl
import com.itis.weather.feature.search.usecase.WeatherRepository
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance

val weatherModule = DI.Module("weatherModule") {
    bindProvider {
        LocalWeatherSource(
            settings = instance(),
            database = instance(),
        )
    }
    bindProvider {
        RemoteWeatherSource(instance())
    }
    bindProvider<WeatherRepository> {
        WeatherRepositoryImpl(instance())
    }

    bindProvider<GetWeatherByNameUseCase> {
        GetWeatherByNameUseCaseImpl(instance())
    }
}
