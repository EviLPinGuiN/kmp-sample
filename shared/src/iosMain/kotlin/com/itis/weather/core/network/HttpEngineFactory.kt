package com.itis.weather.core.network

import com.itis.weather.core.configuration.PlatformConfiguration
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.darwin.Darwin

actual open class HttpEngineFactory actual constructor() {

    actual fun createEngine(
        platformConfiguration: PlatformConfiguration,
    ): HttpClientEngineFactory<HttpClientEngineConfig> = Darwin
}