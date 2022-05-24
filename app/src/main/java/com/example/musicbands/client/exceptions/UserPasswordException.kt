package com.example.musicbands.client.exceptions

class UserPasswordException : Exception() {

    override val message: String = "Неверный формат пароля"
}