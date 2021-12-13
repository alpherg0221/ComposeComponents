package jp.gr.java_conf.alpherg0221.components.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColors = darkColors(
    primary = Blue200,
    primaryVariant = Blue700,
    secondary = Jade200
)

private val LightColors = lightColors(
    primary = Blue500,
    primaryVariant = Blue700,
    secondary = Jade200
)

@Composable
fun BlueJadeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkColors else LightColors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}