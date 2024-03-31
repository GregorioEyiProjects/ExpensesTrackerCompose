package com.example.expensestrackercompose.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.expensestrackercompose.R
import com.example.expensestrackercompose.components.CheckBookComponent
import com.example.expensestrackercompose.components.ClickableLoginRegisterTextComponent
import com.example.expensestrackercompose.components.DividerComponent
import com.example.expensestrackercompose.components.GradientButtonComponent
import com.example.expensestrackercompose.components.SignUpIconsComponent
import com.example.expensestrackercompose.components.TexFieldEmailComponent
import com.example.expensestrackercompose.components.TexFieldNameComponent
import com.example.expensestrackercompose.components.TexFieldPassComponent
import com.example.expensestrackercompose.components.TextComponentTitle
import com.example.expensestrackercompose.data.LoginViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.expensestrackercompose.data.UIEvents
import com.example.expensestrackercompose.data.rules.Validator

@Composable
fun SignUp(
    navController: NavHostController,
    viewModel: LoginViewModel = viewModel()
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)

    ) {
        Spacer(modifier = Modifier.height(50.dp))
        TextComponentTitle(textValue = "Create an Account")
        Spacer(modifier = Modifier.height(60.dp))

        TexFieldNameComponent(
            labelValue = "Name",
            placeholderValue = "Enter your name here",
            onTextSelected = { name ->
                viewModel.onEvent(
                    UIEvents.NameChange(name),
                    navController
                )
            },
            nameError = viewModel.registrationUIState.value.nameError
        )
        Spacer(modifier = Modifier.height(10.dp))

        TexFieldEmailComponent(
            labelValue = "Email",
            placeholderValue = "Enter your email here",
            onTextSelected = { email ->
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
            ontTextSelected = { password ->
                viewModel.onEvent(
                    UIEvents.PasswordChange(password),
                    navController
                )
            },
            passwordError = viewModel.registrationUIState.value.passwordError
        )
        Spacer(modifier = Modifier.height(10.dp))

        CheckBookComponent(
            value = stringResource(R.string.policies_and_term_of_use),
            onTextSelected = {
                navController.navigate("Term_and_conditions")
            },
            onCheckBoxStateChanged = {isChecked ->
                viewModel.onEvent(
                    event = UIEvents.PrivacyPolicyChecked(isChecked),
                    myNavController = navController
                )
            }
        )
        Spacer(modifier = Modifier.height(100.dp))

        GradientButtonComponent(
            textValue = stringResource(R.string.sign_up),
            onButtonClicked = {
                viewModel.onEvent(
                    UIEvents.RegisterButtonClicked,
                    navController
                )
            },
            isEnable = viewModel.allValidationsAreOK.value
        )
        Spacer(modifier = Modifier.height(20.dp))

        DividerComponent()
        Spacer(modifier = Modifier.height(20.dp))

        ClickableLoginRegisterTextComponent(
            initialPartValue = "Already have an account? ",
            lastPartValue = "Login",
            onTextSelected = {
                navController.navigate("SignIn")
            })
        SignUpIconsComponent()
    }
}

@Preview(showSystemUi = true)
@Composable
private fun SignUpPreview() {
    //SignUp(navController)
}