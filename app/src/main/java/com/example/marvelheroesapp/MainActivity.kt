package com.example.marvelheroesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.lifecycleScope
import com.example.marvelheroesapp.classes.*
import kotlinx.coroutines.launch
import java.security.MessageDigest

class MainActivity : ComponentActivity() {

    private val heroesState = mutableStateOf(emptyList<HeroForRender>())
    private val hasError = mutableStateOf(false)

    private lateinit var database: AppDatabase
    private lateinit var heroBD: HeroDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        database = AppDatabase.getDatabase(this)
        heroBD = database.heroBD()

        updateHeroes()

        setContent {
            MarvelApp(
                heroes = heroesState.value,
                hasError = hasError.value,
                onRetry = ::updateHeroes
            )
        }
    }

    private fun updateHeroes() {
        hasError.value = false
        lifecycleScope.launch {
            val heroesFromDb = heroBD.getAllHeroes()
            if (heroesFromDb.isNotEmpty()) {
                heroesState.value = heroesFromDb.map(::entityHeroToHeroForRender)
            }
            fetchHeroesAndUpdateDb()
        }
    }
    fun generateMD5Hash(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(input.toByteArray())
        return digest.joinToString("") { "%02x".format(it) }
    }

    private suspend fun fetchHeroesAndUpdateDb() {
        lifecycleScope.launch {
            try {
                val timeStamp = System.currentTimeMillis().toString()
                val response = RetrofitInstance.api.getCharacters(
                    apiKey = ApiKeys.PUBLIC_KEY.key,
                    hash = generateMD5Hash(
                        timeStamp + ApiKeys.PRIVATE_KEY.key + ApiKeys.PUBLIC_KEY.key
                    ),
                    ts = timeStamp
                )
                runCatching {
                    response
                }.onSuccess { _: retrofit2.Response<ApiResponse> ->
                    if (response.isSuccessful && response.body() != null) {
                        val heroes = response.body()?.data?.results ?: emptyList()

                        val heroEntities = heroes.map { heroToEntityHero(it) }
                        val uiHeroes = heroes.map { heroToHeroForRender(it) }

                        heroBD.deleteAllHeroes()
                        heroBD.insertHeroes(heroEntities)

                        if (heroesState.value.isEmpty()) {
                            heroesState.value = uiHeroes
                        }
                    } else {
                        if (heroesState.value.isEmpty()) {
                            hasError.value = true
                        }
                    }
                }.onFailure { _: Throwable ->
                    if (heroesState.value.isEmpty()) {
                        hasError.value = true
                    }
                }
            } catch (e: Exception) {
                if (heroesState.value.isEmpty()) {
                    hasError.value = true
                }
            }
        }
    }


    private fun saveHeroesToDb(heroes: List<Hero>) {
        lifecycleScope.launch {
            val heroEntities = heroes.map(::heroToEntityHero)
            heroBD.run {
                deleteAllHeroes()
                insertHeroes(heroEntities)
            }
        }
    }

    private fun handleFetchError() {
        if (heroesState.value.isEmpty()) {
            hasError.value = true
        }
    }
}

