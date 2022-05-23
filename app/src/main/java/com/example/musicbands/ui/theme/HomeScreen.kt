package com.example.musicbands.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavController ){
   AppTheme {
        val moonScrollSpeed = 0.08f
        val midBgScrollSpeed = 0.03f

        val lazyListState = rememberLazyListState()

        var moonOffset by remember {
            mutableStateOf(0f)
        }
        var midBgOffset by remember {
            mutableStateOf(0f)
        }

        val nestedScrollConnection = object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val layoutInfo = lazyListState.layoutInfo
                // Check if the first item is visible
                if(lazyListState.firstVisibleItemIndex == 0) {
                    return Offset.Zero
                }
                if(layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1) {
                    return Offset.Zero
                }
                moonOffset += delta * moonScrollSpeed
                midBgOffset += delta * midBgScrollSpeed
                return Offset.Zero
            }
        }
        // Объекты, которые надо получить (можно эти убрать и юзать, которые есть, просто переименовав ниже всё)

        var colors = mutableListOf<Color>(Color.Cyan, Color.White)
        var userName = "USSR" // поставить имя из клиента
        var lenOfItems = Data.allItems.size-1 // количество объектов в коллекции
        var command by rememberSaveable { mutableStateOf("") }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF6200EE))
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .nestedScroll(nestedScrollConnection)
                    .background(Color(0xFFFC7DA8)),
                state = lazyListState
            ) {
                item {
                    Text(
                        text = userName,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        color = Color.White
                    )
                }
                var prev = ""
                for (i in 0..lenOfItems) {
                    item {
                        Button(onClick = {
                            navController.navigate(route = Screen.Detail.route)
                            Load.load = Data.allItems[i].id
                        }) {
                            Text(
                                Data.allItems[i].name,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                color = colors[if (prev != Data.allItems[i].owner) 0 else 1],
                            )
                        }

                    }
                    prev = Data.allItems[i].owner
                }

            }
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


}




@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}