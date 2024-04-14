package com.itis.weather.core.settings

import com.itis.weather.core.configuration.PlatformConfiguration
import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings

internal actual class SettingsFactory {

    actual fun create(
        platformConfiguration: PlatformConfiguration,
        name: String
    ): Settings {
        return NSUserDefaultsSettings.Factory().create(name = name)
    }
}
