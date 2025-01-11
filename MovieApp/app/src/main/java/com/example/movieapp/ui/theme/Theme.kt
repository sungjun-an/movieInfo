package com.example.movieapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.movieapp.ui.config.ComponentConfig
import com.example.movieapp.ui.config.DefaultComponentConfig
import com.example.movieapp.ui.theme.color.ColorSet
import com.example.movieapp.ui.theme.color.MyColors

private val LocalColors = staticCompositionLocalOf { ColorSet.Red.LightColors }

@Composable
fun MovieAppTheme(
    themeState: State<ComponentConfig> = mutableStateOf(DefaultComponentConfig.RED_THEME),
    content: @Composable () -> Unit
) {
    val myTheme by remember { themeState }

    val colors = if (myTheme.isDarkTheme) {
        myTheme.colors.DarkColors
    } else {
        myTheme.colors.LightColors
    }

    CompositionLocalProvider(LocalColors provides colors) {
        MaterialTheme(
            colorScheme = colors.material,
            typography = myTheme.typography,
            shapes = myTheme.shapes,
            content = content
        )
    }
}

val MaterialTheme.colorSchema: MyColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current