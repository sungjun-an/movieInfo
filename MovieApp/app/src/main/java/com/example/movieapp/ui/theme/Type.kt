package com.example.movieapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.movieapp.R

private val spoqaBold = FontFamily(
    Font(R.font.spoqa_han_sans_neo_bold, FontWeight.Bold)
)

private val spoqaRegular = FontFamily(
    Font(R.font.spoqa_han_sans_neo_regular, FontWeight.Normal)
)

private val spoqaThin = FontFamily(
    Font(R.font.spoqa_han_sans_neo_thin, FontWeight.Thin)
)

// Set of Material typography styles to start with
val Typography = Typography(
    // h1
    displayLarge = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 60.sp,
    ),
    // h2
    displayMedium = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 32.sp,
    ),
    // h3
    displaySmall = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 24.sp,
    ),
    // h4
    headlineLarge = TextStyle(
        fontFamily = spoqaThin,
        fontSize = 32.sp,
    ),
    // h5
    headlineMedium = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 18.sp,
    ),
    // h6
    headlineSmall = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 15.sp,
    ),
    // subtitle1
    titleLarge = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 18.sp,
    ),
    // subtitle2
    titleMedium = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 14.sp,
    ),
    // body1
    bodyLarge = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 15.sp,
    ),
    // body2
    bodyMedium = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 15.sp,
    ),
    // caption
    bodySmall = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 14.sp,
    ),
    // button
    labelLarge = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 18.sp,
    )
)

// 추가적인 커스텀 스타일 정의
// h5 title
val Typography.headlineMediumTitle: TextStyle
    @Composable get() = headlineMedium.copy(
        fontSize = 24.sp
    )

//
val Typography.dialogButton: TextStyle
    @Composable get() = labelLarge.copy(
        fontSize = 18.sp
    )

val Typography.underlinedDialogButton: TextStyle
    @Composable get() = labelLarge.copy(
        textDecoration = TextDecoration.Underline
    )

val Typography.underlinedButton: TextStyle
    @Composable get() = labelLarge.copy(
        textDecoration = TextDecoration.Underline
    )