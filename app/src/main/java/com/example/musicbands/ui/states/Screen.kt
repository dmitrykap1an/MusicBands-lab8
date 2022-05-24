package com.example.musicbands.ui.states

sealed class Screen(val route: String) {
    object Greeting: Screen(route = "greeting")
    object Authentication: Screen(route = "auth")
    object Home: Screen(route = "home_screen")
    object Detail: Screen(route = "detail_screen")
    object Add: Screen(route = "add")
}