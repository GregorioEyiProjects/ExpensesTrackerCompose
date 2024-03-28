package com.example.expensestrackercompose.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.expensestrackercompose.navigation.ExpensesTrackerRouter
import com.example.expensestrackercompose.navigation.Screen
import com.example.expensestrackercompose.screens.SignUp
import com.example.expensestrackercompose.screens.TermAndUsesPolicy

@Composable
fun ExpensesTracker() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Crossfade(targetState = ExpensesTrackerRouter.currentScreen, label = "crossroad") { currentState ->
            when (currentState.value){
                is Screen.SignUpScreen -> {
                    //SignUp(navController)
                }
                is Screen.TermOfUseScreen ->{
                    //TermAndUsesPolicy(navController)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ExpensesTrackerPreview() {
    ExpensesTracker()
}