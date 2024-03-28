package com.example.expensestrackercompose.screens

import com.example.expensestrackercompose.components.ButtonComponent
import com.example.expensestrackercompose.components.TextComponentTitle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensestrackercompose.components.ImageComponent
import com.example.expensestrackercompose.components.TextFieldEmailComponent
import com.example.expensestrackercompose.components.TextFieldPassComponent

@Composable
fun VerticalScreen() {
    Column(
        Modifier.padding(20.dp)
    ) {
        TextComponentTitle(
            textValue = "Hello there!",
            colorValue = Color.Blue,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
            )
        //TextComponent(textValue = "Enter your name")
        TextFieldEmailComponent()
        Spacer(modifier = Modifier.height(10.dp))
        TextFieldPassComponent()
        Spacer(modifier = Modifier.height(50.dp))
        ButtonComponent()
        Spacer(modifier = Modifier.height(15.dp))
        ImageComponent()
    }
}

@Preview(showSystemUi = true)
@Composable
private fun VerticalScreenPreview() {
    VerticalScreen()
}