package com.example.expensestrackercompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensestrackercompose.ui.theme.ExpensesTrackerComposeTheme


class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContent()
        }
    }
}

//@Preview(showBackground = true)
@Composable
private fun ViewContent() {
    Scaffold(
        topBar = { ToolBar() },
        content = { padding -> Content(padding) },
        floatingActionButton = { FAB() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolBar() {
    TopAppBar(
        title = {
            Text(text = "Gregorio", color = Color.Black)
        },
        modifier = Modifier.background(colorResource(id = R.color.topBarBg)), //¿Why ins't taking the bg color?
    )
}

@Composable
fun FAB() {
    val context = LocalContext.current
    FloatingActionButton(onClick = {
        Toast.makeText(context, "Clicked", Toast.LENGTH_LONG).show()
    }) {
        Text(text = "X")
    }
}

@Composable
fun Content(padding: PaddingValues) {
    /**/
    ExpensesTrackerComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting("Gregorio")
            myMovieTheme()
        }
    }
    //Greeting("Gregorio")
}

/*@Preview(
    showBackground = true,
    name = "Movies",
    widthDp = 300,
    heightDp = 300
)*/
@Composable
fun myMovieTheme() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Greeting2(name = "Gregorio")
        Greeting2(name = "EYI", modifier = Modifier.align(Alignment.BottomCenter))
    }
}



@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var counter by rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = modifier
            .padding(10.dp)
            .background(Color.Gray)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "A test logo",
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Text(
            text = "Hello $name!",
            fontSize = 30.sp,
            color = Color.White,
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Learning composable",
            fontSize = 23.sp,
            color = Color.Blue,
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        ) {
            Text(text = "Java")
            Text(text = "Kotlin")
            Text(text = "Python")
        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 30.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_likes),
                contentDescription = "likes",
                modifier = modifier.clickable { counter++ }
            )
            Text(
                text = counter.toString(),
                color = Color.White,
                modifier = modifier.padding(start = 5.dp)
            )
        }
    }
}