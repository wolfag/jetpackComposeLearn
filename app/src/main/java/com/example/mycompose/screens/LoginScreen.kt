package com.example.mycompose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mycompose.navigation.HOME_ROUTE
import com.example.mycompose.navigation.Screen

@Composable
fun LoginScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login", fontSize = MaterialTheme.typography.h3.fontSize)
        Text(text = "Back", modifier = Modifier.clickable {
            navHostController.popBackStack()
//            navHostController.navigate(Screen.Detail.passId(1))
        })
    }
}

@Composable
@Preview(showBackground = true)
private fun Preview() {
    LoginScreen(navHostController = rememberNavController())
}