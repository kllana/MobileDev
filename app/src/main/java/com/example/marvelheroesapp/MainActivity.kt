package com.example.marvelheroesapp

import com.example.marvelheroesapp.classes.Hero
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.lifecycleScope
import com.example.marvelheroesapp.classes.ApiKeys
import kotlinx.coroutines.launch
import com.example.marvelheroesapp.classes.ApiResponse

class MainActivity : ComponentActivity() {

    private val heroesState = mutableStateOf<List<Hero>>(emptyList())
    private val hasError = mutableStateOf(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadHeroes()

        setContent {
            MarvelApp(
                heroes = heroesState.value,
                hasError = hasError.value,
                onRetry = ::loadHeroes
            )
        }
    }

    private fun loadHeroes() {
        updateState(isError = false)
        lifecycleScope.launch {
            runCatching {
                val timeStamp = System.currentTimeMillis().toString()
                val hash = generateMD5Hash(
                    "$timeStamp${ApiKeys.PRIVATE_KEY.key}${ApiKeys.PUBLIC_KEY.key}"
                )
                RetrofitInstance.api.getCharacters(
                    apiKey = ApiKeys.PUBLIC_KEY.key,
                    hash = hash,
                    ts = timeStamp
                )
            }.onSuccess { response: retrofit2.Response<ApiResponse> -> // Указание типа явно
                if (response.isSuccessful && response.body() != null) {
                    updateState(heroes = response.body()?.data?.results ?: emptyList())
                } else {
                    updateState(isError = true)
                }
            }.onFailure { _: Throwable -> // Указание типа ошибки (опционально)
                updateState(isError = true)
            }
        }
    }

    private fun updateState(heroes: List<Hero> = heroesState.value, isError: Boolean = hasError.value) {
        heroesState.value = heroes
        hasError.value = isError
    }
}


