package com.example.musicbands.client.requestsToServer

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
//    <uses-permission android:name="android.permission.CHANGE_NETWORK_STATE" />
}