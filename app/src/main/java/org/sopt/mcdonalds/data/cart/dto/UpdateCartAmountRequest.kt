package org.sopt.mcdonalds.data.cart.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpdateCartAmountRequest (
    @SerialName("amount")
    val amount: Int
)