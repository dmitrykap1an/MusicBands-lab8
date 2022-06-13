package com.example.musicbands.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import com.example.musicbands.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lab8.client.data.Location
import com.example.musicbands.client.data.Coordinates
import com.example.musicbands.client.data.MusicBand
import com.example.musicbands.client.data.Person
import com.example.musicbands.client.managers.CheckData
import com.example.musicbands.client.serialize.CommandSerialize
import com.example.musicbands.ui.states.Data
import com.example.musicbands.ui.states.Load
import com.example.musicbands.ui.states.Screen
import com.example.musicbands.ui.theme.DarkTextColor
import java.util.concurrent.Executors

private var message: String = ""
@Composable
fun Add(id: Long = 0, navController: NavController) {

    var name by rememberSaveable { mutableStateOf("") }
    var coordinateX by rememberSaveable { mutableStateOf("") }
    var coordinateY by rememberSaveable { mutableStateOf("") }
    var numberOfParticipants by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    var genre by rememberSaveable { mutableStateOf("") }
    var frontManName by rememberSaveable { mutableStateOf("") }
    var frontManHeight by rememberSaveable { mutableStateOf("") }
    var frontManLocationX by rememberSaveable { mutableStateOf("")}
    var frontManLocationY by rememberSaveable { mutableStateOf("") }
    var frontManLocationZ by rememberSaveable { mutableStateOf("") }

    Column(
       modifier = Modifier.padding(vertical = 10.dp, horizontal = 120.dp),
    ) {
        Text(
            text = stringResource(id = R.string.add),
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
                value = name,
                onValueChange = {
                    name = it
                },
                textStyle = TextStyle(Color.Gray),
                singleLine = true,
                placeholder = { Text(text = "name") },
            )
        }
        item {
            OutlinedTextField(
                value = coordinateX,
                onValueChange = {
                    coordinateX = it
                },
                textStyle = TextStyle(Color.Gray),
                singleLine = true,
                placeholder = { Text(text = "Coordinate X") },
            )
        }
        item {
            OutlinedTextField(
                value = coordinateY,
                onValueChange = {
                    coordinateY = it
                },
                textStyle = TextStyle(Color.Gray),
                singleLine = true,
                placeholder = { Text(text = "Coordinate Y") },
            )
        }
        item {
            OutlinedTextField(
                value = numberOfParticipants,
                onValueChange = {
                    numberOfParticipants = it
                },
                textStyle = TextStyle(Color.Gray),
                singleLine = true,
                placeholder = { Text(text = "Number of participants") },
            )
        }
        item {
            OutlinedTextField(
                value = description,
                onValueChange = {
                    description = it
                },
                textStyle = TextStyle(Color.Gray),
                singleLine = true,
                placeholder = { Text(text = "Description") },
            )
        }
        item {
            OutlinedTextField(
                value = genre,
                onValueChange = {
                    genre = it
                },
                textStyle = TextStyle(Color.Gray),
                singleLine = true,
                placeholder = { Text(text = "Genre") },
            )
        }

        item {
            OutlinedTextField(
                value = frontManName,
                onValueChange = {
                    frontManName= it
                },
                textStyle = TextStyle(Color.Gray),
                singleLine = true,
                placeholder = { Text(text = "Name of FrontMan") },
            )
        }
        item {
            OutlinedTextField(
                value = frontManHeight,
                onValueChange = {
                    frontManHeight = it
                },
                textStyle = TextStyle(Color.Gray),
                singleLine = true,
                placeholder = { Text(text = "Height location of FrontMan") },
            )
        }

        item {
            OutlinedTextField(
                value = frontManLocationX,
                onValueChange = {
                    frontManLocationX = it
                },
                textStyle = TextStyle(Color.Gray),
                singleLine = true,
                placeholder = { Text(text = "X location of FrontMan") },
            )
        }
        item {
            OutlinedTextField(
                value = frontManLocationY,
                onValueChange = {
                    frontManLocationY = it
                },
                textStyle = TextStyle(Color.Gray),
                singleLine = true,
                placeholder = { Text(text = "Y location of FrontMan") },
            )
        }
        item {
            OutlinedTextField(
                value = frontManLocationZ,
                onValueChange = {
                    frontManLocationZ = it
                },
                textStyle = TextStyle(Color.Gray),
                singleLine = true,
                placeholder = { Text(text = "Z location of FrontMan") },
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
            onCLick(navController, name, coordinateX, coordinateY,
                numberOfParticipants, description, genre,
                frontManName, frontManHeight, frontManLocationX,
                frontManLocationY, frontManLocationZ)
        }) {
            Text(
                text = stringResource(id = R.string.perform),
                Modifier.padding(vertical = 10.dp),
                color = DarkTextColor
            )
        }
    }
}

private fun onCLick(navController: NavController, name: String, coordinateX: String,coordinateY: String,
                    numberOfParticipants: String, description: String, genre: String,
                    frontManName: String, frontManHeight: String, frontManLocationX: String,
                    frontManLocationY: String, frontManLocationZ: String){
    val checkData = CheckData()
    val newCoordinateX = checkData.checkX(coordinateX)
    val newCoordinateY = checkData.checkY(coordinateY)
    val newNumberOfParticipants = checkData.checkNumberOfParticipants(numberOfParticipants)
    val newGenre = checkData.checkMusicGenre(genre)
    val newFrontManHeight = checkData.checkHeight(frontManHeight)
    val newFrontManLocationX = checkData.checkX2(frontManLocationX)
    val newFrontManLocationY = checkData.checkY2(frontManLocationY)
    val newFrontManLocationZ = checkData.checkZ(frontManLocationZ)
    val listOfResults = listOf(
        newCoordinateX, newCoordinateY, newNumberOfParticipants, newGenre,
        newFrontManHeight, newFrontManLocationX, newFrontManLocationY,
        newFrontManLocationZ

    )
    var cnt = 0;
    listOfResults.forEach{
        if(it.second != "OK"){
            cnt++
        }
    }
    if(cnt == 0){
        val coordinates = Coordinates(newCoordinateX.first, newCoordinateY.first)
        val location = Location(newFrontManLocationX.first, newFrontManLocationY.first, newFrontManLocationZ.first)
        val frontMan = Person(frontManName, newFrontManHeight.first, location)
        val musicBand = MusicBand(
            name, coordinates, newNumberOfParticipants.first, description,
            newGenre.first!!, frontMan
        )
        val commandSerialize = CommandSerialize("add", musicBand = musicBand)
        Load.requests!!.sendCommands(commandSerialize)














        if (message == ""){
            setMessage("Команда Add выполнена")
            Data.allItems.add(musicBand)
            Data.allItems.sortBy { it.name }
        }
        else setMessage(message)
        navController.navigate(Screen.Home.route)
    }
    else{
        val stringBuilder = StringBuilder()
        listOfResults.forEach {
            stringBuilder.append(it.second)
        }
        message = stringBuilder.toString()
        navController.navigate(Screen.Add.route)
    }
}



@Composable
@Preview(showBackground = true)
fun AddPreview(){
    Add(navController =  rememberNavController())
}