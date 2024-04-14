package com.itis.weather.core.sqldelight

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.itis.weather.Database
import com.itis.weather.core.configuration.PlatformConfiguration

internal actual class DriverFactory {

    actual fun createDriver(
        name: String,
        platformConfiguration: PlatformConfiguration,
    ): SqlDriver {
        return AndroidSqliteDriver(
            schema = Database.Schema,
            context = platformConfiguration.androidContext,
            name = name,
        )
    }
}
