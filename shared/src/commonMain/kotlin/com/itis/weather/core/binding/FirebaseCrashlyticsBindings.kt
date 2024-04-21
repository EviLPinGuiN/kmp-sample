package com.itis.weather.core.binding

interface FirebaseCrashlyticsBindings {

    fun nonFatal(error: Throwable)

    fun setParams(key: String, value: String)
}