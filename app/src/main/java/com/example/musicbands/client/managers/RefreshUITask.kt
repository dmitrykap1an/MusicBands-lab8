package com.example.musicbands.client.managers

import android.os.AsyncTask
import androidx.navigation.NavController

class RefreshUITask(private val navController: NavController, private val route : String) : AsyncTask<NavController,Int , Boolean>() {
    override fun doInBackground(vararg p0: NavController?): Boolean {
        navController.navigate(route)
        return true
    }
}