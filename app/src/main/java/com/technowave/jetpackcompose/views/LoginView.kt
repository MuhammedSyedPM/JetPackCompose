package com.technowave.jetpackcompose.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.technowave.jetpackcompose.R
import com.technowave.jetpackcompose.ui.theme.JetPackComposeTheme
import com.technowave.jetpackcompose.ui.theme.LoginBackgroundColor


@Composable
fun LoginView(navController: NavController) {
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var showPassword by remember {
        mutableStateOf(false)
    }
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = LoginBackgroundColor),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login",
                color = Color.Black,
                modifier = Modifier.padding(20.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp
            )
            Image(
                painter = painterResource(id = R.drawable.bfa_logo),
                contentDescription = "",
                modifier = Modifier
                    //.aspectRatio(1f, matchHeightConstraintsFirst = true)
                    .width(100.dp)
                    .height(100.dp)
                    .border(width = 1.dp, color = Color.Black, shape = CircleShape)
                    .padding(1.dp)
                    .clip(CircleShape)
            )

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(text = "Username") },
                placeholder = { Text(text = "Username") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 30.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password") },
                placeholder = { Text(text = "Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 10.dp),
                visualTransformation = PasswordVisualTransformation()
            )
            Text(
                text = "Forgot password?",
                color = Color.Blue,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 20.dp)
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 10.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(30.dp),
                elevation = 5.dp
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.Magenta)
                        .clickable {
                                   navController.navigate("home/$username/$password")
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Login", color = Color.White)
                }
            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)) {
                Text(
                    text = "Contact us",
                    color = Color.Red,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 20.dp),
                    fontSize = 20.sp
                )
                Text(
                    text = "Signup",
                    color = Color.Red,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 20.dp),
                            fontSize = 20.sp
                )
            }
        }
        Text(text = "V 1.0", color = Color.Green, modifier = Modifier.align(Alignment.BottomCenter))
    }

}

@Preview(showBackground = true)
@Composable
fun LoginViewPreview() {
    JetPackComposeTheme() {
       // LoginView()
    }
}