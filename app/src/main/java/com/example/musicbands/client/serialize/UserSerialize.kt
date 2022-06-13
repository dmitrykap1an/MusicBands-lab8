package com.example.musicbands.client.serialize

import com.example.musicbands.client.managers.TypeOfAuth

data class UserSerialize(private val typeOfAuth: TypeOfAuth, private val name : String, private val password : String ){


    fun getName() = name;

    fun getPassword() = password

    fun getTypeOfAuth() = typeOfAuth.toString()
}