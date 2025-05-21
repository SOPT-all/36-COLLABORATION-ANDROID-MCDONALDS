package org.sopt.mcdonalds.data.cart.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CartListResponse (
    @SerialName("cartItems")
    val carts: List<CartDto>
)

@Serializable
data class CartDto(
    @SerialName("cartItemId")
    val cartItemId: Long,
    @SerialName("amount")
    val amount: Int,
    @SerialName("isSet")
    val isSet: Boolean,
    @SerialName("price")
    val price: Int,
    @SerialName("menuName")
    val menuName: String,
    @SerialName("imageUrl")
    val imageUrl: String
)