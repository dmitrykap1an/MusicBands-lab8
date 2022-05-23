package com.example.musicbands.server.src.main.kotlin.server

import com.example.musicbands.client.managers.InputData
import com.example.musicbands.general.src.main.kotlin.general.commands.AddCommand
import com.example.musicbands.general.src.main.kotlin.general.commands.ClearCommand
import general.commands.*
import main.resources.commands.*
import com.example.musicbands.server.src.main.kotlin.server.Managers.DatabaseConnection
import com.example.musicbands.server.src.main.kotlin.server.Database.PostgresDao
import com.example.musicbands.server.src.main.kotlin.server.Managers.CollectionManager
import server.Managers.CommandManager
import com.example.musicbands.server.src.main.kotlin.server.serverWork.Server
import java.io.FileReader
import java.util.Properties


fun main(){

    /**
     * @author Dmitry Kaplan P3112 and
     * Лабораторная работа №8 по программированию
     * Главная функция, которая вызывает Server
     */

    val properties = Properties()
    val file = FileReader("/home/newton/IdeaProjects/lab6-master/server/src/main/kotlin/server/databaseInfo.properties")
    properties.load(file)

    val databaseConnection = DatabaseConnection(properties);
//    val moduleOfPostgresDao = ModuleOfPostgresDao(databaseConnection)
//    val moduleOfCollectionManager = ModuleOfCollectionManager(moduleOfPostgresDao)
    val postgresDao = PostgresDao(databaseConnection)
    val collectionManager = CollectionManager(InputData(), postgresDao)
    val commandManager = CommandManager(
        HelpCommand(),
        AddCommand(),
        ClearCommand(),
        CountCommand(),
        HistoryCommand(),
        InfoCommand(),
        PrintFieldCommand(),
        RemoveAllCommand(),
        RemoveByID(),
        RemoveFirstCommand(),
        RemoveGreaterCommand(),
        ShowCommand(),
        UpdateIDCommand(),
        ExitCommand(),
        collectionManager
    )
//    val moduleOfCommandManager = ModuleOfCommandManager(
//        moduleOfCollectionManager,
//        HelpCommand(),
//        AddCommand(),
//        ClearCommand(),
//        CountCommand(),
//        HistoryCommand(),
//        InfoCommand(),
//        PrintFieldCommand(),
//        RemoveAllCommand(),
//        RemoveByID(),
//        RemoveFirstCommand(),
//        RemoveGreaterCommand(),
//        ShowCommand(),
//        UpdateIDCommand(),
//        ExitCommand()
//    )
//    val commandManager = moduleOfCommandManager.commandManager()
  val server =  Server(commandManager, 29009)
    server.run()
}



