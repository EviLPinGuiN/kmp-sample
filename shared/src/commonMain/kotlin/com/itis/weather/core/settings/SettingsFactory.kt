package com.itis.weather.core.settings

import com.itis.weather.core.configuration.PlatformConfiguration
import com.russhwolf.settings.Settings

internal expect class SettingsFactory() {

    fun create(
        platformConfiguration: PlatformConfiguration,
        name: String
    ): Settings
}
