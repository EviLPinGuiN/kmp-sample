package com.itis.weather.di

import com.itis.weather.core.binding.FirebaseCrashlyticsBindings
import com.itis.weather.core.configuration.Configuration
import com.itis.weather.core.configuration.PlatformConfiguration
import com.itis.weather.core.network.networkModule
import com.itis.weather.core.storageModule
import com.itis.weather.feature.search.weatherModule
import org.kodein.di.DI
import org.kodein.di.DirectDI
import org.kodein.di.LazyDelegate
import org.kodein.di.bind
import org.kodein.di.bindSingleton
import org.kodein.di.direct
import org.kodein.di.instance
import org.kodein.di.singleton

object PlatformSDK {

    private var _di: DirectDI? = null

    val di: DirectDI
        get() = requireNotNull(_di)

    fun init(conf: Configuration) {
        _di = DI {
            importAll(
                createConfigurationModule(conf),
                networkModule,
                storageModule,
                weatherModule,
            )
        }.direct
    }

    inline fun <reified T : Any> lazyInstance(tag: Any? = null): LazyDelegate<T> {
        return di.lazy.instance(tag)
    }

    private fun createConfigurationModule(configuration: Configuration): DI.Module = DI.Module(
        name = "configurationModule",
        init = {
            bind<Configuration>() with singleton {
                configuration
            }
            bind<PlatformConfiguration>() with singleton { configuration.platformConfiguration }

            bindSingleton<FirebaseCrashlyticsBindings> {
                configuration.firebaseCrashlyticsBindings
            }
        },
    )
}
