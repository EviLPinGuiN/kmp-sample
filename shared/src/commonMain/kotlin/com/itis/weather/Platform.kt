package com.itis.weather

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform