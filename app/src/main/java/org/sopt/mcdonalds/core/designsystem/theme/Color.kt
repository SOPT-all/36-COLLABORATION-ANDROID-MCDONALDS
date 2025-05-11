package org.sopt.mcdonalds.core.designsystem.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

// Main
val lightYellow = Color(0xFFFFF2CF)
val yellow = Color(0xFFFFBC0D)
val darkYellow = Color(0xFFE5A90B)

// Point
val blue = Color(0xFF307AC4)
val lightRed = Color(0xFFFFD0D0)
val red = Color(0xFFFF195E)
val orange = Color(0xFFF08849)

// Static
val black = Color(0xFF000000)
val white = Color(0xFFFFFFFF)

// Gray Scale
val gray800 = Color(0xFF292929)
val gray750 = Color(0xFF3F3F3F)
val gray700 = Color(0xFF646464)
val gray600 = Color(0xFF787878)
val gray500 = Color(0xFFA2A2A2)
val gray400 = Color(0xFFB2B2B2)
val gray300 = Color(0xFFD9D9D9)
val gray200 = Color(0xFFE3E3E3)
val gray100 = Color(0xFFF3F3F3)

@Stable
class McDonaldsColors(
    lightYellow: Color,
    yellow: Color,
    darkYellow: Color,
    blue: Color,
    lightRed: Color,
    red: Color,
    orange: Color,
    black: Color,
    white: Color,
    gray800: Color,
    gray750: Color,
    gray700: Color,
    gray600: Color,
    gray500: Color,
    gray400: Color,
    gray300: Color,
    gray200: Color,
    gray100: Color,
    isLight: Boolean,
) {
    var lightYellow by mutableStateOf(lightYellow)
        private set
    var yellow by mutableStateOf(yellow)
        private set
    var darkYellow by mutableStateOf(darkYellow)
        private set
    var blue by mutableStateOf(blue)
        private set
    var lightRed by mutableStateOf(lightRed)
        private set
    var red by mutableStateOf(red)
        private set
    var orange by mutableStateOf(orange)
        private set
    var black by mutableStateOf(black)
        private set
    var white by mutableStateOf(white)
        private set
    var gray800 by mutableStateOf(gray800)
        private set
    var gray750 by mutableStateOf(gray750)
        private set
    var gray700 by mutableStateOf(gray700)
        private set
    var gray600 by mutableStateOf(gray600)
        private set
    var gray500 by mutableStateOf(gray500)
        private set
    var gray400 by mutableStateOf(gray400)
        private set
    var gray300 by mutableStateOf(gray300)
        private set
    var gray200 by mutableStateOf(gray200)
        private set
    var gray100 by mutableStateOf(gray100)
        private set
    var isLight by mutableStateOf(isLight)

    fun copy(): McDonaldsColors = McDonaldsColors(
        lightYellow,
        yellow,
        darkYellow,
        blue,
        lightRed,
        red,
        orange,
        black,
        white,
        gray800,
        gray750,
        gray700,
        gray600,
        gray500,
        gray400,
        gray300,
        gray200,
        gray100,
        isLight,
    )

    fun update(other: McDonaldsColors) {
        lightYellow = other.lightYellow
        yellow = other.yellow
        darkYellow = other.darkYellow
        blue = other.blue
        lightRed = other.lightRed
        red = other.red
        orange = other.orange
        black = other.black
        white = other.white
        gray800 = other.gray800
        gray750 = other.gray750
        gray700 = other.gray700
        gray600 = other.gray600
        gray500 = other.gray500
        gray400 = other.gray400
        gray300 = other.gray300
        gray200 = other.gray200
        gray100 = other.gray100
        isLight = other.isLight
    }
}

fun McDonaldsLightColors(
    LightYellow: Color = lightYellow,
    Yellow: Color = yellow,
    DarkYellow: Color = darkYellow,
    Blue: Color = blue,
    LightRed: Color = lightRed,
    Red: Color = red,
    Orange: Color = orange,
    Black: Color = black,
    White: Color = white,
    Gray800: Color = gray800,
    Gray750: Color = gray750,
    Gray700: Color = gray700,
    Gray600: Color = gray600,
    Gray500: Color = gray500,
    Gray400: Color = gray400,
    Gray300: Color = gray300,
    Gray200: Color = gray200,
    Gray100: Color = gray100,
) = McDonaldsColors(
    LightYellow,
    Yellow,
    DarkYellow,
    Blue,
    LightRed,
    Red,
    Orange,
    Black,
    White,
    Gray800,
    Gray750,
    Gray700,
    Gray600,
    Gray500,
    Gray400,
    Gray300,
    Gray200,
    Gray100,
    isLight = true,
)
