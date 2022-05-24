package com.example.lab8.client.run

import com.example.musicbands.client.exceptions.CommandException
import com.example.lab8.client.managers.CommandFinder
import com.example.musicbands.client.managers.InputData
import com.example.lab8.client.managers.TypeOfAuth
import com.example.musicbands.client.serialize.AnswerSerialize
import com.example.musicbands.client.serialize.UserSerialize
import java.io.*
import java.net.ConnectException
import java.net.InetSocketAddress
import java.net.SocketException
import java.nio.channels.SocketChannel
import kotlin.system.exitProcess


class Client(port : Int, host : String, userName : String, password : String, typeOfAuth: TypeOfAuth) : Runnable {


    private lateinit var clientSocket: SocketChannel;//сокет для общения
    private lateinit var inn: ObjectInputStream; // поток чтения из сокета
    private lateinit var outt: ObjectOutputStream; // поток записи в сокет
    private val commandFinder = CommandFinder(InputData())
    private val PORT = port;
    private val HOST = host;
    private var registrationStatus = false;
    private val userName : String = userName
    private val password : String = password
    private val typeOfAuth = typeOfAuth



    override fun run() {

        println("Клиент запущен")
        openClient()
        while (true) {
            try {
                requestToServer()
            } catch (e: UninitializedPropertyAccessException) {
                println("Сервер не доступен")
                println("Время ожидания 5 секунд")
                Thread.sleep(5000L)
            }
        }
    }


    private fun openClient(){

        while (true) {
            try {
                clientSocket = SocketChannel.open(InetSocketAddress(HOST, PORT))
                outt = ObjectOutputStream(clientSocket.socket().outputStream)
                inn = ObjectInputStream(clientSocket.socket().inputStream)
                break
            }
            catch(e : ConnectException) {
                println("Сервер не отвечает")
                println("Завершение работы клиента")
                exitProcess(0)
            }
        }
    }


    private fun registration() {

        try {
            while (!registrationStatus) {
                val user = UserSerialize(typeOfAuth, userName, password)
                outt.writeObject(user)
                outt.flush()
                val answer = inn.readObject() as AnswerSerialize
                val status = answer.getMessage()
                if (status == "OK") {
                    registrationStatus = true;
                    println("Вход произошел успешно")
                } else if (status == "Регистрация прошла успешно") {
                    println(status)
                    registrationStatus = true
                } else if (status.split(' ')[0] == "Существует") {
                    println("Пользователь с таким именем уже существует")
                } else println("Пользователь с такими именем и паролем не обнаружен")
            }
        }catch (e : IOException){
            println("Связь потеряна")
            println("Попытка восставновить подлючение")
            openClient()
        }
    }

    private fun requestToServer() {
        try {
            if (!registrationStatus) {
                registration()
            }
            val command = commandFinder.commandSearcher() ?: throw CommandException()
            outt.writeObject(command) // отправляем сообщение на сервер
            outt.flush()
            val answer = inn.readObject() as AnswerSerialize// ждём, что скажет сервер
            println(answer.getMessage())
            if (command.getNameCommand() == "exit") {
                exitProcess(0)
            }

        } catch (e: ConnectException) {
            println("Связь нарушена")
            Thread.sleep(10000L)
            openClient()
        } catch (e: CommandException) {
            println("Команда не найдена")
        } catch (e: EOFException) {
            println("Ошибка конца ввода")
            openClient()
        }catch (e: SocketException) {
            println("Сервер закрыт")
        }catch (e : IOException){
            println("Связь потеряна")
            openClient()
        }
    }

}