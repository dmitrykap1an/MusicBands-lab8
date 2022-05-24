package com.example.musicbands.ui.theme

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lab8.client.managers.TypeOfAuth
import com.example.musicbands.client.requests.Requests
import com.example.musicbands.client.serialize.CommandSerialize
import com.example.musicbands.ui.states.Screen

private var message: String = ""

@Composable
fun Authentication(navController: NavController, id : Long = 0, typeOfAuth: TypeOfAuth = Load.typeOfAuth!!){

    Text("Авторизация",
        fontSize=30.sp,
        color= DarkTextColor,
        textAlign = TextAlign.Center,
        fontWeight= FontWeight.W700,
        modifier = Modifier
            .background(WhiteBackgroundColor) //background color
            .fillMaxSize()
            .padding(10.dp))
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
            onClick(userName, password, navController)

        }){
            Text(text = "Войти", Modifier.padding(horizontal = 30.dp, vertical = 10.dp), color = DarkTextColor)
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
            color = error,
            fontSize = 11.sp
        )
    }

}

fun onClick(userName: String, password: String, navController: NavController){

    val requests = Requests(TypeOfAuth.Registered, userName, password)
    Load.requests = requests
    val openClientAnswer = requests.openClient()
    if(openClientAnswer){
        val registrationAnswer = requests.registration()
        if (registrationAnswer.first){
            message = ""
            val command = CommandSerialize("load")
            Data.allItems.addAll(requests.getCollection(command))
            navController.navigate(Screen.Home.route)
        }
        else{
            message = registrationAnswer.second
            navController.navigate(Screen.Authentication.route)
        }

    }
    else{
        navController.navigate(Screen.Authentication.route)
        message = "Ошибка подключения к сети"
    }


}


@Composable
@Preview(showBackground = true)
fun AuthenticationPreview(){
    Authentication(
        navController = rememberNavController()
    )
}