package com.example.expensestrackercompose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.expensestrackercompose.R


@Composable
fun TextFieldComponent(
    textValue:String,
    placeholderValue:String,
    onTextSelected: (String) -> Unit,
    emailError:Boolean = false
){
    val textName = remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_email),
                contentDescription = "email"
            )
        },
        label = { Text(text = textValue) },
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
        isError = !emailError //Assign the opposite value
        )
}

@Composable
fun TextComponentForPasswordForgotten(){
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "Forgot your password?",
        textAlign = TextAlign.Center,
        color = colorResource(id = R.color.textField_bg),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            textDecoration = TextDecoration.Underline
        )

    )
}

@Preview(showBackground = true)
@Composable
private fun TextComponentForPasswordForgottenPreview() {
    TextComponentForPasswordForgotten()
}