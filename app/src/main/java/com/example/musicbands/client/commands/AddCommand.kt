package com.example.musicbands.client.commands

import main.resources.commands.Command


/**
 * Класс, представляющий собой команду, которая
 * добавляет новый элемент в коллекцию
 */
class AddCommand : Command {


    constructor()
            : super("add", "добавляет новый элемент в коллекцию(данные о элементе вводятся с новой строки)"){


    }

}