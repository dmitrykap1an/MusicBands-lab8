package com.example.musicbands.client.exceptions

class FileNotTxt : Exception() {

    override fun toString(): String {

        return "файл неверного формата"

    }
}