package com.example.lab8.client.managers

import com.example.lab8.client.serialize.UserSerialize

class AuthManager {

    companion object {
        fun handle(): UserSerialize {
            return when(Asker.askQuestion("Вы уже зарегестрированы в системе?")){

                true -> UserSerialize(TypeOfAuth.Registered, Asker.askLogin(), Asker.askPassword())

                else -> UserSerialize(TypeOfAuth.NotRegistered, Asker.askLogin(), Asker.askPassword())
            }

        }
    }
}
