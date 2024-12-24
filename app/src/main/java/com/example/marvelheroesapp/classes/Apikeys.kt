package com.example.marvelheroesapp.classes

class ApiKeys {
    companion object {
        val PUBLIC_KEY = ApiKey("667589ace47e0bca9ed84e4038878534")
        val PRIVATE_KEY = ApiKey("e755b49b1291078478bac1d26458f9cb5d356f62")
    }

    class ApiKey(val key: String)
}
