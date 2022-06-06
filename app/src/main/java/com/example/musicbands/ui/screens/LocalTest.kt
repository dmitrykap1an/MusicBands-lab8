package com.example.musicbands.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.musicbands.R

@Composable
fun Test() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(text = stringResource(id = R.string.hello_world))
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = stringResource(id = R.string.kotlin))


    }

}