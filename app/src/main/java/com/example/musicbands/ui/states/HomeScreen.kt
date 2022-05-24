package com.example.musicbands.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musicbands.ui.states.Screen

var lenOfItems = Data.allItems.size-1

@Composable
fun HomeScreen(navController: NavController ){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteBackgroundColor)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Purple),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "HomePage",
                style = TextStyle(fontFamily = FontFamily.Cursive),
                color = WhiteTextColor,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Column(Modifier.background(WhiteBackgroundColor)){

            Text(
                text = "UserName: example",
                color = DarkTextColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            )

            Text(
                text = "Password: example",
                color = DarkTextColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            )
        }

        Column(Modifier.background(WhiteBackgroundColor)) {

            Text(
                text = "MyBands",
                style = TextStyle(fontFamily = FontFamily.Cursive),
                color = DarkTextColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(10.dp)
                    .background(WhiteBackgroundColor)
            )

            LazyRow(modifier = Modifier
                .background(Color(0xFFF0F0F0))
            ) {
                for (i in 0..lenOfItems) {
                    item {
                        Box(
                            modifier = Modifier
                                .width(110.dp)
                                .height(120.dp)
                                .padding(5.dp, 5.dp, 5.dp, 5.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(WhiteBackgroundColor)
                        ) {
                            Button(
                                onClick = {
                                    navController.navigate(route = Screen.Detail.route)
                                    Load.load = Data.allItems[i].id.toLong()
                                },
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Purple,
                                    contentColor = WhiteTextColor
                                ),
                                modifier = Modifier.fillMaxSize(),
                                elevation = ButtonDefaults.elevation(
                                    defaultElevation = 6.dp,
                                    pressedElevation = 8.dp,
                                    disabledElevation = 0.dp
                                )
                            ) {
                                Text(
                                    text = "${Data.allItems[i].name}",
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }

        Column(modifier = Modifier.fillMaxSize()){

            Text(
                text = "Commands",
                style = TextStyle(fontFamily = FontFamily.Cursive),
                color = DarkTextColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(10.dp)
                    .background(WhiteBackgroundColor)
            )

            LazyColumn(modifier = Modifier
                .background(Color(0xFFF0F0F0))
                .height(240.dp)
            ){

                item {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Purple,
                            contentColor = WhiteTextColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .height(30.dp)
                            .clip(RoundedCornerShape(10.dp)),
                    ) {
                        Text(
                            text = "Help",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible
                        )
                    }
                }

                item {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Purple,
                            contentColor = WhiteTextColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .height(30.dp)
                            .clip(RoundedCornerShape(10.dp)),
                    ) {
                        Text(
                            text = "Info",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible
                        )
                    }
                }

                item {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Purple,
                            contentColor = WhiteTextColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .height(30.dp)
                            .clip(RoundedCornerShape(10.dp)),
                    ) {
                        Text(
                            text = "Show",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible
                        )
                    }
                }

                item {
                    Button(
                        onClick = {
                                  navController.navigate(Screen.Add.route)
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Purple,
                            contentColor = WhiteTextColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .height(30.dp)
                            .clip(RoundedCornerShape(10.dp)),
                    ) {
                        Text(
                            text = "Add",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible
                        )
                    }
                }

                item {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Purple,
                            contentColor = WhiteTextColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .height(30.dp)
                            .clip(RoundedCornerShape(10.dp)),
                    ) {
                        Text(
                            text = "Update id",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible
                        )
                    }
                }

                item {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Purple,
                            contentColor = WhiteTextColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .height(30.dp)
                            .clip(RoundedCornerShape(10.dp)),
                    ) {
                        Text(
                            text = "removeByID",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible
                        )
                    }
                }

                item {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Purple,
                            contentColor = WhiteTextColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .height(30.dp)
                            .clip(RoundedCornerShape(10.dp)),
                    ) {
                        Text(
                            text = "Clear",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible
                        )
                    }
                }

                item {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Purple,
                            contentColor = WhiteTextColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .height(30.dp)
                            .clip(RoundedCornerShape(10.dp)),
                    ) {
                        Text(
                            text = "Save",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible
                        )
                    }
                }

                item {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Purple,
                            contentColor = WhiteTextColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .height(30.dp)
                            .clip(RoundedCornerShape(10.dp)),
                    ) {
                        Text(
                            text = "Exit",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible
                        )
                    }
                }

                item {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Purple,
                            contentColor = WhiteTextColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .height(30.dp)
                            .clip(RoundedCornerShape(10.dp)),
                    ) {
                        Text(
                            text = "remove_first",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible
                        )
                    }
                }

                item {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Purple,
                            contentColor = WhiteTextColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .height(30.dp)
                            .clip(RoundedCornerShape(10.dp)),
                    ) {
                        Text(
                            text = "remove_greater",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible
                        )
                    }
                }

                item {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Purple,
                            contentColor = WhiteTextColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .height(30.dp)
                            .clip(RoundedCornerShape(10.dp)),
                    ) {
                        Text(
                            text = "history",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible
                        )
                    }
                }

                item {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Purple,
                            contentColor = WhiteTextColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .height(30.dp)
                            .clip(RoundedCornerShape(10.dp)),
                    ) {
                        Text(
                            text = "remove all by description",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible
                        )
                    }
                }

                item {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Purple,
                            contentColor = WhiteTextColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .height(30.dp)
                            .clip(RoundedCornerShape(10.dp)),
                    ) {
                        Text(
                            text = "count less than number of participants",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible
                        )
                    }
                }

                item {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Purple,
                            contentColor = WhiteTextColor
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                            .height(30.dp)
                            .clip(RoundedCornerShape(10.dp)),
                    ) {
                        Text(
                            text = "print field descending front man",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Visible
                        )
                    }
                }
            }

            Column(modifier = Modifier.fillMaxSize().padding(10.dp)) {
                TextField(value = "", onValueChange = {}, Modifier.fillMaxSize().padding(10.dp))
            }



        }
    }
}




@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}