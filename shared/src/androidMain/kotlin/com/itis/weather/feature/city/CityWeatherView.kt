package com.itis.weather.feature.city

import androidx.annotation.DrawableRes
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.itis.weather.R
import com.itis.weather.core.design.PurpleMain
import com.itis.weather.feature.search.presentation.city.CityWeatherEvent
import com.itis.weather.feature.search.presentation.city.CityWeatherViewState
import com.itis.weather.utils.shimmerEffect2
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import java.util.Locale

@Composable
fun CityWeatherView(
    viewState: CityWeatherViewState,
    eventConsumer: (CityWeatherEvent) -> Unit,
) {
    Scaffold(
        topBar = {
            Toolbar(
                title = viewState.name,
                onSearchClick = {},
                onSettingsClick = {}
            )
        },
    ) { paddingValues ->
        Crossfade(
            targetState = viewState.isLoading,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) { isLoading ->
            if (isLoading) {
                LoadingView()
            } else {
                Content(viewState, eventConsumer)
            }
        }
    }
}

@Composable
private fun Toolbar(
    title: String,
    onSearchClick: () -> Unit,
    onSettingsClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = onSearchClick,
            modifier = Modifier
                .padding(start = 4.dp),
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                tint = MaterialTheme.colorScheme.onBackground,
                contentDescription = null,
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            modifier = Modifier,
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = onSettingsClick,
            modifier = Modifier
                .padding(start = 4.dp),
        ) {
            Icon(
                imageVector = Icons.Default.Settings,
                tint = MaterialTheme.colorScheme.onBackground,
                contentDescription = null,
            )
        }
    }
}

@Composable
private fun MaterialsCard(
    name: String,
    shape: Shape,
    state: HazeState,
    style: HazeStyle,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = shape,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ),
        modifier = modifier.size(160.dp),
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            Text(name)
        }
    }
}

@Composable
private fun Content(
    viewState: CityWeatherViewState,
    eventConsumer: (CityWeatherEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(48.dp))

            Row {
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = viewState.temp,
                    style = MaterialTheme.typography.headlineLarge
                )
                if (viewState.weatherIconUrl.isNotEmpty()) {
                    AsyncImage(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(52.dp),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(viewState.weatherIconUrl)
                            .crossfade(true)
                            .build(),
                        contentDescription = null
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                modifier = Modifier,
                text = viewState.weatherDesc.capitalize(Locale.getDefault()),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary,
            )
            Text(
                modifier = Modifier,
                text = viewState.feelTemp,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
            )
        }

        Spacer(modifier = Modifier.height(56.dp))

        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            ) {
                DetailHolder(
                    title = "Pressure",
                    icon = R.drawable.img_pressure,
                    modifier = Modifier.weight(1f, true)
                ) {
                    Text(
                        text = viewState.pressure,
                        style = MaterialTheme.typography.headlineMedium,
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                DetailHolder(
                    title = "Wind",
                    icon = R.drawable.img_wind,
                    modifier = Modifier.weight(1f, true)
                ) {
                    Text(
                        text = viewState.windSpeed,
                        style = MaterialTheme.typography.headlineMedium,
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            ) {
                DetailHolder(
                    title = "Humidity",
                    icon = R.drawable.img_water,
                    modifier = Modifier.weight(1f, true)
                ) {
                    Text(
                        text = viewState.humidity,
                        style = MaterialTheme.typography.headlineMedium,
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                DetailHolder(
                    title = "Clouds",
                    icon = R.drawable.img_cloud,
                    modifier = Modifier.weight(1f, true)
                ) {
                    Text(
                        text = viewState.cloudsPercent,
                        style = MaterialTheme.typography.headlineMedium,
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            ) {
                DetailHolder(
                    title = "Sunrise",
                    icon = R.drawable.img_sunrise,
                    modifier = Modifier.weight(1f, true)
                ) {
                    Text(
                        text = viewState.sunrise,
                        style = MaterialTheme.typography.headlineMedium,
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                DetailHolder(
                    title = "Sunset",
                    icon = R.drawable.img_sunset,
                    modifier = Modifier.weight(1f, true)
                ) {
                    Text(
                        text = viewState.sunset,
                        style = MaterialTheme.typography.headlineMedium,
                    )
                }
            }
        }
    }
}

@Composable
private fun DetailHolder(
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes icon: Int,
    content: @Composable () -> Unit
) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(112.dp)
                .border(
                    1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    RoundedCornerShape(12.dp)
                )
                .blur(
                    radius = 24.dp,
                    edgeTreatment = BlurredEdgeTreatment(shape = RoundedCornerShape(10.dp)),
                )
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.White, PurpleMain),
                    ),
                    shape = RoundedCornerShape(10.dp),
                    alpha = 0.2f,
                )
        )
        Column(Modifier.padding(8.dp)) {
            Row {
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = title)
            }

            content()
        }
    }
}

@Composable
private fun LoadingView() {
    Column {
        Spacer(modifier = Modifier.height(48.dp))

        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(96.dp)
                .clip(CircleShape)
                .shimmerEffect2()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(20.dp)
                .width(160.dp)
                .clip(RoundedCornerShape(4.dp))
                .shimmerEffect2()
        )
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(18.dp)
                .width(120.dp)
                .clip(RoundedCornerShape(4.dp))
                .shimmerEffect2()
        )

        Spacer(modifier = Modifier.height(56.dp))

        repeat((1..3).count()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f, true)
                        .height(112.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .shimmerEffect2()
                )

                Spacer(modifier = Modifier.width(16.dp))

                Box(
                    modifier = Modifier
                        .weight(1f, true)
                        .height(112.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .shimmerEffect2()
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CityWeatherView_Preview() {
    MaterialTheme {
        CityWeatherView(
            viewState = CityWeatherViewState(
                name = "Kazan",
                isLoading = false,
            ), eventConsumer = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CityWeatherView_PreviewLoading() {
    MaterialTheme {
        CityWeatherView(
            viewState = CityWeatherViewState(
                name = "Kazan",
                isLoading = true,
            ), eventConsumer = {}
        )
    }
}
