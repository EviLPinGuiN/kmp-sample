package com.itis.weather.core.network

import com.itis.weather.core.configuration.PlatformConfiguration
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.config
import io.ktor.client.engine.okhttp.OkHttp
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

actual open class HttpEngineFactory actual constructor() {

    actual open fun createEngine(
        platformConfiguration: PlatformConfiguration,
    ): HttpClientEngineFactory<HttpClientEngineConfig> =
        OkHttp.config {
            config {
                retryOnConnectionFailure(true)
            }

            addInterceptor(
                HttpLoggingInterceptor { Timber.tag("Network").d(it) }.apply {
                    level = HttpLoggingInterceptor.Level.BASIC
                },
            )
        }
}