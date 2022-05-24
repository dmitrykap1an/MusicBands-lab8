package com.example.musicbands.ui.theme

import com.example.lab8.client.managers.TypeOfAuth
import com.example.musicbands.client.data.MusicBand
import com.example.musicbands.client.requests.Requests


object Load{
    var load: Long = 0
    var owner: String = "Anonymous"
    var requests: Requests? = null
    var typeOfAuth: TypeOfAuth? = null
}


object Data{
    var allItems = mutableListOf<MusicBand>()
}