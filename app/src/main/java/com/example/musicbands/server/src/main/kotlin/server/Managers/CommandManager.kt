package server.Managers

import com.example.lab8.client.serialize.AnswerSerialize
import com.example.lab8.client.serialize.CommandSerialize
import com.example.musicbands.general.src.main.kotlin.general.commands.AddCommand
import com.example.musicbands.general.src.main.kotlin.general.commands.ClearCommand
import com.example.musicbands.server.src.main.kotlin.server.Managers.CollectionManager
import general.Exceptions.CommandException
import general.Exceptions.RecursiveException
import general.commands.*
import main.resources.commands.*
import com.example.musicbands.server.src.main.kotlin.server.serverWork.Server
import java.io.*
import java.util.concurrent.locks.ReentrantReadWriteLock


/**
 * Класс для работы с командами, введенными пользователем
 * Хранит все команды и историю последних 6 введенных команд
 */
class CommandManager(
    private val helpCommand: HelpCommand,
    private val addCommand: AddCommand,
    private val clearCommand: ClearCommand,
    private val countCommand: CountCommand,
    private val historyCommand: HistoryCommand,
    private val infoCommand: InfoCommand,
    private val printFieldCommand: PrintFieldCommand,
    private val removeAllCommand: RemoveAllCommand,
    private val removeByID: RemoveByID,
    private val removeFirstCommand: RemoveFirstCommand,
    private val removeGreaterCommand: RemoveGreaterCommand,
    private val showCommand: ShowCommand,
    private val updateIDCommand: UpdateIDCommand,
    private val exitCommand : ExitCommand,
    private val collectionManager: CollectionManager,
) {

    private val MAXLENGTH = 6;
    private var commands : MutableList<Command> = mutableListOf();
    private var commandsHistory : MutableList<String> = mutableListOf();
    private val readWriteLock = ReentrantReadWriteLock()
    companion object{
        var scriptMode = false;
        lateinit var bufferedReader : BufferedReader;
    }


    init {
        commands.add(helpCommand)
        commands.add(addCommand)
        commands.add(clearCommand)
        commands.add(countCommand)
        commands.add(historyCommand)
        commands.add(infoCommand)
        commands.add(printFieldCommand)
        commands.add(removeAllCommand)
        commands.add(removeByID)
        commands.add(removeFirstCommand)
        commands.add(removeGreaterCommand)
        commands.add(showCommand)
        commands.add(updateIDCommand)
        commands.add(exitCommand)
    }


    fun addToHistory(command : String, nameOfUser : String){
        readWriteLock.writeLock().lock()

        if(commandsHistory.size == 6) {

            commandsHistory = commandsHistory.subList(1, MAXLENGTH)
            commandsHistory.add("$command : $nameOfUser");

        }
        else commandsHistory.add("$command : $nameOfUser");

        readWriteLock.writeLock().unlock()

    }

    private fun help() : AnswerSerialize {

        val result = StringBuilder()
        for(i in commands.indices){

            result.append(commands[i].toString() + "\n")

        }
        return AnswerSerialize(result.toString())
    }


    @Synchronized
    fun launchCommand(userCommand: CommandSerialize, owner : String) : AnswerSerialize {

        when{

            userCommand.getNameCommand() == "help"-> return help()

            userCommand.getNameCommand() == "info" ->  return collectionManager.info()

            userCommand.getNameCommand() == "show" ->  return collectionManager.show()

            userCommand.getNameCommand() == "add" -> return collectionManager.add(userCommand.getMusicBand(), owner = owner)

            userCommand.getNameCommand() == "update" -> return collectionManager.update(userCommand.getCommandArgument()!!, userCommand.getMusicBand(), owner = owner)

            userCommand.getNameCommand() == "remove_by_id" -> return collectionManager.remove(userCommand.getCommandArgument()!!, owner)

            userCommand.getNameCommand() == "clear" -> return collectionManager.clear(owner)

//            userCommand.getNameCommand() == "execute_script" -> return executeScript(userCommand.getCommandArgument()!!);


            userCommand.getNameCommand() == "exit" -> {

                Server.logger.info("Клиент завершил работу")
//                save();
                return AnswerSerialize("Программа завершена")
            }

            userCommand.getNameCommand() == "remove_first" -> return collectionManager.removeFirst(owner)

            userCommand.getNameCommand() == "remove_greater" -> return collectionManager.removeGreater(userCommand.getCommandArgument()!!, owner);

            userCommand.getNameCommand() == "history" -> return history();

            userCommand.getNameCommand() == "remove_all_by_description" -> return collectionManager.removeAllByDescription(userCommand.getCommandArgument()!!, owner);

            userCommand.getNameCommand() == "count_less_than_number_of_participants" -> return collectionManager.countLessThan(userCommand.getCommandArgument()!!);

            userCommand.getNameCommand() == "print_field_descending_front_man" -> return collectionManager.printlnFrontManDescending();

            else -> {
                Server.logger.info("CommandManager : Команда не обнаружена");
                return AnswerSerialize("Команда не найдена")
            }


        }
    }
    private fun executeScript(fileName: String, owner : String): String? {
        CommandManager.scriptMode = true
        return try {
            val file = File(fileName)
            val fileReader = FileReader(file)
            bufferedReader = BufferedReader(fileReader)
            var line: String = bufferedReader.readLine()
            val result = StringBuilder()
            while (line != null) {
                try {
                    val userCommand = line.split(" ".toRegex()).dropLastWhile { it.isEmpty() }
                        .toTypedArray()

                    if (userCommand.size > 2) throw CommandException()
                    if (userCommand[0] == "execute_script" && userCommand[1] == fileName) {
                        throw RecursiveException()
                    }
                    val command = CommandSerialize(userCommand[0], userCommand[1])
                    result.append(launchCommand(command, owner)).append("\n")
                    line = bufferedReader.readLine()
                } catch (e: CommandException) {
                    result.append("Команда не найдена").append("\n")
                } catch (e: NullPointerException) {
                    result.append("Ошибка ввода").append("\n")
                } catch (e: RecursiveException) {
                    return result.toString() + "Ошибка : файл рекурсивен"
                }
            }
            scriptMode = false
            result.toString()
        } catch (e: FileNotFoundException) {
            "Файл не найден"
        } catch (e: IOException) {
            "Ошибка"
        }
    }

    private fun history() : AnswerSerialize {

        val result = StringBuilder()
        commandsHistory.forEach{
            result.append(it + "\n");
        }
        return AnswerSerialize(result.toString())

    }

}