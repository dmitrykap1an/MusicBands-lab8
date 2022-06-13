package com.example.musicbands.client.data

import com.example.lab8.client.data.MusicGenre
import java.io.Serializable
import java.sql.Timestamp

class MusicBand{
    var id: Int
    var name : String;
    var coordinates : Coordinates
    var numberOfParticipants: Long
    var description: String
    var genre: MusicGenre
    var frontMan: Person
    var creationDate : Timestamp

    companion object {
        private var counter = 1
        fun setId(id: Int) {
            counter = id
        }
    }

    constructor(name: String, coordinates: Coordinates, numberOfParticipants: Long, description: String, genre:
    MusicGenre, frontMan: Person){

        this.name = name;
        this.coordinates = coordinates
        this.numberOfParticipants = numberOfParticipants
        this.description = description
        this.genre = genre
        this.frontMan = frontMan
        creationDate = Timestamp(System.currentTimeMillis())
        id = counter++

    }

    fun getFrontMann(): Person {
        return frontMan
    }

    fun getCoordinatess(): Coordinates {
        return coordinates
    }

    fun getCreationDatee(): Timestamp {
        return creationDate
    }

    fun getGenre(): String {
        return genre.toString()
    }


    override fun toString(): String {
        return """
            Id группы : $id
            Название группы : $name
            Дата создания элемента : ${creationDate.toString()}
            Координаты местоположения группы : ${coordinates.toString()}
            Количество участников : $numberOfParticipants
            Описание группы : $description
            Музыкальный жанр : ${genre.toString()}
            Солист : $frontMan
            """.trimIndent()
    }

}