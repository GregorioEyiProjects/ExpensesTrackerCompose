package com.example.expensestrackercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class AuthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuthenticationUI()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AuthenticationUI() {

    var textState by remember { mutableStateOf(" ") }

    Column (
        Modifier
            .fillMaxSize()
            .background(Color.Magenta),
        verticalArrangement = Arrangement.Center

    ){

        //Fist component --Email and password--
        Column (
            Modifier
                .background(Color.Red)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            //First column --Email--
            TextField(
                value = textState,
                onValueChange = { textState = it },
                label = { Text("Enter your E-mail") },
                modifier = Modifier.padding(16.dp)
            )

            //Second column --Password--
            TextField(
                value = textState,
                onValueChange = { textState = it },
                label = { Text("Enter your Password") },
                modifier = Modifier.padding(16.dp)
            )
        }

        //Second component --Button inside a row--
        Row (
            Modifier
                .fillMaxWidth()
                .background(Color.Gray),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { sendInfo(textState) }
            ) {
                Text(text = "Submit")
            }
        }
    }

}

fun sendInfo(textState: String) {
   //
}

