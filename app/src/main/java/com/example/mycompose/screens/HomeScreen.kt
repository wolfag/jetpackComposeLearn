package com.example.mycompose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mycompose.navigation.AUTH_ROUTE
import com.example.mycompose.navigation.Screen

@Composable
fun HomeScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Home Screen",
            fontSize = MaterialTheme.typography.h3.fontSize,
            modifier = Modifier.clickable {
                navHostController.navigate(route = Screen.Detail.passId(1))
            }
        )
        Text(
            text = "Auth",
            modifier = Modifier
                .padding(top = 150.dp)
                .clickable {
                    navHostController.navigate(AUTH_ROUTE)
                })
    }
}


@Composable
@Preview(showBackground = true)
private fun Preview() {
    HomeScreen(navHostController = rememberNavController())
}