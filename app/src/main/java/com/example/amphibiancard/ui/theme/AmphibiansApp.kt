package com.example.amphibiancard.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun AmphibiansAppTheme(content: @Composable () -> Unit) {
    val colorScheme = lightColorScheme(
        primary = Purple500,
        secondary = Purple700,
        background = Color.White
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
