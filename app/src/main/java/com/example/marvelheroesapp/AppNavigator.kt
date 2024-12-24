package com.example.marvelheroesapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marvelheroesapp.classes.HeroForRender
import com.example.marvelheroesapp.screens.HeroDetailScreen
import com.example.marvelheroesapp.screens.HeroListScreen


@Composable
fun MarvelApp(heroes: List<HeroForRender>, hasError: Boolean, onRetry: () -> Unit) {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "hero_list"
        ) {
            composable("hero_list") {
                HeroListScreen(
                    heroes = heroes,
                    hasError = hasError,
                    onHeroClick = { hero ->
                        navController.navigate("hero_detail/${hero.id}")
                    },
                    onRetry = onRetry,
                )
            }
            composable("hero_detail/{heroId}") { backStackEntry ->
                val heroId = backStackEntry.arguments?.getString("heroId")?.toIntOrNull()
                if (heroId != null) {
                    HeroDetailScreen(
                        heroId = heroId,
                        onBackClick = { navController.popBackStack() },
                    )
                }
            }
        }
    }
}