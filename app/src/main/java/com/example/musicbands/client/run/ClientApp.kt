package com.example.musicbands.client.run

import com.example.lab8.client.managers.TypeOfAuth
import com.example.lab8.client.run.Client
import com.example.musicbands.client.requestsToServer.Requests
import java.util.concurrent.Executors

fun main(){


    val executors = Executors.newFixedThreadPool(4)
    val future = executors.submit(Requests(TypeOfAuth.Registered, "newton", "newton"))
    val result = future.get()
    println(result)




}