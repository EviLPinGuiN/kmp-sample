package com.itis.weather.core

import com.itis.weather.Database
import com.itis.weather.core.settings.SettingsFactory
import com.itis.weather.core.sqldelight.DriverFactory
import com.russhwolf.settings.Settings
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

val storageModule = DI.Module(name = "storageModule") {

    bindSingleton<Settings> {
        SettingsFactory().create(
            name = "weather_setting",
            platformConfiguration = instance(),
        )
    }

    bindSingleton<Database> {
        val driver = DriverFactory().createDriver(
            name = "weather.db",
            platformConfiguration = instance(),
        )
        Database(driver)
    }
}
