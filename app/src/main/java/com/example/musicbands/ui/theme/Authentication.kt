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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lab8.client.managers.TypeOfAuth
import com.example.musicbands.client.requestsToServer.Requests
import com.example.musicbands.server.src.main.kotlin.server.serverWork.UserChecker
import java.util.concurrent.Executors


@Composable
fun Authentication(navController: NavController, id : Long = 0, typeOfAuth: TypeOfAuth = TypeOfAuth.Registered, message : String = ""){

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
    println(userName)
    println(password)

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
//            navController.navigate(Screen.Home.route)
            val pool = Executors.newFixedThreadPool(2)
            val future = pool.submit(Requests(TypeOfAuth.Registered, "newton", "newton"))

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
            color = error
        )
    }

}

fun onClick(){
    val executors = Executors.newFixedThreadPool(4)
    val future = executors.submit(Requests(TypeOfAuth.Registered, "newton", "newton"))
    val result = future.get()
    println(result)

}


@Composable
@Preview(showBackground = true)
fun AuthenticationPreview(){
    Authentication(
        navController = rememberNavController()
    )
}