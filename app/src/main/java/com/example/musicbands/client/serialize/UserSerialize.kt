package com.example.lab8.client.serialize

import com.example.lab8.client.managers.TypeOfAuth
import java.io.Serializable

data class UserSerialize(private val typeOfAuth: TypeOfAuth, private val name : String, private val password : String ) : Serializable {


    fun getName() = name;

    fun getPassword() = password

    fun getTypeOfAuth() = typeOfAuth.toString()
}