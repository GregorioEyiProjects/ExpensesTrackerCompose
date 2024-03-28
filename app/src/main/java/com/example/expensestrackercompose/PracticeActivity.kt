package com.example.expensestrackercompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Button
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class PracticeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Button()
        }
    }

    //@Preview(showBackground = true)
    @Composable
    fun Button() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                val navigate = Intent(this@PracticeActivity, MainActivity::class.java)
                startActivity(navigate)
            }) {
                Text(text = "Navigate")
            }
        }
    }

   // @Preview(name = "Button Text", widthDp = 200, heightDp = 100, showBackground = true)
    @Composable
    fun ButtonText() {
        Box(
            modifier = Modifier.fillMaxSize(), // ocupar todo el espacio
            contentAlignment = Alignment.Center // centrar el contenido
        ) {
            Text(
                text = "Click here!",
                color = Color.DarkGray,
                fontSize = 24.sp,
                modifier = Modifier
                    .clickable { /*TODO*/ }
                    .background(Color.Blue)
                    .border(width = 2.dp, color = Color.Red)
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            )
        }
    }


}

