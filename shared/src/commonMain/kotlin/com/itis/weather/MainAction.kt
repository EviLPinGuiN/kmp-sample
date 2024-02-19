package com.itis.weather

sealed class MainAction {
    data object Close : MainAction()
    data class ShowMessage(val name: String) : MainAction()
}

sealed interface MainIntAction {
    data object Close : MainIntAction
    data class ShowMessage(val name: String) : MainIntAction
}