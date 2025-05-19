package org.sopt.mcdonalds.presentation.order.model

data class Burger(
    val burgerId: Int,
    val name: String,
    val singleImg: String,
    val singlePrice: String,
    val setImg: String,
    val setPrice: String,
)