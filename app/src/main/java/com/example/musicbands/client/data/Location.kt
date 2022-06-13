package com.example.lab8.client.data

import java.io.Serializable


data class Location(//Поле не может быть null
    val x: Long, val y: Int, //Поле не может быть null
    val z: Long
){

    override fun toString(): String {
        return "x : $x, y : $y, z : $z"
    }
}