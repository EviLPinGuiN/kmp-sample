package com.itis.weather.core.network

import com.itis.weather.core.configuration.PlatformConfiguration
import io.ktor.client.engine.*

expect open class HttpEngineFactory() {

    fun createEngine(platformConfiguration: PlatformConfiguration): HttpClientEngineFactory<HttpClientEngineConfig>
}