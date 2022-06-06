package com.example.musicbands.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lab8.client.managers.TypeOfAuth
import com.example.musicbands.ui.states.Load
import com.example.musicbands.ui.states.Screen
import com.example.musicbands.ui.theme.*

@Composable
fun Account(name : String, password: String, navController: NavController){

        Text(
            text = "Профиль",
            fontSize = 20.sp,
            color = DarkTextColor,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(WhiteBackgroundColor) //background color
                .fillMaxSize()
                .padding(vertical = 15.dp)
        )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(50.dp),
    ) {
        Row (
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 100.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ){
                Image(
                    modifier = Modifier.size(height = 20.dp, width = 20.dp),
                    contentScale = ContentScale.FillHeight,
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "User's Logo",
                    colorFilter = ColorFilter.tint(Color.Gray)
                )
                Text(
                    text = name,
                    fontSize = 15.sp,
                    color = Purple,
                )

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Язык",
                color = Color.Black
            )
            Text(
                text = "Русский",
                color = Color.Gray
            )
        }

        Column(
            horizontalAlignment = Alignment.Start,
        ) {
            Button(
                onClick = { navController.navigate(route = Screen.Greeting.route) },
                colors = ButtonDefaults.buttonColors(backgroundColor = WhiteBackgroundColor),
                modifier = Modifier.padding(horizontal = 175.dp)
            ){
                Text(
                    text = "Выйти",
                    color = error
                )
            }
        }


    }
}


@Composable
@Preview(showBackground = true)
fun AccountPreview(){
    Account(navController = rememberNavController(), name = "anonymous", password = "nigga")
}
