package com.example.musicbands.client.exceptions

class CloseSocketException : Exception() {

    override fun toString(): String {

        return "Невозможно закрыть сокет"

    }
}