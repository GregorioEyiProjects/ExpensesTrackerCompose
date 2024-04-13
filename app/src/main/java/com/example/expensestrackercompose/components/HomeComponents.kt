package com.example.expensestrackercompose.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.expensestrackercompose.ui.theme.AppTopBarColor
import com.example.expensestrackercompose.ui.theme.BlackColor
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolBar(
    topBarTitle: String,
    navController: NavHostController,
    onClickOpenClose: () -> Unit
) {
    TopAppBar(
        modifier = Modifier.background(AppTopBarColor),
        title = {
            TextComponent(
                textValue = topBarTitle
            )
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Menu",
                tint = BlackColor,
                modifier = Modifier.clickable { onClickOpenClose() }
            )
        },
        actions = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.Logout,
                contentDescription = "Logout",
                tint = BlackColor,
                modifier = Modifier.clickable {
                    logOutFromFirebase(navController)
                }
            )
        }
    )
}


fun logOutFromFirebase(navController: NavHostController) {
    val firebaseAuth = FirebaseAuth.getInstance()
    firebaseAuth.signOut()

    val authStateListener = AuthStateListener {

        if (it.currentUser == null) {

            navController.navigate("SignIn")

            Log.d("logOutFromFirebase", "It was successful")
            Log.d("logOutFromFirebase", "successful= $it")
        } else {
            Log.d("logOutFromFirebase", "Fail on logout!")
            Log.d("logOutFromFirebase", "Error= $it")
        }
    }

    firebaseAuth.addAuthStateListener(authStateListener)

}
