package com.example.musicbands.server.src.main.kotlin.server.serverWork

import com.example.lab8.client.serialize.AnswerSerialize
import java.io.ObjectOutputStream
import java.util.concurrent.Callable

class ObjectWriter : Callable<Boolean> {

    private val outt : ObjectOutputStream;
    private val answer: AnswerSerialize;

    constructor(outt : ObjectOutputStream, answer : AnswerSerialize){
        this.outt = outt;
        this.answer = answer
    }

    override fun call(): Boolean {
        outt.writeObject(answer)
        outt.flush()
        return true
    }

}