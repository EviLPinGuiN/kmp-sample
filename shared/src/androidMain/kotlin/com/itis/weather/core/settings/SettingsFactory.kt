package com.itis.weather.core.settings

import android.content.Context
import com.itis.weather.core.configuration.PlatformConfiguration
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings

internal actual class SettingsFactory {

    actual fun create(
        platformConfiguration: PlatformConfiguration,
        name: String
    ): Settings {
        return SharedPreferencesSettings(
            delegate = platformConfiguration.androidContext.getSharedPreferences(name, Context.MODE_PRIVATE)
        )
    }
}
