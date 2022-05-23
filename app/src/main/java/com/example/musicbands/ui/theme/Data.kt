package com.example.musicbands.ui.theme

import java.util.*

data class LabWork(
    var id: Long = -1,
    val name: String,
    val coordinates: Coordinates,
    val numberOfParticipants: Long,
    val description: String,
    val genre: MusicGenre,
    val frontMan: Person,
    val owner: String,
    val creationDate: Date = Date()) : Comparable<LabWork> {

    override fun compareTo(other: LabWork) = ((this.numberOfParticipants) - (other.numberOfParticipants)).toInt()
}

class Coordinates(
    val x: Long,
    val y: Long
) {

    override fun toString(): String {
        return "(x=${x}, y=${y})"
    }
}
enum class MusicGenre {
    RAP, HIP_HOP, BLUES, POP, MATH_ROCK
}
class Person(val name: String? = null, val height: Int? = null, val passportID: String? = null, val location: Location? = null) {
    override fun toString(): String {
        return "(name=${name}, height=${height}, passportID=${passportID}, location=${location})"
    }

}
class Location(val x: Long = 0, val y: Long = 0, val z: Long = 0){

}
object Load{
    var load: Long = 0
}

object Data{
    var allItems = mutableListOf<LabWork>(
        LabWork(0, "HUI", Coordinates(3, 4), 27, "descr", MusicGenre.HIP_HOP, Person(), "USSR"),
        LabWork(1, "HUI", Coordinates(3, 4), 27, "descr", MusicGenre.HIP_HOP, Person(), "Krash"),
        LabWork(2, "HUI", Coordinates(3, 4), 27, "descr", MusicGenre.HIP_HOP, Person(), "USSR"),
        LabWork(2, "HUI", Coordinates(3, 4), 27, "descr", MusicGenre.HIP_HOP, Person(), "USSR")
    )
}