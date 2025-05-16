package org.sopt.mcdonalds.presentation.history.model

data class Cart(
    val cartId: Long,
    var amount: Int,
    val price: Int,
    val menuName: String,
    val imageUrl: String,
    val isSet: Boolean
)
