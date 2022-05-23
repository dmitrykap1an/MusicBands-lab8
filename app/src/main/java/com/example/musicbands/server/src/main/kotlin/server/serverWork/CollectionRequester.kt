package com.example.musicbands.server.src.main.kotlin.server.serverWork

import com.example.lab8.client.serialize.AnswerSerialize
import com.example.lab8.client.serialize.CommandSerialize
import server.Managers.CommandManager
import java.util.concurrent.Callable

class CollectionRequester : Callable<AnswerSerialize> {
    private val commandManager : CommandManager
    private val command : CommandSerialize
    private val nameOfPerson : String;

    constructor(commandManager: CommandManager, command : CommandSerialize, nameOfPerson : String){
        this.commandManager = commandManager
        this.command = command
        this.nameOfPerson = nameOfPerson
    }

    override fun call(): AnswerSerialize {
        return commandManager.launchCommand(command, nameOfPerson)
    }
}