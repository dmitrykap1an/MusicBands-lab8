package com.example.musicbands.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import com.example.musicbands.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musicbands.ui.states.Load
import com.example.musicbands.ui.states.Screen
import com.example.musicbands.ui.theme.*

@Composable
fun Account(name : String, password: String, navController: NavController){

        Text(
            text = stringResource(id = R.string.profile),
            fontSize = 20.sp,
            color = DarkTextColor,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(WhiteBackgroundColor)
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
                    modifier = Modifier.size(height = 90.dp, width = 90.dp),
                    contentScale = ContentScale.Crop,
                    imageVector = Icons.Filled.AccountBox,
                    contentDescription = "User's Logo",
                    colorFilter = ColorFilter.tint(Color.Gray)
                )
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 20.dp),
                    text = name,
                    fontWeight = FontWeight.W700,
                    fontSize = 16.sp,
                    color = Purple,
                )

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = stringResource(id = R.string.language),
                color = Color.Black
            )
            TextButton(
                onClick = { navController.navigate(Screen.LanguageScreen.route) },
                modifier = Modifier
            ) {
               Text(
                    text = Load.currentLanguage,
                    color = Color.Gray
                )
            }

        }
        TextButton(
            onClick = {
                navController.navigate(route = Screen.Greeting.route)
                Load.typeOfAuth = null
                      },
            colors = ButtonDefaults.buttonColors(backgroundColor = WhiteBackgroundColor),
            modifier = Modifier.padding(horizontal = 170.dp)
        ){
            Text(
                text = stringResource(id = R.string.exit),
                color = error
            )
        }

    }

}


@Composable
@Preview(showBackground = true)
fun AccountPreview(){
    Account(navController = rememberNavController(), name = "anonymous", password = "nigga")
}
