package com.example.scoutdraft3.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val dPrimary  = Color(0xfffabd00)
val dOnPrimary = Color(0xFF3f2e00)
val dPrimaryContainer = Color(0xFF5b4300)

val dSecondary = Color(0xFFF463FF)
val dOnSecondary = Color(0xFF633D66)
val dSecondaryContainer = Color(0xFF6a3c00)

//val dTertiary = Color(0xFFffb2bc)
//val dOnTertiary = Color(0xFF670023)
//val dTertiaryContainer = Color(0xFF8e0935)
//val dOnTertiaryContainer = Color(0xFFffd9dd)

val dBackGround = Color(0xFF86796B)
val dOnBackGround = Color(0xFFe9e1d8)
val dSurface = Color(0xfffabd00)
val dOnSurface = Color(0xFF3f2e00)

val dError = Color(0xffffb4ab)
val dOnError = Color(0xFF690005)
//val dErrorContainer = Color(0xFF93000a)
//val dOnErrorContainer = Color(0xFFffdad6)


private val DarkColorPalette = darkColors(
        primary = dPrimary,
        primaryVariant = dPrimaryContainer,
        secondary = dSecondary,
        secondaryVariant = dSecondaryContainer,
        background = dBackGround,
        surface = dSurface,
        error = dError,
        onPrimary = dOnPrimary,
        onSecondary = dOnSecondary,
        onBackground = dOnBackGround,
        onSurface = dOnSurface,
        onError = dOnError
)
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */


@Composable
fun ScoutDraft3Theme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = DarkColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
