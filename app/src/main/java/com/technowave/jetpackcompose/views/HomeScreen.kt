package com.technowave.jetpackcompose.views

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(username: String?, password: String?) {
    Text(text = "Welcome $username $password")
}