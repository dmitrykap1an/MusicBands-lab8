package com.example.musicbands.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.musicbands.ui.states.Screen
import com.example.musicbands.ui.theme.*


@Composable
fun HomeScreen(navController: NavHostController ){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteBackgroundColor)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Purple),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
            ) {
                IconButton(
                    onClick = { navController.navigate(Screen.Info.route) }
                ) {
                    Icon(
                        imageVector = Screen.Info.icon,
                        contentDescription = Screen.Info.route
                    )
                }
            }

            Column(

            ) {
                Text(
                    text = "HomePage",
                    style = TextStyle(fontFamily = FontFamily.Cursive),
                    color = WhiteTextColor,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Column(
            ) {
                IconButton(
                    modifier = Modifier,
                    onClick = { navController.navigate(Screen.Profile.route) }
                ) {
                    Icon(
                        imageVector = Screen.Profile.icon,
                        contentDescription = Screen.Profile.route
                    )
                }
            }

        }

        Column(Modifier.background(WhiteBackgroundColor)) {
            MainContent(navController = navController)
        }
    }

}



@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}