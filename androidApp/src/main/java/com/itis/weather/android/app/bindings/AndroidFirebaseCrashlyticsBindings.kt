package com.itis.weather.android.app.bindings

import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.itis.weather.core.binding.FirebaseCrashlyticsBindings

class AndroidFirebaseCrashlyticsBindings : FirebaseCrashlyticsBindings {

    private val crashlytics by lazy {
        FirebaseCrashlytics.getInstance()
    }

    override fun nonFatal(error: Throwable) {
        crashlytics.recordException(error)
    }

    override fun setParams(key: String, value: String) {
        crashlytics.setCustomKey(key, value)
    }
}
