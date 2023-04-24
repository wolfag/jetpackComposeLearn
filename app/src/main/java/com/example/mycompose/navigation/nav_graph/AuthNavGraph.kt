package com.example.mycompose.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.mycompose.screens.LoginScreen
import com.example.mycompose.screens.SignUpScreen

fun NavGraphBuilder.authNavGraph(navHostController: NavHostController) {
    navigation(
        startDestination = Screen.Login.route,
        route = AUTH_ROUTE
    ) {
        composable(
            route = Screen.SignUp.route
        ) {
            SignUpScreen(navHostController = navHostController)
        }

        composable(
            route = Screen.Login.route
        ) {
            LoginScreen(navHostController = navHostController)
        }
    }
}