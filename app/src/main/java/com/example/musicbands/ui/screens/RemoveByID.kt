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
import com.example.musicbands.client.data.MusicBand
import com.example.musicbands.client.serialize.CommandSerialize
import com.example.musicbands.ui.states.Data
import com.example.musicbands.ui.states.Load
import com.example.musicbands.ui.states.Screen
import com.example.musicbands.ui.theme.DarkTextColor
import java.lang.NumberFormatException

private var info = ""
@Composable
fun RemoveBYID(navController: NavController) {

    var id by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier.padding(vertical = 10.dp, horizontal = 140.dp),
    ) {
        Text(
            text = "remove by id",
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
                value = id,
                onValueChange = {
                    id = it
                },
                textStyle = TextStyle(Color.Gray),
                singleLine = true,
                placeholder = { Text(text = "id") },
            )
        }
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 300.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ){
        Text(text = info,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp),
            color = com.example.musicbands.ui.theme.error,
            fontSize = 11.sp
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 100.dp, vertical = 10.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(onClick = {
            onClick(id, navController = navController)
        }) {
            Text(
                text = "Выполнить",
                Modifier.padding(vertical = 10.dp),
                color = DarkTextColor
            )
        }
    }
}

private fun onClick(id: String, navController: NavController){

    try {
        val newId = id.toInt()
        val listOfDelete = mutableListOf<MusicBand>()
        Data.allItems.forEach{
            if(it.id == newId){
                listOfDelete.add(it)
            }
        }
        listOfDelete.forEach{
            Data.allItems.remove(it)
        }
        val commandSerialize = CommandSerialize("remove_by_id", id)
        val message = Load.requests!!.sendCommands(commandSerialize).getMessage()
        info = ""
        setMessage(message)
        navController.navigate(Screen.Home.route)
    }
    catch (e: NumberFormatException){
        info = "Строка должна быть представлена числом"
        navController.navigate(Screen.RemoveByID.route)
    }


}

@Composable
@Preview(showBackground = true)
fun RemoveByIDPreview() {
    RemoveBYID(navController = rememberNavController())
}