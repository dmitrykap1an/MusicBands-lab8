package com.example.musicbands.client.requests

import androidx.navigation.NavController
import com.example.musicbands.client.managers.TypeOfAuth
import com.example.musicbands.client.data.MusicBand
import com.example.musicbands.client.serialize.AnswerSerialize
import com.example.musicbands.client.serialize.CommandSerialize
import com.example.musicbands.client.serialize.UserSerialize
import com.example.musicbands.ui.screens.setMessage
import com.example.musicbands.ui.states.Messages
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.lang.reflect.Type
import java.net.ConnectException
import java.net.InetSocketAddress
import java.nio.channels.SocketChannel
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

class Requests(private val userName: String, private val password: String, private val navController: NavController){

    private lateinit var clientSocket: SocketChannel
    private lateinit var outt: ObjectOutputStream
    private lateinit var inn : ObjectInputStream
    private val executors: ExecutorService = Executors.newFixedThreadPool(5)
    val gson: Gson = Gson()
    private var registrationStatus = false


    fun openClient() : Boolean{

        val future = executors.submit(Callable<Boolean>{
            try {
                clientSocket = SocketChannel.open(InetSocketAddress("kaplaan.ru", 4004))
                outt = ObjectOutputStream(clientSocket.socket().outputStream)
                inn = ObjectInputStream(clientSocket.socket().inputStream)
                true
            } catch (e: ConnectException) {
                false
            }
        }
        )
        return future.get()
    }

    fun registration(typeOfAuth: TypeOfAuth): Pair<Boolean, String> {

        val future = executors.submit(Callable<Pair<Boolean, String>>{
            try {
                val user = UserSerialize(typeOfAuth, userName, password)
                val jsonData = gson.toJson(user)
                outt.writeUTF(jsonData)
                outt.flush()
                val answer = inn.readUTF()
                println("Данные прочитаны")
                val a = gson.fromJson(answer, AnswerSerialize::class.java)
                println("Попытка спарсить данные ")
                val status = a.getMessage()
                if (status == "OK") {
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
                Pair(false, "Связь потеряна")
            }
        }
    )
        return future.get()
    }

    fun sendCommands(command: CommandSerialize){
        try {
            val future = executors.submit(Callable {

                try {
                    val requests = gson.toJson(command)
                    outt.writeUTF(requests)
                    outt.flush()
                    val answer = inn.readUTF()
                    val response = gson.fromJson(answer, AnswerSerialize::class.java)
                    response
                } catch (e: JsonParseException) {
                    AnswerSerialize(Messages.commandException)

                }
            })
            executors.submit {
                while (!future.isDone){
                    if(future.isDone){
                        setMessage(future.get().getMessage())
                        break;
                    }
                }
            }
        }
        catch (e: java.io.EOFException){
            openClient()
            setMessage("Ошибка соединения")
        }

    }

    fun getCollection(command: CommandSerialize): MutableList<MusicBand> {

        val future = executors.submit(Callable {

            try {
                val request = gson.toJson(command)
                outt.writeUTF(request)
                outt.flush()

                val answer = inn.readUTF()
                val typeToken: Type = object : TypeToken<MutableList<MusicBand>>() {}.type;
                val response: MutableList<MusicBand> = gson.fromJson(answer, typeToken)
                response
            } catch (e: JsonParseException) {
                mutableListOf()
            }

        }
        )
        return future.get()
    }
}