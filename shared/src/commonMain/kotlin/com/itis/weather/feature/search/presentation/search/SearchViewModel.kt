package com.itis.weather.feature.search.presentation.search

import androidx.lifecycle.viewModelScope
import com.itis.weather.core.viewmodel.BaseViewModel
import com.itis.weather.di.PlatformSDK
import com.itis.weather.feature.search.usecase.GetWeatherByNameUseCase
import kotlinx.coroutines.launch

class SearchViewModel : BaseViewModel<SearchViewState, SearchAction, SearchEvent>(
    initState = SearchViewState()
) {

    private val getWeatherByNameUseCase: GetWeatherByNameUseCase by PlatformSDK.lazyInstance()

    override fun obtainEvent(event: SearchEvent) {
        when (event) {
            SearchEvent.OnSearchClick -> onSearchClick()
            SearchEvent.OnCloseClick -> onCloseClick()
            is SearchEvent.OnQueryChange -> onQueryChange(event.text)
        }
    }

    private fun onSearchClick() {
        viewModelScope.launch {
            try {
                viewState
                val weather = getWeatherByNameUseCase.invoke(viewState.query)
                viewState = viewState.copy(
                    weather = weather
                )
            } catch (ex: Throwable) {
                viewAction = SearchAction.ShowError(
                    title = "TITLE ERROR",
                    desc = "Desc message"
                )
            }
        }
    }

    private fun onCloseClick() {
        viewAction = SearchAction.Close
    }

    private fun onQueryChange(text: String) {
        viewState = viewState.copy(
            query = text
        )
    }
}
