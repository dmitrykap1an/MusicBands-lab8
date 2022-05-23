package com.example.musicbands.server.src.main.kotlin.server.serverWork

import java.io.ObjectInputStream
import java.util.concurrent.Callable

class ObjectReader<T> : Callable<T> {
    private val inn : ObjectInputStream

    constructor(inn : ObjectInputStream){
        this.inn = inn
    }

    override fun call(): T {
        println("Чтение пользователя")
        return inn.readObject() as T
    }


}