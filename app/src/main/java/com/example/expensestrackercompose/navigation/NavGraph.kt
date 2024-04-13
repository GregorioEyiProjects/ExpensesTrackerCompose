package com.example.expensestrackercompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expensestrackercompose.screens.Home
import com.example.expensestrackercompose.screens.SignIn
import com.example.expensestrackercompose.screens.SignUp
import com.example.expensestrackercompose.screens.TermAndUsesPolicy

@Composable
fun Nav(){

    val myNavController = rememberNavController()

    NavHost(navController = myNavController, startDestination = "Home"){

        composable(route = "SignIn"){
            SignIn(myNavController)
        }
        composable(route = "SignUp"){
            SignUp(myNavController)
        }
        composable(route = "Term_and_conditions"){
            TermAndUsesPolicy(myNavController)
        }
        composable(route="Home"){
            Home(myNavController)
        }

    }
}