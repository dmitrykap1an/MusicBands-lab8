package com.example.musicbands.ui.theme

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableOpenTarget
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp


@Composable
fun ProfileIcon(){

    IconButton(onClick = {

    },

        ) {
        Icon(Icons.Filled.Person,
            modifier = Modifier.size(80.dp),
            tint = Color.Black,
            contentDescription = "Profile")
        Text(text = "Profile")
    }


}