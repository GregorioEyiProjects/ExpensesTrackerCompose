package com.example.expensestrackercompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.expensestrackercompose.components.ClickableLoginRegisterTextComponent
import com.example.expensestrackercompose.components.DividerComponent
import com.example.expensestrackercompose.components.GradientButtonComponent
import com.example.expensestrackercompose.components.SignUpIconsComponent
import com.example.expensestrackercompose.components.TexFieldPassComponent
import com.example.expensestrackercompose.components.TextComponentForPasswordForgotten
import com.example.expensestrackercompose.components.TextComponentTitle
import com.example.expensestrackercompose.components.TextFieldComponent
import com.example.expensestrackercompose.data.LoginViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.expensestrackercompose.data.UIEvents

@Composable
fun SignIn(
    navController: NavHostController,
    viewModel: LoginViewModel = viewModel()
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ){
        Spacer(modifier = Modifier.height(50.dp))
        TextComponentTitle(textValue = "Welcome back")
        Spacer(modifier = Modifier.height(60.dp))

        //Email component
        TextFieldComponent(
            textValue = "Email",
            placeholderValue = "Enter your email here",
            onTextSelected = {email ->
                viewModel.onEvent(
                    UIEvents.EmailChange(email),
                    navController
                )
            },
            emailError = viewModel.registrationUIState.value.emailError
            )
        Spacer(modifier = Modifier.height(10.dp))

        //Password component
        TexFieldPassComponent(
            labelValue = "Password",
            placeholderValue = "Enter your password here",
            ontTextSelected = {password ->
                viewModel.onEvent(
                    UIEvents.PasswordChange(password),
                    navController
                )
            },
            passwordError = viewModel.registrationUIState.value.passwordError
        )
        Spacer(modifier = Modifier.height(10.dp))

        //Password forgotten component
        TextComponentForPasswordForgotten()
        Spacer(modifier = Modifier.height(200.dp))

        //BTN Sign In component
        GradientButtonComponent(
            textValue = "LOG IN",
            onButtonClicked = {
                viewModel.onEvent(
                    event = UIEvents.LoginButtonClicked,
                    myNavController = navController
                )
            },
            isEnable = viewModel.registrationUIState.value.passwordError
            )
        Spacer(modifier = Modifier.height(10.dp))

        //Divider component
        DividerComponent()
        Spacer(modifier = Modifier.height(20.dp))

        //Clickable text component
        ClickableLoginRegisterTextComponent(
            initialPartValue = "Don't you have an account yet? ",
            lastPartValue = "Register",
            onTextSelected = {
            navController.navigate("SignUp")
        })
        SignUpIconsComponent()
    }
}

@Preview(showSystemUi = true)
@Composable
private fun SignUpPreview() {
    val myNavController = rememberNavController()
    SignIn(myNavController)
}