package com.example.musicbands.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.example.musicbands.ui.states.LoadingAnimation
import com.example.musicbands.ui.states.Screen
import com.example.musicbands.ui.theme.DarkTextColor
import com.example.musicbands.ui.theme.WhiteBackgroundColor
import kotlinx.coroutines.delay

@Composable
fun FirstGreeting(navController: NavController){

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
            .padding(vertical = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        LoadingAnimation()
    }





    LaunchedEffect(key1 = true, block = {
        delay(3000L)
        navController.navigate(Screen.Greeting.route)
    })

}


@Composable
@Preview(showBackground = true)
fun FirstGreetingPreview(){
    FirstGreeting(navController = rememberNavController())
}