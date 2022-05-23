package com.example.musicbands.server.src.main.kotlin.server.serverWork

import com.example.lab8.client.managers.TypeOfAuth
import com.example.lab8.client.serialize.UserSerialize
import org.postgresql.util.PSQLException
import com.example.musicbands.server.src.main.kotlin.server.Database.PasswordHasher
import java.sql.Connection
import java.sql.DriverManager
import java.util.*
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Semaphore

class UserChecker : Callable<Pair<Boolean, String>> {
    private val semaphore = Semaphore(1)
    private var registrationStatus = false
    private val executor : ExecutorService
    private val user : UserSerialize
    private lateinit var nameOfUser : String

    constructor(executor : ExecutorService, name : String, password : String, typeOfAuth: TypeOfAuth){
        this.executor = executor
        this.user = UserSerialize(typeOfAuth, name, password)
    }

    override fun call(): Pair<Boolean, String> {
        asquirePool()
        while(!registrationStatus){

            println("Проверка регистрации")
            val userName = "s334585"
            val password= "gey514"
            val url = "jdbc:postgresql://10.0.2.2:1441/studs"
            val connection = DriverManager.getConnection(url, userName, password)
            return if(user.getTypeOfAuth() == "Registered"){
                val result = checkRegistration(connection, user)
                Pair(result, user.getName())
            } else {
                val result = registration(connection, user)
                Pair(result, user.getName())

            }
        }
        releasePool()
        return Pair(true, nameOfUser)
    }


    private fun checkRegistration(connection : Connection, user : UserSerialize) : Boolean{

        try{

            if(checkPerson(connection, user)){

                val saltStatement = connection.prepareStatement("SELECT salt FROM userssalt WHERE name = ?")
                saltStatement.setString(1, user.getName())
                var salt : String
                val saltRs = saltStatement.executeQuery()
                var flag = false
                while (saltRs.next()){
                    flag = true
                    salt = saltRs.getString("salt")
                    val pass = PasswordHasher.hashPassword(user.getPassword(), salt)

                    val statement = connection.prepareStatement("SELECT COUNT(*) FROM users WHERE name = ? and password = ?")
                    statement.setString(1, user.getName())
                    statement.setString(2, pass)

                    val rs = statement.executeQuery()

                    while(rs.next()){
                        try{
                            val cnt = rs.getInt("count")
                            if(cnt > 0){
                                println("Пользователь '${user.getName()}' обнаружен")
                                nameOfUser = user.getName()
                                Server.logger.info("Пользователь '${user.getName()}' обнаружен")
                                return true

                            }
                            else{
                                println("Пользователь '${user.getName()}' не существует")
                                Server.logger.info("Пользователь '${user.getName()}' не существует")
                                return false
                            }
                        }
                        catch(e : NumberFormatException){
                            Server.logger.error("Неверный формат ввода")
                            return false
                        }
                    }
                }
                if(!flag){
                    val statement = connection.prepareStatement("DELETE FROM users WHERE name = ?")
                    statement.setString(1, user.getName())
                    statement.executeQuery()
                    statement.close()
                    return false
                }
            }
            else{
                println("Пользователь '${user.getName()}' не существует")
                Server.logger.info("Пользователь '${user.getName()}' не существует")
                return false
            }

        }catch (e : PSQLException){
            Server.logger.error("Пользователь '${user.getName()}' не существует")
            return false
        }

        return false
    }


    private fun registration(connection: Connection, user: UserSerialize) : Boolean{
        val statement = connection.prepareStatement("SELECT COUNT(*) FROM users WHERE name = ?")
        statement.setString(1,user.getName())
        val rs = statement.executeQuery()

        while(rs.next()){
            try{
                val cnt = rs.getInt("count")
                if(cnt > 0){
                    println("Пользователь '${user.getName()}' уже существует")
                    Server.logger.info("Пользователь '${user.getName()}' уже существует")
                    return false
                }
                else {
                    val salt = getRandomString(32)
                    val pass = PasswordHasher.hashPassword(user.getPassword(), salt)

                    val st = connection.prepareStatement("INSERT INTO users (name, password) VALUES( ? , ?)")
                    st.setString(1, user.getName())
                    st.setString(2, pass)
                    st.executeUpdate()
                    val saltStatement = connection.prepareStatement("INSERT INTO userssalt (name, salt) VALUES(?, ?)")
                    saltStatement.setString(1, user.getName())
                    saltStatement.setString(2, salt)
                    saltStatement.executeUpdate()
                    println("Пользователь добавлен")
                    println("Регистрация прошла успешно")
                    nameOfUser = user.getName()
                    Server.logger.info("Регистрация прошла успешно")
//                    registrationStatus = true
                    return true

                }
            }catch (_: PSQLException){
                return false
            }
        }
        return false
    }

    private fun checkPerson(connection : Connection, user : UserSerialize) : Boolean{
        val statement = connection.prepareStatement("SELECT COUNT(*) FROM users WHERE name = ?")
        statement.setString(1,user.getName())
        val rs = statement.executeQuery()
        var cnt = 0;

        while(rs.next()){

            cnt = rs.getInt("count")
        }

        return cnt > 0
    }

    private fun getRandomString(length : Int) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        Server.logger.info("Создана рандомная соль")
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")

    }

    private fun asquirePool(){
        semaphore.acquire()
        Server.logger.info("Отрытие доступа для 1 подключения")
    }

    private fun releasePool(){
        semaphore.release()
        Server.logger.info("Убираем подключение")
    }
}