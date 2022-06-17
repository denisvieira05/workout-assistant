package com.denisvieira05.workoutassistant.app.ui.utils

import androidx.compose.ui.graphics.Color
import android.graphics.Color as ColorGraphics
import kotlin.random.Random

enum class ColorFactorTopValue(value: Int){
    ALL_COLORS(256),
    DARK_COLORS(100)
}

fun getRandomColorNumber(): Int {
    val rnd = Random
    return ColorGraphics.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
}

fun getRandomColor(): Color {
    val rnd = Random
    val factorValue = ColorFactorTopValue.DARK_COLORS

    return Color(rnd.nextInt(100), rnd.nextInt(100), rnd.nextInt(100))
}