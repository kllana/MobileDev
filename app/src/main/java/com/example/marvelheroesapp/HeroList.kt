package com.example.marvelheroesapp

import com.example.marvelheroesapp.classes.Hero
import com.example.marvelheroesapp.screens.FallbackScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun HeroListScreen(heroes: List<Hero>,
    hasError: Boolean,
    onHeroClick: (Hero) -> Unit,
    onRetry: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.ic_main_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = rememberAsyncImagePainter("https://iili.io/JMnuvbp.png"),
                contentDescription = stringResource(id = R.string.marvel_logo),
                modifier = Modifier.padding(bottom = 25.dp)
            )

            Text(text = stringResource(id = R.string.title),
                style = TextStyle(
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier.padding(bottom = 25.dp)
            )

            if (hasError) {
                FallbackScreen(onRetry = onRetry)
            } else {
                HeroList(heroes = heroes, onHeroClick = onHeroClick)
            }
        }
    }
}

@Composable
fun HeroList(heroes: List<Hero>,
    onHeroClick: (Hero) -> Unit
) {
    val lazyListState = rememberLazyListState()

    LazyRow(state = lazyListState,
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 30.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(heroes) { hero ->
            HeroCard(hero = hero, onClick = { onHeroClick(hero) })
        }
    }
}
