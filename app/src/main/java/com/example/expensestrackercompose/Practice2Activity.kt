package com.example.expensestrackercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Practice2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*ExpensesTrackerComposeTheme {
            }*/
            ScreenUIPractice()

        }
    }
}


@Composable
fun ScreenUIPractice() {
    Column (
        Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.Start // it only works when there is not fillMAxWith in the children
        //verticalArrangement = Arrangement.Center //This one moves the children to the center of the screen
    ) {

        Surface(
            color = Color.Magenta,
            modifier = Modifier.fillMaxWidth(),

        ) {
            Text(
                text = "Surface text",
                Modifier.padding(24.dp)
            )
        }

        Box (
            Modifier
                .background(MaterialTheme.colorScheme.background)
        ){
            Text(
                text = "Box text",
                Modifier
                    .background(Color.Blue)
                    .padding(20.dp),
                color = Color.White,
            )
        }

        Surface (
            Modifier.padding(top = 5.dp)
        ) {
            Row (
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Text",
                    Modifier
                        .padding(10.dp)
                        .weight(0.4f) // Added weight modifier
                        .wrapContentWidth(Alignment.End) // Aligns the text to the end of the Row
                )
                Text(
                    text = "Text 2",
                    Modifier
                        .padding(10.dp)
                        .weight(0.3f) // Added weight modifier
                        .wrapContentWidth(Alignment.End) // Aligns the text to the end of the Row
                )
                Text(
                    text = "Text 3",
                    Modifier
                        .padding(10.dp)
                        .weight(0.3f) // Added weight modifier
                        .wrapContentWidth(Alignment.End) // Aligns the text to the end of the Row
                )
            }
        }

        Surface (
            Modifier.padding(top = 20.dp)
        ) {
            Row (
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Text",
                    Modifier
                        .padding(10.dp)
                )
                Text(
                    text = "Text 2",
                    Modifier
                        .padding(10.dp)
                )
                Text(
                    text = "Text 3",
                    Modifier
                        .padding(10.dp)
                )
            }
        }

        Surface(
            modifier = Modifier
            .fillMaxWidth()
            .width(300.dp)
            .height(300.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.santander),
                contentDescription = "Practice",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
                alpha = 0.7f
                //alignment = Alignment.Center
                //colorFilter = ColorFilter.tint(Color.Cyan)

            )
        }


    }



}