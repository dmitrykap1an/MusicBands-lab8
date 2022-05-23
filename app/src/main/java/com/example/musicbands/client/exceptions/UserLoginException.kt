package com.example.lab8.client.exceptions

class UserLoginException : Exception() {

    override val message: String? = "Неверный формат логина"
}