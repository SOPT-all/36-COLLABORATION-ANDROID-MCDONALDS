package org.sopt.mcdonalds.domain.cart.model

data class Cart(
    val id: Long,
    val amount: Int,
    val isSet: Boolean,
    val price: Int,
    val menuName: String,
    val imageUrl: String
)
