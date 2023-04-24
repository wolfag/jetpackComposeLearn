package com.example.mycompose.navigation

const val DETAIL_ARG_KEY = "id"

const val AUTH_ROUTE = "auth"
const val ROOT_ROUTE = "root"
const val HOME_ROUTE = "home"

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Detail : Screen(route = "detail_screen/{$DETAIL_ARG_KEY}") {
        fun passId(id: Int): String {
            return this.route.replace(oldValue = "{$DETAIL_ARG_KEY}", newValue = id.toString())
        }
    }

    object Login : Screen(route = "login_screen")
    object SignUp : Screen(route = "signup_screen")
}
