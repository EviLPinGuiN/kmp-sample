package com.itis.weather.core.coroutine

import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.*

@Suppress("unused")
fun Flow<*>.subscribe(
    onEach: (item: Any?) -> Unit,
    onComplete: () -> Unit,
    onThrow: (error: Throwable) -> Unit,
): Job =
    this.onEach { onEach(it) }
        .catch { onThrow(it) }
        .onCompletion { onComplete() }
        .launchIn(MainScope())