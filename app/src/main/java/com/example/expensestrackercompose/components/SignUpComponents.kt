package com.example.expensestrackercompose.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.expensestrackercompose.R


@Composable
fun TextComponentTitle(
    textValue: String,
    fontSizeValue: TextUnit = 20.sp
) {
    Text(
        text = textValue,
        color = Color.Black,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(30.dp),
        fontSize = fontSizeValue,
        fontStyle = FontStyle.Normal,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

/*--------------------------Text fields ----------------*/

//Name
@Composable
fun TexFieldNameComponent(
    labelValue: String,
    placeholderValue: String,
    onTextSelected: (String) -> Unit,
    nameError:Boolean = false
) {
    val textName = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_name),
                contentDescription = "Name"
            )
        },
        label = { Text(text = labelValue) },
        placeholder = { Text(text = placeholderValue) },
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        minLines = 1,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedTextColor = colorResource(id = R.color.textFieldColor),
            unfocusedTextColor = colorResource(id = R.color.textFieldColor2),
            cursorColor = Color.Black
        ),
        value = textName.value,
        onValueChange = {
            textName.value = it
            onTextSelected(it)
        },
        isError = !nameError
    )
}

//Email
@Composable
fun TexFieldEmailComponent(
    labelValue: String,
    placeholderValue: String,
    onTextSelected: (String) -> Unit,
    emailError:Boolean = false
) {
    val textEmail = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = "Name"
            )
        },
        label = { Text(text = labelValue) },
        placeholder = { Text(text = placeholderValue) },
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedTextColor = colorResource(id = R.color.textFieldColor),
            unfocusedTextColor = colorResource(id = R.color.textFieldColor2),
            cursorColor = Color.Black
        ),
        value = textEmail.value,
        onValueChange = {
            textEmail.value = it
            onTextSelected(it)
        },
        isError = !emailError
    )
}

//Password
@Composable
fun TexFieldPassComponent(
    labelValue: String,
    placeholderValue: String,
    ontTextSelected: (String) -> Unit,
    passwordError: Boolean = false
) {

    val localFocusManager = LocalFocusManager.current // clear the foc
    val textPassword = remember {
        mutableStateOf("")
    }

    val textPasswordVisible = remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_lock),
                contentDescription = "Name"
            )
        },
        label = { Text(text = labelValue) },
        placeholder = { Text(text = placeholderValue) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
        singleLine = true,
        maxLines = 1,
        keyboardActions = KeyboardActions{
            localFocusManager.clearFocus(true)
        },
        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        ),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedTextColor = colorResource(id = R.color.textFieldColor),
            unfocusedTextColor = colorResource(id = R.color.textFieldColor2),
            cursorColor = Color.Black

        ),
        trailingIcon = {
            val image = if (textPasswordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            val description = if (textPasswordVisible.value) {
                stringResource(R.string.hide_password)
            } else {
                stringResource(R.string.show_password)
            }
            IconButton(onClick = { textPasswordVisible.value = !textPasswordVisible.value }) {
                Icon(imageVector = image, contentDescription = description)
            }
        }, // to toggle the icon
        visualTransformation = if (textPasswordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        value = textPassword.value,
        onValueChange = {
            textPassword.value = it
            ontTextSelected(it)
        },
        isError = !passwordError
    )
}

//------------------------------Button--------------------
@Composable
fun ButtonSignUpComponent(navController: NavHostController) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            modifier = Modifier
                .height(50.dp)
                .width(150.dp),
            shape = RoundedCornerShape(12.dp),
            onClick = {
                // navController.navigate("Term_and_conditions")
            }
        ) {
            Text(
                text = "SIGN UP",
                textAlign = TextAlign.Center,
            )
        }
    }
}


//------------------------------Gradient button---------------------------//

@Composable
fun GradientButtonComponent(
    textValue: String,
    navController: NavHostController,
    onButtonClicked:() -> Unit
) {
    Button(
        onClick = {
            onButtonClicked.invoke()
        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(45.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(45.dp)
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            colorResource(id = R.color.secondaryBtn),
                            colorResource(id = R.color.primaryBtn)
                        )
                    ),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = textValue,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


/*-------------------------- Dividers ----------------*/
@Composable
fun DividerComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Color.Gray,
            thickness = 1.dp
        )

        Text(
            modifier = Modifier.padding(8.dp),
            text = "or",
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Color.Gray,
            thickness = 1.dp
        )
    }
}


/*-------------------------- Policies ----------------*/

@Composable
fun CheckBookComponent(value: String, onTextSelected: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(45.dp),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        val checkBookState = remember {
            mutableStateOf(false)
        }
        Checkbox(checked = checkBookState.value, onCheckedChange = {
            checkBookState.value = !checkBookState.value
        })
        /*Text(
            text = value,
            fontSize = 16.sp,
            fontWeight = FontWeight.Light
        )*/
        ClickableTextComponent(value, onTextSelected)
    }
}

@Composable
fun ClickableTextComponent(textValue: String, onTextSelected: (String) -> Unit) {

    val initialPart = "By continuing you accept out "
    val privacyPolicyText = "Privacy Policy "
    val andText = "and "
    val lastPart = "Terms of Use"

    //var enabled by remember { mutableStateOf(true) }

    val annotatedString = buildAnnotatedString {
        append(initialPart)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.term_and_policy_color))) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.term_and_policy_color))) {
            pushStringAnnotation(tag = lastPart, annotation = lastPart)
            append(lastPart)
        }
    }
    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    Log.d("ClickableTextComponent", "{$span}")
                    if (span.item == privacyPolicyText || span.item == lastPart) {
                        onTextSelected(span.item)
                    }
                }
        })
}

/*-------------------------- Sign up icons (Google and Facebook) ----------------*/
@Composable
fun SignUpIconsComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_google),
            contentDescription = "Google",
            modifier = Modifier.size(45.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_facebook),
            contentDescription = "Facebook",
            modifier = Modifier.size(45.dp)
        )
    }
}

/*-------------------------- Sign up icons (Google and Facebook) ----------------*/
@Composable
fun ClickableLoginRegisterTextComponent(
    initialPartValue:String,
    lastPartValue:String,
    onTextSelected: (String) -> Unit
) {

    //val initialPart = "Already have an account?"
    //val lastPart = "Login"
    //var enabled by remember { mutableStateOf(true) }

    val annotatedString = buildAnnotatedString {
        append(initialPartValue)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.loginTextColor))) {
            pushStringAnnotation(tag = lastPartValue, annotation = lastPartValue)
            append(lastPartValue)
        }
    }
    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(40.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    if (span.item == lastPartValue) {
                        onTextSelected(span.item)
                    }
                }
        })
}


/*--------------------- Previews -----------------------------*/

@Preview(showBackground = true)
@Composable
private fun TextComponentPreview() {
    TextComponentTitle("Registration")
}

@Preview(showBackground = true)
@Composable
private fun TexFieldNameComponentPreview() {
    //TexFieldNameComponent("Name", "Enter your name here")
}

@Preview(showBackground = true)
@Composable
private fun TexFieldEmailComponentPreview() {
    //TexFieldEmailComponent("Email", "Enter your email here")
}

@Preview(showBackground = true)
@Composable
private fun TexFieldPassComponentPreview() {
   // TexFieldPassComponent("Password", "Enter your password here")
}

@Preview(showBackground = true)
@Composable
private fun ButtonSignUpComponentPreview() {
    // ButtonSignUpComponent(navController)
}

@Preview(showBackground = true)
@Composable
private fun SignUpIconsComponentPreview() {
    SignUpIconsComponent()
}

@Preview(showBackground = true)
@Composable
private fun CheckBookComponentPreview() {
    //CheckBookComponent(stringResource(id = R.string.policies_and_term_of_use))
}

@Preview
@Composable
private fun GradientButtonComponentPreview() {
    // GradientButtonComponent("SignUp")
}

@Preview
@Composable
private fun DividerComponentPreview() {
    DividerComponent()
}