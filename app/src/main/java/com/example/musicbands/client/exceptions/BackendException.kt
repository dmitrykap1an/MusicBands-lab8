package com.example.musicbands.client.exceptions

class BackendException(
    val code : Int,
    override val message : String
) : Exception() {

}