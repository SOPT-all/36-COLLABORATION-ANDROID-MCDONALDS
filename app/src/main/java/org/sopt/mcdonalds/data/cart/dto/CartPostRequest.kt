package org.sopt.mcdonalds.data.cart.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class CartPostRequest(
    @SerialName("isSet")
    val isSet: Boolean,
    @SerialName("amount")
    val amount: Int,
    @SerialName("menuId")
    val menuId: Long
)