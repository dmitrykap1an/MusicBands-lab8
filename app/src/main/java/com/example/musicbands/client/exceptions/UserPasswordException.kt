package com.example.lab8.client.exceptions

class UserPasswordException : Exception() {

    override val message: String? = "Неверный формат пароля"
}