package com.example.marvelheroesapp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
@Composable
fun CustomBackground() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(
            color = Color.hsl(300f, 0.05f, 0.16f, 1f),
            size = size
        )

        val path = Path().apply {
            moveTo(size.width, size.height)
            lineTo(size.width * 0f, size.height)
            lineTo(size.width, size.height * 0.4f)
            close()
        }

        drawPath(
            path = path,
            color = Color.hsl(359f, 0.76f, 0.34f, 1f),
            style = Fill
        )
    }
}
