package com.example.musicbands.client.data

import com.example.lab8.client.data.Location
import java.io.Serializable
import java.util.*


class Person{

    var name: String
    var height: Int
    var passportID: String
    var location: Location

    constructor(name: String, height: Int, location: Location) {
        this.name = name
        this.height = height
        passportID = UUID.randomUUID().toString()
        this.location = location
    }

    constructor(name: String, height: Int, passportId: String, location: Location) {
        this.name = name
        this.height = height
        passportID = passportId
        this.location = location
    }

    override fun toString(): String {
        return """
               Имя : $name
               Рост : $height
               ID паспорта : $passportID
               Местоположение : $location
               """.trimIndent()
    }
}