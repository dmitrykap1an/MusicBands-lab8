package com.example.musicbands.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musicbands.ui.states.Languages
import com.example.musicbands.ui.states.Load
import com.example.musicbands.ui.states.Screen
import com.example.musicbands.ui.theme.DarkTextColor
import com.example.musicbands.ui.theme.Purple
import com.example.musicbands.ui.theme.WhiteBackgroundColor
import com.example.musicbands.ui.theme.WhiteTextColor


@Composable
fun LanguageScreen(
    navController: NavController,
) {

    Text(
        text = "Смена языка",
        fontSize = 20.sp,
        color = DarkTextColor,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(WhiteBackgroundColor) //background color
            .fillMaxSize()
            .padding(vertical = 15.dp)
    )
    LazyColumn(
        modifier = Modifier
            .background(WhiteBackgroundColor)
            .height(400.dp)
            .padding(vertical = 70.dp)
    ){
        item {
            Button(
                onClick = {
                    Load.currentLanguage = Languages.Russian.nameOfLanguage
                    navController.navigate(Screen.Profile.route)

                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Purple,
                    contentColor = WhiteTextColor
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .height(30.dp)
                    .clip(RoundedCornerShape(10.dp)),
            ) {
                Text(
                    text = Languages.Russian.nameOfLanguage,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxSize(),
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Visible
                )
            }
        }

        item {
            Button(
                onClick = {
                    Load.currentLanguage = Languages.Polish.nameOfLanguage
                    navController.navigate(Screen.Profile.route)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Purple,
                    contentColor = WhiteTextColor
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .height(30.dp)
                    .clip(RoundedCornerShape(10.dp)),
            ) {
                Text(
                    text = Languages.Polish.nameOfLanguage,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxSize(),
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Visible
                )
            }
        }

        item {
            Button(
                onClick = {
                    Load.currentLanguage = Languages.English.nameOfLanguage
                    navController.navigate(Screen.Profile.route)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Purple,
                    contentColor = WhiteTextColor
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .height(30.dp)
                    .clip(RoundedCornerShape(10.dp)),
            ) {
                Text(
                    text = Languages.English.nameOfLanguage,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxSize(),
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Visible
                )
            }
        }
        item {
            Button(
                onClick = {
                    Load.currentLanguage = Languages.Spanish.nameOfLanguage
                    navController.navigate(Screen.Profile.route)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Purple,
                    contentColor = WhiteTextColor
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .height(30.dp)
                    .clip(RoundedCornerShape(10.dp)),
            ) {
                Text(
                    text = Languages.Spanish.nameOfLanguage,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxSize(),
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Visible
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun LanguageScreenPreview(){
    LanguageScreen(navController = rememberNavController())
}
