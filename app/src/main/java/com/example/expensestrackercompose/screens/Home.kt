package com.example.expensestrackercompose.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.expensestrackercompose.R
import com.example.expensestrackercompose.components.AppToolBar
import com.example.expensestrackercompose.components.NavigationDrawerHeader
import com.example.expensestrackercompose.data.LoginViewModel
import com.example.expensestrackercompose.data.NavigationItems
import kotlinx.coroutines.launch

@Composable
fun Home(navController: NavHostController) {

    val scope = rememberCoroutineScope()
    val myDrawerState = rememberDrawerState(DrawerValue.Closed)
    val items = listOf(
        NavigationItems(
            navTitle = "Home",
            description = "home description",
            itemId = "homeScreen",
            icon = Icons.Filled.House
        ),
        NavigationItems(
            navTitle = "Favorite",
            description = "Fav description",
            itemId = "favoriteScreen",
            icon = Icons.Filled.Favorite
        ),
        NavigationItems(
            navTitle = "Mail",
            description = "main description",
            itemId = "mailScreen",
            icon = Icons.Filled.Email
        ),
        NavigationItems(
            navTitle = "Settings",
            description = "settings description",
            itemId = "settingsScreen",
            icon = Icons.Filled.Settings
        )
    )
    var selectedItem by remember { mutableStateOf(items[0]) }

    ModalNavigationDrawer(
        drawerState = myDrawerState,
        drawerContent = {
            ModalDrawerSheet {
                NavigationDrawerHeader()
                items.forEach {
                    NavigationDrawerItem(
                        label = { Text(text = it.navTitle) },
                        selected = it == selectedItem,
                        onClick = {
                            scope.launch { myDrawerState.close() }
                            selectedItem = it
                            Log.d("ModalNavigationDrawer", "The item clicked is $it")
                        },
                        icon = {Icon(imageVector = it.icon, contentDescription = it.description)},
                        //badge = { Text(text = "What is badge")},
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                }
            }
        },
        content = {
            HomeContent(
                navController,
                onClick = { scope.launch { myDrawerState.open() } }
            )
        }
    )
}

@Composable
fun HomeContent(
    navController: NavHostController,
    onClick: () -> Unit
) {
    Scaffold(
        topBar = {
            AppToolBar(
                topBarTitle = "Home",
                navController,
                onClickOpenClose = {
                    onClick()
                }
            )
        }

    ) { paddingValues ->

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        ) {
            Text(
                text = "",
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.color_text)
            )
        }

    }
}