package com.example.musicbands.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.musicbands.R
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.musicbands.client.serialize.CommandSerialize
import com.example.musicbands.ui.states.Data
import com.example.musicbands.ui.states.Load
import com.example.musicbands.ui.states.Screen
import com.example.musicbands.ui.theme.*

private var message = ""

@Composable
fun MainContent(navController: NavController) {

    Text(
        text = stringResource(R.string.myBands),
        color = DarkTextColor,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .padding(10.dp)
            .background(WhiteBackgroundColor)
    )

    LazyRow(
        modifier = Modifier
            .background(Color(0xFFF0F0F0))
    ) {
        for (i in Data.allItems.indices) {
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
                            text = Data.allItems[i].name,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = stringResource(id = R.string.commands),
            color = DarkTextColor,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
                .background(WhiteBackgroundColor)
        )

        LazyColumn(
            modifier = Modifier
                .background(WhiteBackgroundColor)
                .height(240.dp)
        ) {

            item {
                Button(
                    onClick = {
                        val command = CommandSerialize("help")
                        Load.requests!!.sendCommands(command)
                        navController.navigate(Screen.Home.route)
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
                        text = stringResource(id = R.string.help),
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
                        val command = CommandSerialize("info")
                        Load.requests!!.sendCommands(command)
                        navController.navigate(Screen.Home.route)
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
                        text = stringResource(id = R.string.info),
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
                        text = stringResource(id = R.string.add),
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
                              navController.navigate(Screen.UpdateId.route)
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
                        text = stringResource(id = R.string.updateId),
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
                        navController.navigate(Screen.RemoveByID.route)
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
                        text = stringResource(id = R.string.remove_element_by_id),
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
                        Data.allItems.clear()
                        Load.requests!!.sendCommands(CommandSerialize("clear"))
                        navController.navigate(Screen.Home.route)
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
                        text = stringResource(id = R.string.clear),
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
                        android.os.Process.killProcess(android.os.Process.myPid())
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
                    onClick = {
                        val commandSerialize = CommandSerialize("remove_first")
                        Load.requests!!.sendCommands(commandSerialize)
                        if(message == "Первый элемент удален"){
                            Data.allItems.remove(Data.allItems[0])
                        }
                        else setMessage(message, navController)
                        navController.navigate(Screen.Home.route)
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
                        text = stringResource(id = R.string.remove_first),
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
                        navController.navigate(Screen.RemoveGreater.route)

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
                        text = stringResource(id = R.string.remove_greater),
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
                        val commandSerialize = CommandSerialize("history")
                        Load.requests!!.sendCommands(commandSerialize)
                        navController.navigate(Screen.Home.route)
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
                        text = stringResource(id = R.string.history),
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
                            navController.navigate(Screen.RemoveByDescription.route)
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
                        text = stringResource(id = R.string.remove_all_by_description),
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
                        navController.navigate(Screen.CountLessThan.route)
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
                        text = stringResource(id = R.string.count_less_than_number_of_participants),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxSize(),
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Visible
                    )
                }
            }

        }
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)) {
            TextField(value = message, onValueChange = {
                println(message)
            },
                Modifier
                    .fillMaxSize()
                    .padding(10.dp))
        }
    }
}

fun setMessage(mes: String, navController: NavController? = null){
    message = mes
    println(mes)
    navController!!.navigate(Screen.Home.route)
}
