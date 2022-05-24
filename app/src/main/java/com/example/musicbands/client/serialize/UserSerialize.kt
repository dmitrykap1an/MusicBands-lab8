package com.example.musicbands.client.serialize

import com.example.lab8.client.managers.TypeOfAuth
import java.io.Serializable

data class UserSerialize(private val typeOfAuth: TypeOfAuth, private val name : String, private val password : String ){


    fun getName() = name;

    fun getPassword() = password

    fun getTypeOfAuth() = typeOfAuth.toString()
}