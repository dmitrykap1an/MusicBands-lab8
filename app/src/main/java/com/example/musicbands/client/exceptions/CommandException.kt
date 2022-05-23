package com.example.lab8.client.exceptions

class CommandException : Exception() {

    override fun toString(): String {
        return "Ошибка ввода команды"
    }
}