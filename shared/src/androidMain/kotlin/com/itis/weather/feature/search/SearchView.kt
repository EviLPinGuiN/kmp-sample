package com.itis.weather.feature.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.itis.weather.feature.search.presentation.search.SearchEvent
import com.itis.weather.feature.search.presentation.search.SearchViewState
import com.itis.weather.feature.search.usecase.CityWeather
import com.itis.weather.feature.search.usecase.Day
import com.itis.weather.feature.search.usecase.Weather
import com.itis.weather.feature.search.usecase.Wind

@Composable
internal fun SearchView(
    viewState: SearchViewState,
    consumer: (SearchEvent) -> Unit,
) {
    Scaffold(
        topBar = {

        },
        content = { padding ->
            Column(modifier = Modifier.padding(padding)) {
                Text(text = "")
            }
        }
    )
}

@Composable
fun CityItem(modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
private fun SearchView_Preview() {
    SearchView(
        viewState = SearchViewState(
            title = "Title",
            isLoading = false,
            query = "Search",
            weather = CityWeather(
                name = "",
                lat = 0.0,
                lon = 0.0,
                temp = 0.0,
                humidity = 0,
                pressure = 0,
                cloudsPercent = 0,
                feelTemp = 0.0,
                wind = Wind(speed = 0.0, deg = 0),
                day = Day(sunrise = 1725, sunset = 7793),
                weather = Weather(
                    name = "Curt Collins",
                    desc = "consectetuer",
                    imageUrl = "http://www.bing.com/search?q=mus"
                )
            )
        ),
        consumer = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun SearchView_PreviewLoading() {
    SearchView(
        viewState = SearchViewState(
            title = "Title",
            isLoading = true,
            query = "Search",
            weather = CityWeather(
                name = "",
                lat = 0.0,
                lon = 0.0,
                temp = 0.0,
                humidity = 0,
                pressure = 0,
                cloudsPercent = 0,
                feelTemp = 30.31,
                wind = Wind(speed = 32.33, deg = 5283),
                day = Day(sunrise = 6408, sunset = 6099),
                weather = Weather(
                    name = "Karla Griffin",
                    desc = "theophrastus",
                    imageUrl = "https://duckduckgo.com/?q=iuvaret"
                ),

                )
        ),
        consumer = {}
    )
}