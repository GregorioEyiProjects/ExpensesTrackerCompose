package com.example.expensestrackercompose.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensestrackercompose.data.NavigationItems

@Composable
fun TextComponent(
    textValue: String,
    fontSizeValue: TextUnit = 20.sp,
    textAlignValue: TextAlign = TextAlign.Center
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
        textAlign = textAlignValue
    )
}

@Composable
fun NavigationDrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp)
    ) {
        TextComponent(textValue = "Navigation header")
    }
}

@Composable
fun NavigationDrawerBody(navItems: List<NavigationItems>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
       items(navItems){
           NavigationItemRow(item = it)
       }
    }
}

@Composable
fun NavigationItemRow(item: NavigationItems) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Icon(
            imageVector = item.icon,
            contentDescription = item.description
        )
        Spacer(modifier = Modifier.width(12.dp))
        TextComponent(textValue = item.navTitle)
    }
}

@Preview(showBackground = true)
@Composable
private fun NavigationDrawerHeaderPreview() {
    NavigationDrawerHeader()
}

