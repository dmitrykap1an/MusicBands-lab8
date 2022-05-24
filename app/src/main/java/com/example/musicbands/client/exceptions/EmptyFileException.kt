package com.example.musicbands.client.exceptions

class EmptyFileException : Exception(){

    override fun toString(): String {
        return "Пустая коллекция"
    }
}