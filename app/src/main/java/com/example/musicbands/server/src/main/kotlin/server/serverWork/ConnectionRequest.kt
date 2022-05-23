//package com.example.musicbands.server.src.main.kotlin.server.serverWork
//
//
//import server.Managers.CommandManager
//import com.example.musicbands.server.src.main.kotlin.server.serverWork.UserChecker
//import java.io.ObjectInputStream
//import java.io.ObjectOutputStream
//import java.nio.channels.*
//import java.util.concurrent.ExecutorService
//
//class ConnectionRequest : Runnable {
//    private var registrationStatus = false
//    private var clientSocket : SocketChannel
//    private val commandManager : CommandManager
//    private lateinit var nameOfUser : String;
//    private val executor : ExecutorService
//    private lateinit var outt: ObjectOutputStream
//    private lateinit var inn: ObjectInputStream
//
//    constructor(clientSocket : SocketChannel, commandManager: CommandManager, executor : ExecutorService){
//        this.clientSocket = clientSocket
//        this.commandManager = commandManager
//        this.executor = executor
//    }
//
//    override fun run(){
//
//        outt = ObjectOutputStream(clientSocket.socket().outputStream)
//        inn = ObjectInputStream(clientSocket.socket().inputStream)
//        if(!registrationStatus){
//            val future = executor.submit(UserChecker(executor, inn, outt))
//            val pair = future.get()
//            registrationStatus = pair.first
//            nameOfUser = pair.second
//        }
//        executor.submit(MonoHandler(clientSocket, commandManager, nameOfUser, inn, outt))
//
//    }
//
//}