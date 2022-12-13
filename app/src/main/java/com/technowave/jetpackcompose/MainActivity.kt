package com.technowave.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.technowave.jetpackcompose.ui.theme.JetPackComposeTheme
import com.technowave.jetpackcompose.ui.theme.LoginBackgroundColor
import com.technowave.jetpackcompose.views.HomeScreen
import com.technowave.jetpackcompose.views.LoginView


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyNavigation()
                }
            }
        }
    }
}

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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackComposeTheme {
        //LoginView()
    }
}
