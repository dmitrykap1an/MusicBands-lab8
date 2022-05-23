package com.example.musicbands.test

import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.logging.HttpLoggingInterceptor


data class SignInRequestBody(
    val email : String,
    val password : String
)

data class SignInResponseBody(
    val token : String
)

val contentType = "application/json; charset=utf-8".toMediaType() //тип запроса

fun main(){

    val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY) // логирование

    val gson = Gson()

    val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build() //создаем клиент

    val requestBody = SignInRequestBody(
        "dmitry@kaplaan.ru",
        "newton"
    )

    val requestToJson = gson.toJson(requestBody)

    val httpRequestBody = requestToJson.toRequestBody(contentType)

    val request = Request.Builder()
        .post(httpRequestBody)
        .url("http://kaplaan.ru/sign-in")
        .build()

    val call = client.newCall(request)

    val response = call.execute()

    if(response.isSuccessful){
        val responseBody = response.body!!.string()
        val signInResponseBody = gson.fromJson(requestToJson,
        SignInResponseBody::class.java)
        println("Token : ${signInResponseBody.token}")
    }
    else{
        println("ooops")
    }
}