package com.example.expensestrackercompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensestrackercompose.R

/*-----------Text--------------*/

@Composable
fun TextComponentTitle(
    textValue: String,
    colorValue: Color = Color.Black,
    fontSize: TextUnit = 16.sp,
    fontStyle: FontStyle = FontStyle.Normal,
    fontWeight: FontWeight = FontWeight.Normal,
    maxLinesValue: Int? = null,
    backgroundColor: Color = Color.White
) {
    Text(
        modifier = Modifier
            .wrapContentWidth(align = Alignment.Start)
            .wrapContentHeight(align = Alignment.Top) // For this one to work, it has to have a fillMaxSize()
            .alpha(0.8f) // Opacity
            .background(backgroundColor)
            .padding(10.dp),
        //.clip(shape = RoundedCornerShape(20.dp))
        //.border(width = 2.dp, Color.Gray)
        text = textValue,
        color = colorValue,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        maxLines = maxLinesValue ?: Int.MAX_VALUE,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview
@Composable
private fun TextComponentPreview() {
    TextComponentTitle("Expenses Tracker")
}


@Composable
fun NormalTextComponent(
    textValue: String,
    alignment: TextAlign = TextAlign.Start
) {
    Text(
        text = textValue,
        Modifier
            .fillMaxWidth()
            .padding(8.dp),
        textAlign = alignment
    )
}

//@Preview(showBackground = true)
@Composable
private fun NormalTextComponentPreview() {
    NormalTextComponent("Submit")
}


/*-----------Buttons--------------*/

@Composable
fun ButtonComponent() {
    Button(
        onClick = { /*TODO*/ },
        Modifier.height(48.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        NormalTextComponent(textValue = "Submit", alignment = TextAlign.Center)
    }
}

@Preview
@Composable
private fun ButtonComponentPreview() {
    ButtonComponent()
}


/*-----------Text fields -------------*/
@Composable
fun TextFieldEmailComponent() {
    var text by remember {
        mutableStateOf("")
    }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontFamily = FontFamily.Monospace
        ),
        label = {
            NormalTextComponent(textValue = "Name")
        },
        placeholder = {
            NormalTextComponent(textValue = "Enter your name here.")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}

@Composable
fun TextFieldPassComponent() {
    var text by remember {
        mutableStateOf("")
    }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontFamily = FontFamily.Monospace
        ),
        label = {
            NormalTextComponent(textValue = "Password")
        },
        placeholder = {
            NormalTextComponent(textValue = "Enter your password here.")
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
}


/*----------- Images--------------*/
@Composable
fun ImageComponent(){
    Image(
        modifier = Modifier
            .size(150.dp)
            .clip(CircleShape),
        painter = painterResource(id = R.drawable.santander),
        contentDescription ="Santander",
        contentScale = ContentScale.FillBounds) // to get the predefine image from composable
}

/*----------- List --------------*/
@Composable
fun ListComponent(){

    val someRandomValues = listOf("Hey", "What is up", "Just doing random stuff", "I yeah?", "Like what?", "I do not really know buddy")
    LazyColumn() {
        items(someRandomValues){newItem ->
            NormalTextComponent(textValue = newItem)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ListComponentPreview() {
    ListComponent()
}





