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
    myNavController: NavHostController,
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

        TextFieldComponent(
            textValue = "Email",
            placeholderValue = "Enter your email here",
            onTextSelected = {email ->
                viewModel.onEvent(
                    UIEvents.EmailChange(email),
                    myNavController
                )
            })
        Spacer(modifier = Modifier.height(10.dp))

        TexFieldPassComponent(
            labelValue = "Password",
            placeholderValue = "Enter your password here",
            ontTextSelected = {password ->
                viewModel.onEvent(
                    UIEvents.PasswordChange(password),
                    myNavController
                )
            })
        Spacer(modifier = Modifier.height(10.dp))

        TextComponentForPasswordForgotten()
        Spacer(modifier = Modifier.height(200.dp))

        GradientButtonComponent(
            textValue = "LOG IN",
            navController = myNavController,
            onButtonClicked = {}
            )
        Spacer(modifier = Modifier.height(10.dp))

        DividerComponent()
        Spacer(modifier = Modifier.height(20.dp))

        ClickableLoginRegisterTextComponent(
            initialPartValue = "Don't you have an account yet? ",
            lastPartValue = "Register",
            onTextSelected = {
            myNavController.navigate("SignUp")
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