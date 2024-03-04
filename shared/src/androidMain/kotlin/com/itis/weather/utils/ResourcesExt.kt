package com.itis.weather.utils

import android.content.res.Resources
import com.itis.weather.core.configuration.Configuration

// https://developer.android.com/guide/topics/large-screens/support-different-screen-sizes
val Resources.deviceType: Configuration.DeviceType
    get() = when {
        displayMetrics.widthPixels > 600.dp -> Configuration.DeviceType.Tablet
        else -> Configuration.DeviceType.Phone
    }

inline val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()