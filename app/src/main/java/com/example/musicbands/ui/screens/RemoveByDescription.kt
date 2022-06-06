package com.example.musicbands.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musicbands.client.serialize.CommandSerialize
import com.example.musicbands.ui.states.Load
import com.example.musicbands.ui.states.Screen
import com.example.musicbands.ui.theme.DarkTextColor

@Composable
fun RemoveByDescription(navController: NavController) {
    var description by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier.padding(vertical = 10.dp, horizontal = 140.dp),
    ) {
        Text(
            text = "remove by description",
            fontSize = 20.sp,
            color = DarkTextColor
        )
    }

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 100.dp)
        .height(240.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            OutlinedTextField(
                value = description,
                onValueChange = {
                    description = it
                },
                textStyle = TextStyle(Color.Gray),
                singleLine = true,
                placeholder = { Text(text = "description") },
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 100.dp, vertical = 10.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(onClick = {
            onClick(navController = navController, description)
        }) {
            Text(
                text = "Выполнить",
                Modifier.padding(vertical = 10.dp),
                color = DarkTextColor
            )
        }
    }
}

private fun onClick(navController: NavController, description: String){
    val commandSerialize = CommandSerialize("remove_all_by_description", description)
    val message = Load.requests!!.sendCommands(commandSerialize).getMessage()
    setMessage(message)
    navController.navigate(Screen.Home.route)
}


@Composable
@Preview(showBackground = true)
fun RemoveByDescriptionPreview() {
    RemoveByDescription(navController = rememberNavController())
}