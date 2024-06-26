package com.example.expensestrackercompose.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {
    data object SignUpScreen : Screen()
    data object TermOfUseScreen : Screen()
}

object ExpensesTrackerRouter {

    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.SignUpScreen)
    fun navigateTo(destination: Screen){
        currentScreen.value = destination
    }

}