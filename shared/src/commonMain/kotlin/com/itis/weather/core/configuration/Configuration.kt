package com.itis.weather.core.configuration

import com.itis.weather.core.binding.FirebaseCrashlyticsBindings

data class Configuration(
    val platformConfiguration: PlatformConfiguration,
    val isHttpLoggingEnabled: Boolean,
    val isDebug: Boolean,

    val firebaseCrashlyticsBindings: FirebaseCrashlyticsBindings,
) {

    enum class DeviceType {
        Tablet,
        Phone,
    }
}
