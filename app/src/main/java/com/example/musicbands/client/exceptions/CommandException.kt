package com.example.musicbands.client.exceptions

class CommandException : Exception() {

    override fun toString(): String {
        return "Ошибка ввода команды"
    }
}