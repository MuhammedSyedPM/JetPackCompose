package com.technowave.jetpackcompose.navigation

sealed class MyRoute(val route: String) {
    object Login : MyRoute(route = "login")
    object Home : MyRoute(route = "home")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
