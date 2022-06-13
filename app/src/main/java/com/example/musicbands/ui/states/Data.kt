package com.example.musicbands.ui.states

import com.example.lab8.client.data.Location
import com.example.lab8.client.data.MusicGenre
import com.example.musicbands.client.managers.TypeOfAuth
import com.example.musicbands.client.data.Coordinates
import com.example.musicbands.client.data.MusicBand
import com.example.musicbands.client.data.Person
import com.example.musicbands.client.requests.Requests
import java.util.*
object Messages{
    const val commandException: String = "Ошибка выполнения команды"
    var addMessage: String = ""
}

object Load{
    var load: Long = 0
    var owner: String = ""
    var password = ""
    var requests: Requests? = null
    var typeOfAuth: TypeOfAuth? = null
    var currentLanguage = Languages.English.nameOfLanguage
//    var bundle: ResourceBundle = ResourceBundle.getBundle("Messages", Languages.Spanish.locale)
}


sealed class Languages(
    val nameOfLanguage: String,
    val locale: Locale
){
    object Russian: Languages(nameOfLanguage = "Русский", locale = Locale("ru", "RU"))
    object English: Languages(nameOfLanguage = "English", locale = Locale("en", "US"))
    object Polish: Languages(nameOfLanguage = "Polski", locale = Locale("pl", "PL"))
    object Spanish: Languages(nameOfLanguage = "Español", locale = Locale("es", "CR"))
}


object Data{
    var allItems = mutableListOf<MusicBand>(
        MusicBand("Valakas", Coordinates(123, 123.00), 2, "bombass",
            MusicGenre.RAP, Person("Denis Petrov", 180, Location(123, 123, 123))),
        MusicBand("Valakas", Coordinates(123, 123.00), 2, "bombass",
            MusicGenre.RAP, Person("Denis Petrov", 180, Location(123, 123, 123))),
        MusicBand("Valakas", Coordinates(123, 123.00), 2, "bombass",
            MusicGenre.RAP, Person("Denis Petrov", 180, Location(123, 123, 123))),
        MusicBand("Valakas", Coordinates(123, 123.00), 2, "bombass",
            MusicGenre.RAP, Person("Denis Petrov", 180, Location(123, 123, 123))),
        MusicBand("Valakas", Coordinates(123, 123.00), 2, "bombass",
            MusicGenre.RAP, Person("Denis Petrov", 180, Location(123, 123, 123))),
        MusicBand("Valakas", Coordinates(123, 123.00), 2, "bombass",
            MusicGenre.RAP, Person("Denis Petrov", 180, Location(123, 123, 123))),
        MusicBand("Valakas", Coordinates(123, 123.00), 2, "bombass",
            MusicGenre.RAP, Person("Denis Petrov", 180, Location(123, 123, 123))),
        MusicBand("Valakas", Coordinates(123, 123.00), 2, "bombass",
            MusicGenre.RAP, Person("Denis Petrov", 180, Location(123, 123, 123))),
        MusicBand("Valakas", Coordinates(123, 123.00), 2, "bombass",
            MusicGenre.RAP, Person("Denis Petrov", 180, Location(123, 123, 123))),
        MusicBand("Valakas", Coordinates(123, 123.00), 2, "bombass",
            MusicGenre.RAP, Person("Denis Petrov", 180, Location(123, 123, 123))),
        MusicBand("Valakas", Coordinates(123, 123.00), 2, "bombass",
            MusicGenre.RAP, Person("Denis Petrov", 180, Location(123, 123, 123))),
        MusicBand("Valakas", Coordinates(123, 123.00), 2, "bombass",
            MusicGenre.RAP, Person("Denis Petrov", 180, Location(123, 123, 123)))
    )
}