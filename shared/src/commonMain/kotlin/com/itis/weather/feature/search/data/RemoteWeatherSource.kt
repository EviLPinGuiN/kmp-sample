package com.itis.weather.feature.search.data

import com.itis.weather.feature.search.data.model.WeatherResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url

internal class RemoteWeatherSource(
    private val httpClient: HttpClient
) {

    suspend fun getWeatherByName(query: String): WeatherResponse {
        return httpClient.get {
            url("weather")
            parameter("q", query)
        }.body()
    }
}
