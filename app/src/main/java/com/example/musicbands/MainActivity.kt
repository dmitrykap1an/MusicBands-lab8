package com.example.musicbands


import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.musicbands.ui.states.Languages
import com.example.musicbands.ui.theme.AppTheme
import com.example.musicbands.ui.states.NavGraph
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var navController: NavHostController
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme{
                navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    navController = rememberNavController()
                    NavGraph(navController = navController)
                }
//            }
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(16.dp)
//            ){
//                Text(text = stringResource(id = R.string.hello_world))
//                Spacer(modifier = Modifier.height(16.dp))
//                Text(text = stringResource(id = R.string.kotlin))
//                val local = Locale("ru", "RU")
//                var bundle: ResourceBundle = ResourceBundle.getBundle("Messages", Languages.Spanish.locale)
//                Text(text =  bundle.getString("message"))
//

            }
        }
    }
}
