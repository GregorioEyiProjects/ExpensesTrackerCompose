package com.example.expensestrackercompose.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.expensestrackercompose.data.rules.Validator

class LoginViewModel : ViewModel() {

    private val TAG = LoginViewModel::class.simpleName
    var registrationUIState = mutableStateOf(RegistrationUIState())

    fun onEvent(
        event: UIEvents,
        navController: NavHostController
    ) {
        validateData()
        when (event) {
            is UIEvents.NameChange -> {
                registrationUIState.value = registrationUIState.value.copy(
                    name = event.name
                )
                printState()
            }

            is UIEvents.EmailChange -> {
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )
                printState()
            }

            is UIEvents.PasswordChange -> {
                registrationUIState.value = registrationUIState.value.copy(
                    password = event.password
                )
                printState()
            }

            is UIEvents.RegisterButtonClicked -> {
                //validate data here and navigate to HOME screen
                printState()
                validateData()
                Log.d(TAG, "Button SIGN UP was clicked!")
                //navController.navigate("Home")
            }
        }
    }

    private fun validateData() {
        val nameResult = Validator.nameValidation(
            name = registrationUIState.value.name
        )
        val emailResult = Validator.emailValidation(
            email = registrationUIState.value.email
        )
        val passwordResult = Validator.passwordValidation(
            password = registrationUIState.value.password
        )

        Log.d(TAG, "inside_validateData")
        Log.d(TAG, "nameResult= $nameResult")
        Log.d(TAG, "emailResult= $emailResult")
        Log.d(TAG, "passwordResult= $passwordResult")

        //Update the registration state value
        registrationUIState.value = registrationUIState.value.copy(
            nameError = nameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )

    }

    private fun printState() {
        Log.d(TAG, "inside_printState")
        Log.d(TAG, registrationUIState.value.toString())

    }
}