package com.example.expensestrackercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.expensestrackercompose.app.ExpensesTracker
import com.example.expensestrackercompose.navigation.Nav
import com.example.expensestrackercompose.screens.SignUp
import com.example.expensestrackercompose.screens.VerticalScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Nav()
        }
    }
}



