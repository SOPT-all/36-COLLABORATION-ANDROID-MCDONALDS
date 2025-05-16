package org.sopt.mcdonalds.presentation.order.model

import androidx.compose.runtime.MutableState

data class Ingredient(
    val name: String,
    var amount: MutableState<Int>
)
