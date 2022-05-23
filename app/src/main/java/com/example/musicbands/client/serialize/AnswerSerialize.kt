package com.example.lab8.client.serialize

import java.io.Serializable
data class AnswerSerialize(private val message : String) : Serializable{


    fun getMessage() = message

}