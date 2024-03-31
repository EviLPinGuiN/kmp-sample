package com.itis.weather.feature.city

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.itis.weather.feature.search.presentation.city.CityWeatherAction
import com.itis.weather.feature.search.presentation.city.CityWeatherEvent
import com.itis.weather.feature.search.presentation.city.CityWeatherViewModel
import com.itis.weather.utils.rememberClick

@Composable
fun CityWeatherScreen(viewModel: CityWeatherViewModel = viewModel()) {
    val state by viewModel.viewStates.collectAsStateWithLifecycle()
    val action by viewModel.viewActions.collectAsStateWithLifecycle(initialValue = null)
    val consumer = rememberClick<CityWeatherEvent> { viewModel.obtainEvent(it) }

    CityWeatherView(
        viewState = state,
        eventConsumer = consumer,
    )

    CityWeatherAction(action = action)
}

@Composable
private fun CityWeatherAction(action: CityWeatherAction?) {
    LaunchedEffect(action) {
        when (action) {
            CityWeatherAction.Close -> TODO()
            null -> Unit
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CityWeatherScreenPreview() {
    MaterialTheme {
        CityWeatherScreen()
    }
}
