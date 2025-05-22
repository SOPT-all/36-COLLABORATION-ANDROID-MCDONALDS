package org.sopt.mcdonalds.domain.cart.model

data class CartDetail(
    val isSet: Boolean,
    val amount: Int,
    val menuId: Long
)