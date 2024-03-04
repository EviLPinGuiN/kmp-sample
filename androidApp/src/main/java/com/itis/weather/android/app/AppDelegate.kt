package com.itis.weather.android.app

import android.app.Application

class AppDelegate : Application() {

    override fun onCreate() {
        super.onCreate()

        initShared()
    }
}