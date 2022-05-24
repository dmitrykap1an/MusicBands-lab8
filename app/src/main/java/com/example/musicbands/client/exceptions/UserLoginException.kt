package com.example.musicbands.client.exceptions

class UserLoginException : Exception() {

    override val message: String = "Неверный формат логина"
}