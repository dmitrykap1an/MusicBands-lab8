package com.example.musicbands.client.requestsToServer

import com.example.lab8.client.managers.TypeOfAuth
import com.example.lab8.client.serialize.AnswerSerialize
import com.example.lab8.client.serialize.UserSerialize
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.net.InetSocketAddress
import java.nio.channels.SocketChannel

class ServerRequests(
//    private val executor: Executor
) {
    private lateinit var clientSocket : SocketChannel
    private lateinit var outt: ObjectOutputStream
    private lateinit var inn : ObjectInputStream
    private var registrationStatus = false


    init{
        openClient()
    }

   private fun openClient(){
        println("Открытие клиента")

        clientSocket  = SocketChannel.open(InetSocketAddress("localhost", 4004))
        outt = ObjectOutputStream(clientSocket.socket().outputStream)
        inn = ObjectInputStream(clientSocket.socket().inputStream)
    }

    fun registration(typeOfAuth: TypeOfAuth, userName: String, password: String, callback: (Result<Pair<Boolean, String>>) -> Unit){

//        executor.execute {
            try {
                println("Регистрация")
                val user = UserSerialize(typeOfAuth, userName, password)
                outt.writeObject(user)
                outt.flush()
                val answer = inn.readObject() as AnswerSerialize
                val status = answer.getMessage()
                if (status == "OK") {
                    registrationStatus = true;
                } else if (status == "Регистрация прошла успешно") {
                    registrationStatus = true
                    Pair(registrationStatus, status)
                } else if (status.split(' ')[0] == "Существует") {
                    Pair(false, "Пользователь с таким именем уже существует")
                } else {
                    Pair(false, "Пользователь с такими именем и паролем не обнаружен")
                }
            } catch (e: IOException) {
//            return Pair(false, "Связь потеряна")
            }
//        }
    }

}