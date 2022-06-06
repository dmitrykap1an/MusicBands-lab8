package com.example.musicbands.client.managers

import com.example.lab8.client.data.*
import com.example.musicbands.client.exceptions.EmptyArgumentException
import com.example.musicbands.client.exceptions.IllegalValueException
import com.example.musicbands.client.data.Coordinates
import com.example.musicbands.client.data.MusicBand
import com.example.musicbands.client.data.Person

/**
     *  Класс для ввода данных о музыкальной группе
     */
class CheckData{

    private val MAX_X = 220
    private val MIN_HEIGHT = 1;

    fun checkX(strX: String): Pair<Long , String>{
        val x: Long;

        return try {
            x = strX.toLong();
            if(x > MAX_X) throw IllegalValueException();
            Pair(x, "OK")
        } catch (e : NoSuchElementException) {
            Pair(0,"Координата X не распознана!")
        } catch (e : NumberFormatException) {
            Pair(0,"Координата X должна быть представлена числом!")
        } catch (e : NullPointerException) {
            Pair(0,"Непредвиденная ошибка!")
        }catch (e : IllegalValueException){
            Pair(0,"Значение больше, чем $MAX_X!")
        } catch (e : IllegalStateException) {
            Pair(0,"Непредвиденная ошибка!")
        }
    }

    fun checkY(strY: String): Pair<Double, String>{

        val y: Double
        return try {
            y = strY.toDouble();
            Pair(y, "OK")
        } catch (e : NoSuchElementException) {
            Pair(0.0,"Координата Y не распознана!")
        } catch (e : NumberFormatException) {
            Pair(0.0,"Координата Y должна быть представлена числом!")
        } catch (e : NullPointerException) {
            Pair(0.0,"Непредвиденная ошибка!")
        } catch (exception: IllegalStateException) {
            Pair(0.0,"Непредвиденная ошибка!")
        }
    }

    fun checkNumberOfParticipants(strNumber: String) : Pair<Long, String>{

        val number : Long;
            return try {
                number = strNumber.toLong();
                if(number < MIN_HEIGHT) throw IllegalValueException()
                Pair(number, "OK")
            } catch (e : NoSuchElementException) {
                Pair(0,"Введите количество участников не распознано!")
            } catch (e : NumberFormatException) {
                Pair(0, "Введите количество участников должно быть представлено числом!")
            }catch (e : IllegalValueException){
                Pair(0,"Участников должно быть не меньше, чем $MIN_HEIGHT")
            } catch (e : NullPointerException) {
                Pair(0,"Непредвиденная ошибка!")
            } catch (e : IllegalStateException) {
                Pair(0,"Непредвиденная ошибка!")
            }
    }

    fun checkMusicGenre(strGenre: String): Pair<MusicGenre?, String> {
        val genre: MusicGenre;
            return try {
                genre = MusicGenre.valueOf(strGenre.uppercase());
                Pair(genre, "OK")
            } catch (e : NoSuchElementException) {
                Pair(null,"Музыкальный жанр не распознан!")
            } catch (e : IllegalArgumentException) {
                Pair(null, "Музыкального жанра нет в списке(${MusicGenre.toListString()}")
            } catch (e : IllegalStateException) {
                Pair(null, "Непредвиденная ошибка!")
            }
    }

    fun checkHeight(strHeight: String) : Pair<Int, String>{
        val height : Int;

            return try {
                height = strHeight.toInt();
                if(height < MIN_HEIGHT) throw IllegalValueException()
                Pair(height, "OK")
            } catch (e : NoSuchElementException) {
                Pair(0,"Рост не распознан!")
            } catch (e : NumberFormatException) {
                Pair(0,"Рост должен быть представлен числом!")
            }catch (e : IllegalValueException){
                Pair(0,"Рост должен быть не меньше, чем $MIN_HEIGHT")
            } catch (e : NullPointerException) {
                Pair(0,"Непредвиденная ошибка!")
            } catch (exception: IllegalStateException) {
                Pair(0,"Непредвиденная ошибка!")
            }
    }

    fun checkX2(strX: String): Pair<Long, String> {
        val x: Long;

            return try {
                x = strX.toLong();
                Pair(x, "OK")
            } catch (e : NoSuchElementException) {
                Pair(0,"Координата X не распознана!")
            } catch (e : NumberFormatException){
                Pair(0,"Координата X должна быть представлена числом!")
            } catch (e : NullPointerException) {
                Pair(0,"Непредвиденная ошибка!")
            } catch (e : IllegalStateException) {
                Pair(0,"Непредвиденная ошибка!")
            }
    }


    fun checkY2(strY: String) : Pair<Int, String>{

        val y : Int
            return try {
                y = strY.toInt();
                Pair(y, "OK")
            } catch (e : NoSuchElementException) {
                 Pair(0,"Координата Y не распознана!")
            } catch (e : NumberFormatException) {
                Pair(0,"Координата Y должна быть представлена числом!")
            } catch (exception: IllegalStateException) {
                Pair(0,"Непредвиденная ошибка!")
            }
        }

    fun checkZ(strZ: String): Pair<Long, String>{

        val z : Long;
            return try {
                z = strZ.toLong();
                Pair(0, "OK")
            } catch (e : NoSuchElementException) {
                Pair(0,"Координата Z не распознана!")
            } catch (e : NumberFormatException) {
                Pair(0,"Координата Z должна быть представлена числом!")
            } catch (e : NullPointerException) {
                Pair(0,"Непредвиденная ошибка!")
            } catch (exception: IllegalStateException) {
                Pair(0,"Непредвиденная ошибка!")
            }
    }

}