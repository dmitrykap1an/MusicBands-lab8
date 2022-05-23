package com.example.lab8.client.exceptions

class EmptyArgumentException : Exception() {

    override fun toString(): String {

        return "Пустая команда"

    }
}