package com.example.mycompose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun DetailScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Detail screen",
            fontSize = MaterialTheme.typography.h3.fontSize,
            modifier = Modifier.clickable {
                navController.popBackStack()
            }
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun Preview() {
    DetailScreen(navController = rememberNavController())
}