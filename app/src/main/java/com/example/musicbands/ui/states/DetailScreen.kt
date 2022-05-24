package com.example.musicbands.ui.theme

import android.graphics.Paint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.modifier.ModifierLocalReadScope
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.PopUpToBuilder
import androidx.navigation.compose.rememberNavController
import com.example.musicbands.R
import com.example.musicbands.client.data.MusicBand


@Composable
fun DetailScreen(id: Long){

    var data: MusicBand? = Data.allItems.find { it.id.toLong() == id }
    if (data == null)
        data = Data.allItems[0]
    var command by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WhiteBackgroundColor)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
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
                                text = "${data.name}",
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
                            text = "Band\ncoordinates",
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
                                text = "${data.coordinates}", // FIXME: вывести координаты не в виде кортежа
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
                                text = "${data.description}",
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
                            text = "Band\nfrontman",
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
                                text = "${data.frontMan.name}\n" +
                                        "${data.frontMan.height}\n" +
                                        "${data.frontMan.location}\n" +
                                        "${data.frontMan.passportID}",
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
                                text = Load.owner,  // FIXME: поменять имя загрузку владельца 
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
    }
}

@Composable
@Preview(showBackground = true)
fun DetailScreenPreview() {
    DetailScreen(Load.load)
}

