package com.itis.weather.core.sqldelight

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.itis.weather.Database
import com.itis.weather.core.configuration.PlatformConfiguration

internal actual class DriverFactory {

    actual fun createDriver(
        name: String,
        platformConfiguration: PlatformConfiguration,
    ): SqlDriver {
        return NativeSqliteDriver(
            schema = Database.Schema,
            name = name,
        )
    }
}
