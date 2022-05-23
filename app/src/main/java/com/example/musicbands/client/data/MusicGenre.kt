package com.example.lab8.client.data

import java.io.Serializable
import java.util.*


enum class MusicGenre : Serializable {
    RAP, HIP_HOP, BLUES, POP, MATH_ROCK;

    companion object {
        fun toListString(): List<String> {
            val list = LinkedList<String>()
            list.add("RAP")
            list.add("HIP_HOP")
            list.add("BLUES")
            list.add("POP")
            list.add("MATH_ROCK")
            return list
        }
    }
}