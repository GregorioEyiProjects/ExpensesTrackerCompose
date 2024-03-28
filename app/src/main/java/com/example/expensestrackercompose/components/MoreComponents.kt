package com.example.expensestrackercompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensestrackercompose.R


@Preview(showSystemUi = true)
@Composable
fun UIScreen() {

    Scaffold(
        topBar = {
            AppToolBar(
                toolBarTitle = stringResource(R.string.expenses_tracker),
                fontSize = 20.sp
            ) },

        content = {
                paddingValues -> MyScreenContent(padding = paddingValues)
        },

        floatingActionButton = { }
    )
}

@Composable
fun AppToolBar(
    toolBarTitle: String,
    fontSize: TextUnit = 18.sp,
    fontStyle: FontStyle = FontStyle.Normal,
    fontWeight: FontWeight = FontWeight.Normal,
    maxLinesValue:Int? = null,
    backgroundColor: Color = Color.White
) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.Start)
            .wrapContentHeight(align = Alignment.Top) // For this one to work, it has to have a fillMaxSize()
            .alpha(0.8f) // Opacity
            .background(backgroundColor)
            .padding(10.dp),
        //.clip(shape = RoundedCornerShape(20.dp))
        //.border(width = 2.dp, Color.Gray)

        text = toolBarTitle,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        maxLines = maxLinesValue ?: Int.MAX_VALUE,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun MyScreenContent(padding: PaddingValues) {

}


/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolBar(toolBarTitle:String,
) {
   TopAppBar(
       title = { Text(text = toolBarTitle)},
       navigationIcon = {
           Icon(
               imageVector = Icons.Filled.Menu,
               contentDescription = stringResource(R.string.menu),
               modifier = Modifier.clickable {  },
               tint = Color.Blue
           )
       }

   )
}


@Composable
fun Content2(padding: PaddingValues) {
    Surface(
        modifier = Modifier.fillMaxWidth(), // 0.8f -> Occupies 80% width
        color = Color.LightGray,
        shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomStart = 40.dp,
            bottomEnd = 40.dp
        )
    ) {
        Column(
            Modifier.padding(padding)
        ) {
            Text(text = stringResource(R.string.welcome_back))
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


@Composable
fun MyScreenContent(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxWidth(), // 0.8f -> Occupies 80% width
        color = Color.LightGray,
        shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomStart = 40.dp,
            bottomEnd = 40.dp
        )
    ) {
        Column(
            Modifier.padding(15.dp)
        ) {
            Text(text = stringResource(R.string.welcome_back))
            Spacer(modifier = Modifier.height(16.dp))
        }
    }


}
* */