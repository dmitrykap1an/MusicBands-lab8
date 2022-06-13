package com.example.musicbands.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lab8.client.data.MusicGenre
import com.example.musicbands.client.data.MusicBand
import com.example.musicbands.ui.states.Data
import com.example.musicbands.ui.states.Load
import com.example.musicbands.ui.states.Screen
import com.example.musicbands.ui.theme.DarkTextColor
import com.example.musicbands.ui.theme.Purple
import com.example.musicbands.ui.theme.WhiteBackgroundColor
import com.example.musicbands.ui.theme.WhiteTextColor
import java.lang.NumberFormatException

private var message = ""
private var currentBox = ""

@Composable
fun DetailScreen(id: Long, navController: NavController){

    var data: MusicBand? = Data.allItems.find { it.id.toLong() == id }
    if (data == null)
        data = Data.allItems[0]
    var command by rememberSaveable { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteBackgroundColor)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(720.dp)
                .padding(10.dp)
        ){
            item{
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(WhiteBackgroundColor)
                        .padding(vertical = 2.5.dp),
                    border = BorderStroke(2.dp, Purple),
                    shape = RoundedCornerShape(10.dp),

                    ){
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Text(
                            text = "Band ID",
                            fontSize = 20.sp,
                            color = DarkTextColor,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(0.5f)
                                .padding(vertical = 34.dp)

                        )

                        Box(modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .background(Purple)) {
                            Text(
                                text = "${data.id}",
                                fontSize = 20.sp,
                                color = WhiteTextColor,
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Visible,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                                    .padding(vertical = 34.dp)

                            )

                        }
                    }


                }

            }

            item{
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(WhiteBackgroundColor)
                        .padding(vertical = 2.5.dp),
                    border = BorderStroke(2.dp, Purple),
                    shape = RoundedCornerShape(10.dp),
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Text(
                            text = "Band name",
                            fontSize = 20.sp,
                            color = DarkTextColor,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(0.5f)
                                .padding(vertical = 34.dp)

                        )

                        Box(modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .background(Purple)) {
                            Text(
                                text = data.name,
                                fontSize = 20.sp,
                                color = WhiteTextColor,
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Visible,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                                    .padding(vertical = 34.dp)

                            )
//                            Box(
//                                contentAlignment = Alignment.TopStart
//                            ) {
//                                IconButton(onClick = {
//                                    currentBox = "Band name"
//                                    expanded = true
//                                }) {
//                                    Icon(
//                                        imageVector = Icons.Default.Edit,
//                                        contentDescription = "Показать меню",
//                                        tint = WhiteTextColor,
//                                        modifier = Modifier
//                                            .size(18.dp),
//                                    )
//
//                                }
//                        }
                        }
                    }
                }
            }

            item{
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(WhiteBackgroundColor)
                        .padding(vertical = 2.5.dp),
                    border = BorderStroke(2.dp, Purple),
                    shape = RoundedCornerShape(10.dp),
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Text(
                            text = "Band x coordinates",
                            fontSize = 20.sp,
                            color = DarkTextColor,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(0.5f)
                                .padding(vertical = 18.dp)

                        )

                        Box(modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .background(Purple)) {
                            Text(
                                text = "${data.coordinates.x}",
                                fontSize = 20.sp,
                                color = WhiteTextColor,
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Visible,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                                    .padding(vertical = 34.dp)

                            )
                        }
//                        Box(
//                            contentAlignment = Alignment.TopStart
//                        ) {
//                            IconButton(onClick = {
//                                currentBox = "Band x coordinates"
//                                expanded = true
//                            }) {
//                                Icon(
//                                    imageVector = Icons.Default.Edit,
//                                    contentDescription = "Показать меню",
//                                    tint = WhiteTextColor,
//                                    modifier = Modifier
//                                        .size(18.dp),
//                                )
//
//                            }
//                        }


                    }
                }
            }

            item{
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(WhiteBackgroundColor)
                        .padding(vertical = 2.5.dp),
                    border = BorderStroke(2.dp, Purple),
                    shape = RoundedCornerShape(10.dp),
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Text(
                            text = "Band y coordinates",
                            fontSize = 20.sp,
                            color = DarkTextColor,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(0.5f)
                                .padding(vertical = 18.dp)

                        )

                        Box(modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .background(Purple)) {
                            Text(
                                text = "${data.coordinates.y}",
                                fontSize = 20.sp,
                                color = WhiteTextColor,
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Visible,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                                    .padding(vertical = 34.dp)

                            )

                        }
                    }
                }
            }

            item{
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(WhiteBackgroundColor)
                        .padding(vertical = 2.5.dp),
                    border = BorderStroke(2.dp, Purple),
                    shape = RoundedCornerShape(10.dp),
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Text(
                            text = "Number\nof\nparticipants",
                            fontSize = 20.sp,
                            color = DarkTextColor,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(0.5f)
                                .padding(vertical = 10.dp)

                        )

                        Box(modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .background(Purple)) {
                            Text(
                                text = "${data.numberOfParticipants}",
                                fontSize = 20.sp,
                                color = WhiteTextColor,
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Visible,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                                    .padding(vertical = 34.dp)

                            )
                        }
                    }
                }
            }

            item{
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(WhiteBackgroundColor)
                        .padding(vertical = 2.5.dp),
                    border = BorderStroke(2.dp, Purple),
                    shape = RoundedCornerShape(10.dp),
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Text(
                            text = "Band description",
                            fontSize = 20.sp,
                            color = DarkTextColor,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(0.5f)
                                .padding(vertical = 35.dp)

                        )

                        Box(modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .background(Purple)) {
                            Text(
                                text = data.description,
                                fontSize = 20.sp,
                                color = WhiteTextColor,
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Visible,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp)

                            )
                        }
                    }
                }
            }

            item{
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(WhiteBackgroundColor)
                        .padding(vertical = 2.5.dp),
                    border = BorderStroke(2.dp, Purple),
                    shape = RoundedCornerShape(10.dp),
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Text(
                            text = "Genre",
                            fontSize = 20.sp,
                            color = DarkTextColor,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(0.5f)
                                .padding(vertical = 35.dp)

                        )

                        Box(modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .background(Purple)) {
                            Text(
                                text = "${data.genre}",
                                fontSize = 20.sp,
                                color = WhiteTextColor,
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Visible,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                                    .padding(vertical = 34.dp)

                            )
                        }
                    }
                }
            }
            item{
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(WhiteBackgroundColor)
                        .padding(vertical = 2.5.dp),
                    border = BorderStroke(2.dp, Purple),
                    shape = RoundedCornerShape(10.dp),
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Text(
                            text = "Name of front man",
                            fontSize = 20.sp,
                            color = DarkTextColor,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(0.5f)
                                .padding(vertical = 10.dp)

                        )

                        Box(modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .background(Purple)) {
                            Text(
                                text = data.frontMan.name,
                                fontSize = 20.sp,
                                color = WhiteTextColor,
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Visible,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                                    .padding(vertical = 34.dp)

                            )
                        }
                    }
                }
            }
            item{
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(WhiteBackgroundColor)
                        .padding(vertical = 2.5.dp),
                    border = BorderStroke(2.dp, Purple),
                    shape = RoundedCornerShape(10.dp),
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Text(
                            text = "Height of front man",
                            fontSize = 20.sp,
                            color = DarkTextColor,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(0.5f)
                                .padding(vertical = 10.dp)

                        )

                        Box(modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .background(Purple)) {
                            Text(
                                text = "${data.frontMan.height}",
                                fontSize = 20.sp,
                                color = WhiteTextColor,
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Visible,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                                    .padding(vertical = 34.dp)

                            )
                        }
                    }
                }
            }

            item{
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(WhiteBackgroundColor)
                        .padding(vertical = 2.5.dp),
                    border = BorderStroke(2.dp, Purple),
                    shape = RoundedCornerShape(10.dp),
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Text(
                            text = "Front man location",
                            fontSize = 20.sp,
                            color = DarkTextColor,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(0.5f)
                                .padding(vertical = 18.dp)

                        )

                        Box(modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .background(Purple)) {
                            Text(
                                text = "x: ${data.frontMan.location.x}\n" +
                                        "y: ${data.frontMan.location.y}\n" +
                                        "z: ${data.frontMan.location.z}",
                                fontSize = 20.sp,
                                color = WhiteTextColor,
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                                    .padding(vertical = 0.dp)

                            )
                        }
                    }
                }
            }

            item{
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(WhiteBackgroundColor)
                        .padding(vertical = 2.5.dp),
                    border = BorderStroke(2.dp, Purple),
                    shape = RoundedCornerShape(10.dp),
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Text(
                            text = "Creation date",
                            fontSize = 20.sp,
                            color = DarkTextColor,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(0.5f)
                                .padding(vertical = 35.dp)

                        )

                        Box(modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .background(Purple)) {
                            Text(
                                text = "${data.creationDate}",
                                fontSize = 20.sp,
                                color = WhiteTextColor,
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                                    .padding(vertical = 15.dp)

                            )
                        }
                    }
                }
            }

            item{
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(WhiteBackgroundColor)
                        .padding(vertical = 2.5.dp),
                    border = BorderStroke(2.dp, Purple),
                    shape = RoundedCornerShape(10.dp),
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                    ){
                        Text(
                            text = "Owner",
                            fontSize = 20.sp,
                            color = DarkTextColor,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible,
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(0.5f)
                                .padding(vertical = 35.dp)

                        )

                        Box(modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .background(Purple)) {
                            Text(
                                text = Load.owner,
                                fontSize = 20.sp,
                                color = WhiteTextColor,
                                textAlign = TextAlign.Center,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                                    .padding(vertical = 35.dp)

                            )
                        }
                    }
                }
            }
        }
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ){
            Button(
                onClick = {
                navController.navigate(Screen.Home.route)
            },
                modifier = Modifier.background(Purple)
            ){
                Text(
                    text = "Готово",
                    Modifier
                        .padding(horizontal = 30.dp, vertical = 10.dp),
                    color = DarkTextColor
                )
            }
        }
    }
//    DropdownMenu(
//        modifier = Modifier
//            .height(170.dp)
//            .fillMaxWidth(),
//        expanded = expanded,
//        onDismissRequest = { expanded = false }
//    ) {
//        var string by rememberSaveable { mutableStateOf("") }
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(vertical = 35.dp),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            OutlinedTextField(
//                value = string,
//                onValueChange = {
//                    string = it
//                },
//                textStyle = TextStyle(DarkTextColor),
//                singleLine = true,
//            )
//            Button(
//                onClick = {
//                    onClick(navController, string, id)
//
//                },
//            ) {
//                Text(text = "Обновить")
//            }
//
//        }
//    }
}


//private fun onClick(navController: NavController, string: String, id: Long){
//
//    when(message){
//
//        "Band name" -> {
//            Data.allItems.forEach {
//                if (it.id.toLong() == id) {
//                    it.name = string
//                }
//                navController.navigate(Screen.Detail.route)
//            }
//        }
//
//        "Band x coordinates" ->{
//            Data.allItems.forEach {
//                if (it.id.toLong() == id) {
//                    try {
//                        it.coordinates.x = string.toLong()
//                    }
//                    catch (e: NumberFormatException){
//                        message = "Неверный формат данных"
//                    }
//                }
//                navController.navigate(Screen.Detail.route)
//            }
//        }
//
//        "Band y coordinates" ->{
//            Data.allItems.forEach {
//                if (it.id.toLong() == id) {
//                    try {
//                        it.coordinates.y = string.toDouble()
//                    }
//                    catch (e: NumberFormatException){
//                        message = "Неверный формат данных"
//                    }
//                }
//                navController.navigate(Screen.Detail.route)
//            }
//        }
//
//        "Number of participants" ->{
//            Data.allItems.forEach {
//                if (it.id.toLong() == id) {
//                    try {
//                        it.numberOfParticipants = string.toLong()
//                    }
//                    catch (e: NumberFormatException){
//                        message = "Неверный формат данных"
//                    }
//                }
//                navController.navigate(Screen.Detail.route)
//            }
//        }
//        "Band description" ->{
//            Data.allItems.forEach {
//                if (it.id.toLong() == id) {
//                    it.description = string
//                }
//                navController.navigate(Screen.Detail.route)
//            }
//        }
//
//        "Genre" -> {
//            Data.allItems.forEach {
//                if (it.id.toLong() == id) {
//                    try {
//                        it.genre = MusicGenre.valueOf(string.uppercase())
//                    } catch (e: NumberFormatException) {
//                        message = "Неверный формат данных"
//                    }
//                }
//                navController.navigate(Screen.Detail.route)
//            }
//        }
//
//        "Name of front man" -> {
//            Data.allItems.forEach {
//                if (it.id.toLong() == id) {
//                    it.frontMan.name = string
//                }
//                navController.navigate(Screen.Detail.route)
//            }
//        }
//
//        "Height of front man" -> {
//            Data.allItems.forEach {
//                if (it.id.toLong() == id) {
//                    try {
//                        it.frontMan.height = string.toInt()
//                    } catch (e: NumberFormatException) {
//                        message = "Неверный формат данных"
//                    }
//                }
//                navController.navigate(Screen.Detail.route)
//            }
//        }
//    }
//}

@Composable
@Preview(showBackground = true)
fun DetailScreenPreview() {
    DetailScreen(Load.load, navController = rememberNavController())
}

