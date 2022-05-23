package com.example.musicbands.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lab8.client.managers.TypeOfAuth

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Greeting.route){
         composable(
             route = Screen.Home.route
         ) {
             HomeScreen(navController = navController)
         }
         composable(
             route = Screen.Detail.route
         ) {
              DetailScreen(Load.load)
         }
        composable(
            route = Screen.Greeting.route
        ){
            Greeting(Load.load, navController)
        }
        composable(
            route = Screen.Authentication.route
        ){
            Authentication(id = Load.load, navController = navController)
        }
    }
}