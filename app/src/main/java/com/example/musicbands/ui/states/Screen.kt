package com.example.musicbands.ui.states

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val title: String = "",
    val icon: ImageVector = Icons.Default.Refresh
) {
    object FirstGreeting: Screen(route = "first")
    object Greeting: Screen(route = "greeting")
    object Authentication: Screen(route = "auth")
    object Home: Screen(route = "home_screen")
    object Detail: Screen(route = "detail_screen")
    object Add: Screen(route = "add")
    object UpdateId: Screen(route = "update_id")
    object RemoveByID: Screen(route = "remove_by_id")
    object RemoveGreater: Screen(route = "remove_greater")
    object RemoveByDescription: Screen(route = "remove_all_by_description")
    object CountLessThan: Screen(route = "count_less_than_number_of_participants")
    object Registration: Screen(route = "registration")
    object Profile: Screen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.AccountCircle,
    )

    object Info: Screen(
        route = "info",
        title = "Info",
        icon = Icons.Default.Info
    )
    object LanguageScreen: Screen(
        route = "languageScreen"
    )
}