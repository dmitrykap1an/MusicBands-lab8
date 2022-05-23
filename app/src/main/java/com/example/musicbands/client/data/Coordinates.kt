package com.example.musicbands.client.data

import java.io.Serializable


data class Coordinates(//Максимальное значение поля: 220, Поле не может быть null
    val x: Long, val y: Double
) : Serializable {

    override fun toString(): String {
        return "x : $x, y : $y"
    }
}