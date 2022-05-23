package com.example.musicbands.client.requestsToServer

import com.example.lab8.client.managers.TypeOfAuth
import com.example.lab8.client.serialize.AnswerSerialize
import com.example.lab8.client.serialize.UserSerialize
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.net.ConnectException
import java.net.InetSocketAddress
import java.net.Socket
import java.net.SocketImpl
import java.nio.channels.SocketChannel
import java.util.concurrent.Callable
import kotlin.system.exitProcess

class Requests(private val typeOfAuth: TypeOfAuth, private val userName: String, private val password: String) : Runnable{

    private lateinit var clientSocket: SocketChannel
    private lateinit var outt: ObjectOutputStream
    private lateinit var inn : ObjectInputStream
    private var registrationStatus = false

    override fun run(){
//        try {
        println("Попытка подключиться к серверу")
        openClient()
        println("Подключение прошло успешно")
        registration(typeOfAuth, userName, password)


//        } catch (e: ConnectException) {
//            println("Сервер не отвечает")
//            println("Завершение работы клиента")
//            exitProcess(0)
//        }
    }

    private fun openClient(){
        println("Открытие клиента")

        clientSocket  = SocketChannel.open(InetSocketAddress("kaplaan.ru", 4004))
        outt = ObjectOutputStream(clientSocket.socket().outputStream)
        inn = ObjectInputStream(clientSocket.socket().inputStream)
        println("Клиент открыт")
    }

    private fun registration(typeOfAuth: TypeOfAuth, userName: String, password: String): Pair<Boolean, String> {
        try {
            println("Регистрация")
            val user = UserSerialize(typeOfAuth, userName, password)
            outt.writeObject(user)
            outt.flush()
            val answer = inn.readObject() as AnswerSerialize
            val status = answer.getMessage()
            return if (status == "OK") {
                registrationStatus = true;
                Pair(registrationStatus, "Вход произошел успешно")
            } else if (status == "Регистрация прошла успешно") {
                registrationStatus = true
                Pair(registrationStatus, status)
            } else if (status.split(' ')[0] == "Существует") {
                Pair(false, "Пользователь с таким именем уже существует")
            } else {
                Pair(false, "Пользователь с такими именем и паролем не обнаружен")
            }
        } catch (e: IOException) {
            return Pair(false, "Связь потеряна")
        }
    }
}