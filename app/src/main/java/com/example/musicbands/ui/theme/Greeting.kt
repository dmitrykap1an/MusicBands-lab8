package com.example.musicbands.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun Greeting(id : Long = 0, navController : NavController) {
    Text(
        text = "MusicBands",
        style = TextStyle(fontFamily = FontFamily.Cursive),
        fontSize = 43.sp,
        color = DarkTextColor,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.W200,
        modifier = Modifier
            .background(WhiteBackgroundColor) //background color
            .fillMaxSize()
            .padding(horizontal = 100.dp, vertical = 350.dp)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 100.dp, vertical = 40.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(onClick = {
            navController.navigate(route = Screen.Authentication.route)
        }) {
            Text(
                text = "Регистрация",
                Modifier.padding(horizontal = 30.dp, vertical = 10.dp),
                color = DarkTextColor
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 100.dp, vertical = 100.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(onClick = {
            navController.navigate(Screen.Authentication.route)
        }) {
            Text(
                text = "Войти",
                Modifier.padding(horizontal = 60.dp, vertical = 10.dp),
                color = DarkTextColor
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun GreetingPreview(){
    Greeting(navController = rememberNavController())
}