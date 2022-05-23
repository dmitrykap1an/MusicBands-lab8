//package com.example.lab8.server.src.main.kotlin.server.Modules
//
//import dev.shustoff.dikt.Create
//import dev.shustoff.dikt.ProvideSingle
//import dev.shustoff.dikt.UseModules
//import general.commands.*
//import main.resources.commands.*
//import com.example.musicbands.server.src.main.kotlin.server.Managers.CollectionManager
//import server.Managers.CommandManager
//import server.Modules.ModuleOfCollectionManager
//
//
//@UseModules(ModuleOfCollectionManager::class)
//class ModuleOfCommandManager(
//    private val moduleOfCollectionManager: ModuleOfCollectionManager,
//    private val helpCommand: HelpCommand,
//    private val addCommand: AddCommand,
//    private val clearCommand: ClearCommand,
//    private val countCommand: CountCommand,
//    private val historyCommand: HistoryCommand,
//    private val infoCommand: InfoCommand,
//    private val printFieldCommand: PrintFieldCommand,
//    private val removeAllCommand: RemoveAllCommand,
//    private val removeByID: RemoveByID,
//    private val removeFirstCommand: RemoveFirstCommand,
//    private val removeGreaterCommand: RemoveGreaterCommand,
//    private val showCommand: ShowCommand,
//    private val updateIDCommand: UpdateIDCommand,
//    private val exitCommand : ExitCommand,
//) {
//
//    @Create
//    fun commandManager() : CommandManager
//
//    @ProvideSingle
//    private fun collectionManager() : CollectionManager;
//
//
//}