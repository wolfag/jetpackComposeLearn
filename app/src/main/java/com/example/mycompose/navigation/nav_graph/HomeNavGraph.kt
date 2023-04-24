package com.example.mycompose.navigation

import android.util.Log
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.mycompose.screens.*

fun NavGraphBuilder.homeNavGraph(navHostController: NavHostController) {
    navigation(
        startDestination = Screen.Home.route,
        route = HOME_ROUTE
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navHostController)
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument(DETAIL_ARG_KEY) {
                type = NavType.IntType
            })
        ) {
            DetailScreen(navHostController)
            Log.d("taitest", it.arguments?.getInt(DETAIL_ARG_KEY).toString())
        }
    }
}