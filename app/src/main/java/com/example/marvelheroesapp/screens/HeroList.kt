package com.example.marvelheroesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.marvelheroesapp.CustomBackground
import com.example.marvelheroesapp.HeroCard
import com.example.marvelheroesapp.R
import com.example.marvelheroesapp.classes.Hero

@Composable
fun HeroListScreen(
    heroes: List<Hero>,
    onHeroSelected: (Hero) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        CustomBackground()

        Column(
            modifier = Modifier
                .padding(vertical = 30.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MarvelLogo()
            Spacer(Modifier.height(25.dp))
            HeaderText()
            Spacer(Modifier.height(25.dp))
            HeroCarousel(heroes = heroes, onHeroClick = onHeroSelected)
        }
    }
}

@Composable
fun MarvelLogo() {
    Image(
        painter = rememberAsyncImagePainter(model = "https://iili.io/JMnuvbp.png"),
        contentDescription = stringResource(id = R.string.marvel_logo),
        modifier = Modifier.size(150.dp)
    )
}

@Composable
fun HeaderText() {
    Text(
        text = stringResource(id = R.string.choose_your_hero),
        style = TextStyle(
            fontSize = 28.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun HeroCarousel(
    heroes: List<Hero>,
    onHeroClick: (Hero) -> Unit
) {
    val listState = rememberLazyListState()
    val flingBehavior = rememberSnapFlingBehavior(
        lazyListState = listState,
        snapPosition = SnapPosition.Center
    )

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        state = listState,
        flingBehavior = flingBehavior,
        contentPadding = PaddingValues(horizontal = 30.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(heroes) { hero ->
            HeroCard(hero = hero, onClick = { onHeroClick(hero) })
        }
    }
}

@Composable
fun HeroPagerItem(hero: Hero, onItemClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .width(350.dp)
            .fillMaxHeight()
            .clickable(onClick = onItemClicked)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = hero.imageUrl),
            contentDescription = hero.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.9f)
                .clip(RoundedCornerShape(5.dp))
        )

        Text(
            text = hero.name,
            style = TextStyle(
                fontSize = 32.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 28.dp, bottom = 60.dp)
        )
    }
}
