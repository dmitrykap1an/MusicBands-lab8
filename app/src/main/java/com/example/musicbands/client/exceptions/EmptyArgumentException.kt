package com.example.musicbands.client.exceptions

class EmptyArgumentException : Exception() {

    override fun toString(): String {

        return "Пустая команда"

    }
}
