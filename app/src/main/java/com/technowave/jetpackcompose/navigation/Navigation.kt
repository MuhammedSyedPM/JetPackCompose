package com.technowave.jetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.technowave.jetpackcompose.views.HomeScreen
import com.technowave.jetpackcompose.views.LoginView

@Composable
fun MyNavigation() {
    val navController  = rememberNavController()
    NavHost(navController = navController, startDestination = "login"){
        composable(route = "login"){
            LoginView(navController)
        }
        composable(
            route = "home/{username}/{password}",
            arguments = listOf(
                navArgument("username"){
                    type = NavType.StringType
                    defaultValue = "noName"
                    nullable = true
                },
                navArgument("password"){
                    type = NavType.StringType
                    defaultValue = "noName"
                    nullable = true
                }
            )
        ){
            HomeScreen(
                username = it.arguments?.getString("username"),
                password = it.arguments?.getString("password")
            )
        }
    }

}