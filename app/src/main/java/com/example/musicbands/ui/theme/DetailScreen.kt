package com.example.musicbands.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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


@Composable
fun DetailScreen(id: Long){
    var data: LabWork? = Data.allItems.find { it.id == id }
    if (data == null)
        data = Data.allItems[0]
    var command by rememberSaveable { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF6200EE))
    ) {
        Text(
            "id = ${data.id}\n" +
                    "name = ${data.name}\n" +
                    "coordinates = ${data.coordinates}\n" +
                    "numberOfParticipants = ${data.numberOfParticipants}\n" +
                    "description = ${data.description}\n" +
                    "genre = ${data.genre}\n" +
                    "frontMan = ${data.frontMan}\n" +
                    "creationDate = ${data.creationDate}\n" +
                    "owner = ${data.owner}",
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            )
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ){
            OutlinedTextField(
                value = command,
                modifier = Modifier
                    .fillMaxWidth(),
                onValueChange = {
                    command = it
                },
                textStyle = TextStyle(Color.White),
                singleLine = true,
                placeholder = {Text(text = "Введите свою команду")},
            )
            Button(onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)){
                Text(text = "Отправить", Modifier.padding(horizontal = 20.dp, vertical = 10.dp))
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DetailScreenPreview() {
    DetailScreen(Load.load)
}