package com.example.musicbands.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musicbands.ui.theme.DarkTextColor
import com.example.musicbands.ui.theme.WhiteBackgroundColor

@Composable
fun Info(navController: NavController) {
    Text(
        text = "Powered By Dmitry Kaplan",
        style = TextStyle(fontFamily = FontFamily.Cursive),
        fontSize = 30.sp,
        color = DarkTextColor,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(WhiteBackgroundColor) //background color
            .fillMaxSize()
            .padding(horizontal = 100.dp, vertical = 350.dp)
    )
}

@Composable
@Preview(showBackground = true)
fun InfoPreview() {
    Info(rememberNavController())
}

