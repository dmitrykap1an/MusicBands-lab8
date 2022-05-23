package com.example.musicbands.server.src.main.kotlin.server.Managers

import com.example.musicbands.client.data.MusicBand
import com.example.lab8.client.exceptions.EmptyArgumentException
import com.example.musicbands.client.managers.InputData
import com.example.lab8.client.serialize.AnswerSerialize
import com.example.musicbands.server.src.main.kotlin.server.Database.PostgresDao
import com.example.musicbands.server.src.main.kotlin.server.serverWork.Server
import java.lang.Math.max
import java.time.LocalDateTime
import java.util.*
import java.util.concurrent.locks.ReentrantReadWriteLock

/**
 * Класс для работы с коллекцией музыкальных групп
 * @param lastSaveTime время последнего сохранения коллекции в файл
 * @param lastInitTime время последнего создания элемента коллекции
 */
class CollectionManager {

    private var collectionOfMusicBands: MutableList<MusicBand> = LinkedList()
    private lateinit var lastSaveTime: LocalDateTime;
    private lateinit var lastInitTime: LocalDateTime;
    private val inputData : InputData;
    private val postgresDao : PostgresDao
    private val readWriteLock = ReentrantReadWriteLock(false)


    constructor(inputData: InputData, postgresDao: PostgresDao){

        this.inputData = inputData
        this.postgresDao = postgresDao
        addMusicBandsToCollection();

    }

//
//    init{
//        addFileCommandsToCollection()
//    }

    fun update(id: String, musicBand: MusicBand?, list: List<String> = listOf(), owner : String) : AnswerSerialize {
        readWriteLock.writeLock().lock()
        try {

            if(postgresDao.update(id, musicBand, owner)){
                val newId = id.toInt()
                if(newId > collectionOfMusicBands.size || newId < 0){


                } else {
                    for (i in collectionOfMusicBands.indices) {

                        if (collectionOfMusicBands[i].id == newId) {

                            if (list.isEmpty()) {

                                collectionOfMusicBands[i] = musicBand!!;
                                break;

                            } else {

                                val localParam = inputData.askMusicBand(list)
                                if (localParam != null)
                                    collectionOfMusicBands[i] = localParam;
                            };

                            collectionOfMusicBands.stream().sorted(compareBy { it.name })

                        }
                    }

                }
            }

            else return AnswerSerialize("Не удалось обновавить элемент")
        } catch (e : NumberFormatException) {
            return AnswerSerialize("Данная строка не является числом")
        }catch (e : IllegalArgumentException) {
            return AnswerSerialize("Данная строка не является числом")
        }catch (e : NullPointerException){
                return AnswerSerialize("Ошибка : Команда не выполнена")
        }
        finally {
            readWriteLock.writeLock().unlock()
        }
        return AnswerSerialize("Команда update выполнена")
    }

    private fun addMusicBandsToCollection(){


        val collection = postgresDao.addMusicBandsToCollection()
        var mx = 0;
        collection.forEach {
            mx = max(it.id, mx)
            collectionOfMusicBands.add(it)
        }
        MusicBand.setId(mx + 1)
        collectionOfMusicBands.stream().sorted(compareBy { it.name });
        lastInitTime = LocalDateTime.now();


    }

    fun info() : AnswerSerialize {

        Server.logger.info("Выполнение команды info")
        try {
                return AnswerSerialize("Date of init : $lastInitTime\n" +
                        "Date of last save : $lastSaveTime\n" +
                        "Type : ${collectionOfMusicBands::class.simpleName}\n" +
                        "Count of elements : ${collectionOfMusicBands.size}\n")


        }
        catch (e : UninitializedPropertyAccessException){

            try{
                   return AnswerSerialize("Date of init : $lastInitTime\n" +
                            "Date of last save : the collection wasn't saved to a file\n" +
                            "Type : ${collectionOfMusicBands::class.simpleName}\n" +
                            "Count of elements : ${collectionOfMusicBands.size}\n")


            }
            catch (e : UninitializedPropertyAccessException){


                   return AnswerSerialize("Date of init : the collection is empty\n" +
                            "Date of last save : the collection wasn't saved to a file\n" +
                            "Type : ${collectionOfMusicBands::class.simpleName}\n" +
                            "Count of elements : ${collectionOfMusicBands.size}\n")
            }

        }
    }

    fun show() : AnswerSerialize {

        val result = StringBuilder()
        Server.logger.info("Выполнение команды show")
        return if (collectionOfMusicBands.size > 0) {
            collectionOfMusicBands.stream().forEach {
                result.append(it.toString() + "\n" + "\n")
            }

            AnswerSerialize(result.toString())
        } else {
            AnswerSerialize("Коллекция пустая")
        }


    }

    fun add(command : MusicBand?, list : List<String> = listOf(), owner: String) : AnswerSerialize {
        try {
            readWriteLock.writeLock().lock()
            Server.logger.info("Выполнение команды add")
            val musicBand: MusicBand? = command ?: inputData.askMusicBand(list);
            return if (postgresDao.add(musicBand, owner)) {
                if (musicBand != null)
                    collectionOfMusicBands.add(musicBand);
                collectionOfMusicBands.stream().sorted(compareBy { it.name })
                lastInitTime = LocalDateTime.now();

                AnswerSerialize("")
            } else AnswerSerialize("Ошибка добавления музыльной группы")
        }
        finally {
            readWriteLock.writeLock().unlock()
        }

    }

    fun clear(owner : String) : AnswerSerialize {

        if(postgresDao.clear(owner)) {
            Server.logger.info("Выполнение команды clear")
            collectionOfMusicBands.clear();
            return AnswerSerialize("Коллекция очищена")
        }
        else return AnswerSerialize("Ошибка удаления элементов")

    }

    fun remove(id : String, owner: String) : AnswerSerialize {

        try {
            if(postgresDao.remove(id, owner)) {
                Server.logger.info("Выполнение команды remove_by_id ")
                val newId = id.toInt()
                if (newId <= collectionOfMusicBands.size) {

                    for (i in collectionOfMusicBands.indices) {

                        if (collectionOfMusicBands[i].id == newId) {

                            collectionOfMusicBands.remove(collectionOfMusicBands[i])
                            break;
                        }

                        if (i == collectionOfMusicBands.size - 1) return AnswerSerialize("Id не найден")
                    }
                } else return AnswerSerialize("Id не найден")
            }else return AnswerSerialize("Ошибка удаления элемента по Id")

        } catch (e : NumberFormatException){
            return AnswerSerialize("Данная строка не является числом")
        }catch (e : IllegalArgumentException){
            return AnswerSerialize("Данная строка не является числом")
        }
        return AnswerSerialize("Элемент удален")

    }

//    fun save() : AnswerSerialize {
//
//        Server.logger.info("Выполнение команды save")
//        fileManager.collectionWriter(collectionOfMusicBands);
//        lastSaveTime = LocalDateTime.now();
//        return AnswerSerialize("Коллекция сохранена")
//
//
//    }


    fun removeFirst(owner: String) : AnswerSerialize {

        return if(postgresDao.removeFirst(owner)){
            Server.logger.info("Выполнение команды remove_first")
            if(collectionOfMusicBands.size > 0) {

                collectionOfMusicBands.remove(collectionOfMusicBands[0]);
                AnswerSerialize("Первый элемент удален")
            } else {
                AnswerSerialize("Невозможно удалить первый элемент - коллекция пуста")
            }
        } else AnswerSerialize("Удаление первого элемента невозможно")

    }

    fun removeAllByDescription(description : String, owner: String) : AnswerSerialize {

        Server.logger.info("Выполнение команды remove_all_by_description")
        var cnt = 0;

        if (postgresDao.removeAllByDescription(description, owner)) {
            for (i in collectionOfMusicBands.indices) {

                if (collectionOfMusicBands[i].description == description) {

                    collectionOfMusicBands.remove(collectionOfMusicBands[i]);
                    cnt++

                }
            }

            return when {

                cnt == 0 -> AnswerSerialize("Элемент по описанию не найден")

                cnt == 1 -> AnswerSerialize("Элемент удален")

                cnt >= 2 -> AnswerSerialize("Элементы удалены")

                else -> AnswerSerialize("Элемент по описанию не найден")

            }
        }
        else return AnswerSerialize("Ошибка удаления всех элементов по описанию")
    }


    fun removeGreater(name : String, owner: String) : AnswerSerialize {

        Server.logger.info("Выполнение команды remove_greater")
        var message : String = ""
        try {
            if (postgresDao.removeGreater(name, owner)) {

                if (collectionOfMusicBands.isEmpty()) throw EmptyArgumentException()

                for (i in collectionOfMusicBands.indices) {

                    if (collectionOfMusicBands[i].name == name) {

                        collectionOfMusicBands = collectionOfMusicBands.subList(0, i + 1);
                        message = ("Элемент(ы) удален(ы)")
                        break;
                    }

                    if (i == collectionOfMusicBands.size - 1) message = "Элемент не найден"
                }
            }
            else return AnswerSerialize("Удаление элементов больше данного невозможно")

            } catch (e : EmptyArgumentException) {
                return AnswerSerialize("Имя не найдено")
            }

        return AnswerSerialize(message)
    }



    fun countLessThan(numberOfParticipants : String) : AnswerSerialize {

        Server.logger.info("Выполнение команды count_less_than_number_of_participants numberOfParticipants")
        try {

            val newNumber = numberOfParticipants.toLong();
            var cnt = 0;
            for(i in collectionOfMusicBands.indices){

                if(collectionOfMusicBands[i].numberOfParticipants < newNumber){

                    cnt++;
                }
            }
            return AnswerSerialize(cnt.toString())
        }catch (e : NumberFormatException){
            return AnswerSerialize("Данная строка не является числом")
        }catch (e : IllegalArgumentException){
            return AnswerSerialize("Данная строка не является числом")
        }
    }

    fun printlnFrontManDescending() : AnswerSerialize {

        val result = StringBuilder()
        Server.logger.info("Выполнение команды print_field_descending_front_man")
        val newCollection = collectionOfMusicBands.asReversed();
        for(i in newCollection.indices){

            result.append(newCollection[i].frontMan.toString() + "\n")

        }

        return AnswerSerialize(result.toString())
    }


}