package com.itis.weather

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}

fun test(action: MainAction) {
    when (action) {
        MainAction.Close -> TODO()
        is MainAction.ShowMessage -> TODO()
    }
}
