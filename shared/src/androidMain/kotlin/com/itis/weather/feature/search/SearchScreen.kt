package com.itis.weather.feature.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.itis.weather.feature.search.presentation.search.SearchAction
import com.itis.weather.feature.search.presentation.search.SearchEvent
import com.itis.weather.feature.search.presentation.search.SearchViewModel
import com.itis.weather.utils.rememberClick

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = viewModel()
) {
    val state by viewModel.viewStates.collectAsState()
    val action by viewModel.viewActions.collectAsState(initial = null)
    val consumer = rememberClick<SearchEvent> { viewModel.obtainEvent(it) }

    SearchView(
        viewState = state,
        consumer = consumer,
    )

    SearchAction(action = action)
}

@Composable
private fun SearchAction(
    action: SearchAction?
) {
    LaunchedEffect(action) {
        when (action) {
            null -> Unit
            SearchAction.Close -> TODO()
            is SearchAction.OpenDetailsScreen -> TODO()
            is SearchAction.ShowError -> TODO()
        }
    }
}
