package com.example.musicbands.ui.screens

import android.app.Activity
import android.content.Context
import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musicbands.R
import com.example.musicbands.client.managers.TypeOfAuth
import com.example.musicbands.client.requests.Requests
import com.example.musicbands.client.serialize.AnswerSerialize
import com.example.musicbands.client.serialize.CommandSerialize
import com.example.musicbands.ui.states.Data
import com.example.musicbands.ui.states.Load
import com.example.musicbands.ui.states.Screen
import com.example.musicbands.ui.theme.DarkTextColor
import com.example.musicbands.ui.theme.WhiteBackgroundColor
import java.lang.NullPointerException
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

private var message = ""

@Composable
fun Registration(navController: NavController) {
    Text(
        text = stringResource(id = R.string.registration),
        fontSize=30.sp,
        color= DarkTextColor,
        textAlign = TextAlign.Center,
        fontWeight= FontWeight.W700,
        modifier = Modifier
            .background(WhiteBackgroundColor) //background color
            .fillMaxSize()
            .padding(40.dp),
    )
    var userName by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(80.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = userName,
            onValueChange = {
                userName = it
            },
            textStyle = TextStyle(DarkTextColor),
            singleLine = true,
            placeholder = { Text(text = "Username") },
            label = { Text(text = "Username") },
        )
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            textStyle = TextStyle(DarkTextColor),
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            placeholder = { Text(text = "Password") },
            label = { Text(text = "Password") },
        )
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(80.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ){
        Button(onClick = {
            val executor = Executors.newSingleThreadExecutor()
            executor.submit{
                onClick(userName, password, navController)
            }


        }){
            Text(text = stringResource(R.string.login), Modifier
                .padding(horizontal = 30.dp, vertical = 10.dp),
                color = DarkTextColor
            )
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 300.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ){
        Text(text = message,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp),
            color = com.example.musicbands.ui.theme.error,
            fontSize = 11.sp
        )
    }


}
private fun onClick(userName: String, password: String, navController: NavController){

    try {
        val requests = Requests(userName, password, navController)
        Load.requests = requests
        val openClientAnswer = requests.openClient()
        if (openClientAnswer) {
            val registrationAnswer = requests.registration(TypeOfAuth.NotRegistered)
            if (registrationAnswer.first) {
                message = ""
                val command = CommandSerialize("load")
                Data.allItems.addAll(requests.getCollection(command))
                Load.owner = userName
                Load.password = password
                val activity = Activity()
                activity.runOnUiThread {  navController.navigate(Screen.Home.route)}
                navController.navigate(Screen.Home.route)
            } else {
                message = registrationAnswer.second
                navController.navigate(Screen.Authentication.route)
            }

        } else {
            navController.navigate(Screen.Authentication.route)
            message = "Ошибка подключения к сети"
        }
    }
    catch (e: NullPointerException){
        message = "Ошибка работы программы"
    }

}

@Composable
@Preview(showBackground = true)
fun RegistrationPreview() {
    Registration(navController = rememberNavController())
}
