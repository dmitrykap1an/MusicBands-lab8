package com.example.musicbands.ui.states

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.musicbands.ui.screens.*
import com.example.musicbands.ui.theme.DetailScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.FirstGreeting.route){
        composable(
            route = Screen.FirstGreeting.route
        )
        {
            FirstGreeting(navController = navController)
        }
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
        composable(
            route = Screen.Add.route
        ){
                Add(id = Load.load, navController = navController)
        }
        composable(
            route = Screen.Profile.route
        ){
            Account(name = Load.owner, password = Load.password, navController = navController)
        }
        composable(
            route = Screen.Info.route
        ){
            Info(navController = navController)
        }
        composable(
            route = Screen.LanguageScreen.route
        ){
            LanguageScreen(navController = navController)
        }
        composable(
            route = Screen.UpdateId.route
        ){
            UpdateId(navController = navController)
        }
        composable(
            route = Screen.RemoveByID.route
        ){
            RemoveBYID(navController = navController)
        }
        composable(
            route = Screen.RemoveGreater.route
        ){
            RemoveGreater(navController = navController)
        }
        composable(
            route = Screen.RemoveByDescription.route
        ){
            RemoveByDescription(navController = navController)
        }
        composable(
            route = Screen.CountLessThan.route
        ){
            CountLessThan(navController = navController)
        }
    }
}