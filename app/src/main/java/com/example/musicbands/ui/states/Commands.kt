package com.example.musicbands.ui.states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.musicbands.ui.theme.DarkTextColor
import com.example.musicbands.ui.theme.onClick

@Composable
fun Add(id: Long, navController: NavController){

//    val nameOfGroup: String
//    val coodX: Long
//    val coordY: Double
//
//    Column(modifier = Modifier
//        .fillMaxSize()
//        .padding(80.dp),
//
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        OutlinedTextField(
//            value = nameOfGroup,
//            onValueChange = {
//                userName = it
//            },
//            textStyle = TextStyle(DarkTextColor),
//            singleLine = true,
//            placeholder = { Text(text = "Username") },
//            label = { Text(text = "Username") },
//        )
//        OutlinedTextField(
//            value = password,
//            onValueChange = {
//                password = it
//            },
//            textStyle = TextStyle(DarkTextColor),
//            visualTransformation = PasswordVisualTransformation(),
//            singleLine = true,
//            placeholder = { Text(text = "Password") },
//            label = { Text(text = "Password") },
//        )
//    }
//    Column(modifier = Modifier
//        .fillMaxSize()
//        .padding(80.dp),
//
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Bottom
//    ){
//        Button(onClick = {
//            onClick(userName, password, navController)
//
//        }){
//            Text(text = "Войти", Modifier.padding(horizontal = 30.dp, vertical = 10.dp), color = DarkTextColor)
//        }

}