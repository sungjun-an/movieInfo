package com.example.movieapp.ui.theme.color

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val Red200 = Color(0xFFFFAAAA)
val Red300 = Color(0xFFCC5942)
val Red400 = Color(0xFFFF5282)
val Red700 = Color(0xFFEC0000)
val Red800 = Color(0xFFAF0000)
val Red900 = Color(0xFF531F1C)
val Purple200 = Color(0xFF908499)
val Purple400 = Color(0xFF6D59FF)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF635270)
val Purple900 = Color(0xFF200833)
val Green400 = Color(0xFF55D800)
val Blue400 = Color(0xFF395DE8)
val Grey200 = Color(0xFF908499)
val Grey400 = Color(0xFF151515)
val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)

sealed class ColorSet {
    open lateinit var LightColors: MyColors
    open lateinit var DarkColors: MyColors
    object Red: ColorSet(){
        override var LightColors: MyColors = MyColors(
            material = lightColorScheme(
                primary = Red700,
                onPrimary = White,
                primaryContainer = Red800,
                secondary = Purple900,
                secondaryContainer = Purple700,
                surface = White,
                onSurface = Black,
                background = White,
                onBackground = Black,
                error = Red400
            ),
            success = Green400,
            disabledSecondary = Grey200,
            textFiledBackground = Grey200
        )
        override var DarkColors: MyColors = MyColors(
            material = darkColorScheme(
                primary = Purple900,
                onPrimary = White,
                primaryContainer = Red800,
                secondary = Purple900,
                secondaryContainer = Purple700,
                surface = White,
                onSurface = Black,
                background = White,
                onBackground = Black,
                error = Red400
            )
        )
    }

    object Blue: ColorSet(){
        override var LightColors: MyColors = MyColors(
            material = lightColorScheme(
                primary = Blue400,
                onPrimary = White,
                primaryContainer = Purple400,
                secondary = Red900,
                secondaryContainer = Red700,
                surface = White,
                onSurface = Purple900,
                background = White,
                onBackground = Purple900,
                error = Red400
            ),
            success = Green400,
            disabledSecondary = Purple700,
            textFiledBackground = Grey200
        )
        override var DarkColors: MyColors = MyColors(
            material = darkColorScheme(
                primary = Red900,
                onPrimary = White,
                primaryContainer = Purple400,
                secondary = Blue400,
                secondaryContainer = Purple900,
                surface = White,
                onSurface = Purple900,
                background = White,
                onBackground = Purple900,
                error = Red400
            )
        )
    }
}