package com.itis.weather.core.configuration

expect class PlatformConfiguration {
    val appVersionName: String
    val appVersionNumber: String
    val osVersion: String
    val deviceType: Configuration.DeviceType
}