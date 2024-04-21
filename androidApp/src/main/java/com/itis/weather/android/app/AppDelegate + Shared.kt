package com.itis.weather.android.app

import android.os.Build
import com.itis.weather.android.BuildConfig
import com.itis.weather.android.app.bindings.AndroidFirebaseCrashlyticsBindings
import com.itis.weather.core.configuration.Configuration
import com.itis.weather.core.configuration.PlatformConfiguration
import com.itis.weather.di.PlatformSDK
import com.itis.weather.utils.deviceType

fun AppDelegate.initShared() {
    val config = Configuration(
        platformConfiguration = PlatformConfiguration(
            androidContext = applicationContext,
            appVersionName = BuildConfig.VERSION_NAME,
            appVersionNumber = BuildConfig.VERSION_CODE.toString(),
            osVersion = Build.VERSION.RELEASE.toString(),
            deviceType = resources.deviceType
        ),
        isDebug = BuildConfig.DEBUG,
        isHttpLoggingEnabled = BuildConfig.DEBUG,

        firebaseCrashlyticsBindings = AndroidFirebaseCrashlyticsBindings()
    )
    PlatformSDK.init(conf = config)
}