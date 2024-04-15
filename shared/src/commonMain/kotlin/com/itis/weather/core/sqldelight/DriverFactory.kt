package com.itis.weather.core.sqldelight

import app.cash.sqldelight.db.SqlDriver
import com.itis.weather.core.configuration.PlatformConfiguration

internal expect class DriverFactory() {

    fun createDriver(
        name: String,
        platformConfiguration: PlatformConfiguration,
    ): SqlDriver
}
