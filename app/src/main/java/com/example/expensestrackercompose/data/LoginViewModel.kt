package com.example.expensestrackercompose.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.expensestrackercompose.data.rules.Validator
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {

    private val tag = LoginViewModel::class.simpleName
    var registrationUIState = mutableStateOf(RegistrationUIState())
    var allValidationsAreOK = mutableStateOf(false)

    fun onEvent(
        event: UIEvents,
        myNavController: NavHostController
    ) {

        validateData()

        when (event) {
            is UIEvents.NameChange -> {
                registrationUIState.value = registrationUIState.value.copy(
                    name = event.name
                )
                printState()
                validateData()
            }

            is UIEvents.EmailChange -> {
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )
                printState()
                validateData()
            }

            is UIEvents.PasswordChange -> {
                registrationUIState.value = registrationUIState.value.copy(
                    password = event.password
                )
                printState()
                validateData()
            }

            is UIEvents.PrivacyPolicyChecked -> {
                registrationUIState.value = registrationUIState.value.copy(
                    privacyPolicyRead = event.status
                )
                validateData()
            }

            is UIEvents.RegisterButtonClicked -> {
                validateData()
                createUserAndSignIn()
                myNavController.navigate("Home")
            }

            is UIEvents.LoginButtonClicked -> {
                loginWithEmailAndPasswordToHome(myNavController)
            }
        }
    }


    /*------------------Login into the app method------------------*/
    private fun loginWithEmailAndPasswordToHome(myNavController: NavHostController) {
        signInWithEmailAndPasswordInFirebase(
            email = registrationUIState.value.email,
            password = registrationUIState.value.password,
            navController = myNavController
        )
    }


    /*------------------Login into firebase method------------------*/
    private fun signInWithEmailAndPasswordInFirebase(
        email: String,
        password: String,
        navController: NavHostController
    ) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d(tag, "addOnCompleteListener")
                Log.d(tag, "isSuccessfull = ${it.isSuccessful}")
            }
            .addOnFailureListener {
                Log.d(tag, "addOnFailureListener")
                Log.d(tag, "errorMessage= ${it.message}")
                Log.d(tag, "errorMessage= ${it.localizedMessage}")
            }
            .addOnSuccessListener {
                Log.d(tag, "addOnSuccessListener = ${it.user?.uid}")
                navController.navigate("Home")
            }
    }

    /*------------------Sign up into the app method------------------*/
    private fun createUserAndSignIn() {
        printState()
        createUserInFirebase(
            email = registrationUIState.value.email,
            password = registrationUIState.value.password
        )
    }


    /*-----------------Sign up into firebase method------------------*/
    private fun createUserInFirebase(email: String, password: String) {
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d(tag, "inside_addOnCompleteListener")
                Log.d(tag, "isSuccessfull = ${it.isSuccessful}")
            }
            .addOnFailureListener {
                Log.d(tag, "inside_addOnFailureListener")
                Log.d(tag, "errorMessage= ${it.message}")
                Log.d(tag, "errorMessage= ${it.localizedMessage}")
            }
    }


    /*------------------Data validation------------------*/
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

        val checkBoxResult = Validator.checkBoxIsChecked(
            isChecked = registrationUIState.value.privacyPolicyRead
        )

        Log.d(tag, "inside_validateData")
        Log.d(tag, "nameResult= $nameResult")
        Log.d(tag, "emailResult= $emailResult")
        Log.d(tag, "passwordResult= $passwordResult")
        Log.d(tag, "checkBoxResult= $checkBoxResult")

        //Update the registration state global values
        registrationUIState.value = registrationUIState.value.copy(
            nameError = nameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status,
            privacyPolicyError = checkBoxResult.status
        )

        allValidationsAreOK.value = nameResult.status && emailResult.status && passwordResult.status && checkBoxResult.status

    }


    /*------------------Printing the state------------------*/
    private fun printState() {
        Log.d(tag, "inside_printState")
        Log.d(tag, registrationUIState.value.toString())
    }

}