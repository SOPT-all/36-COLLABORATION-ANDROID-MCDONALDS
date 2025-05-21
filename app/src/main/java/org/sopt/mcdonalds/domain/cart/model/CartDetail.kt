package org.sopt.mcdonalds.domain.cart.model

import org.sopt.mcdonalds.presentation.order.type.SetType

data class CartDetail(
    val setType: SetType,
    val amount: Int,
    val menuId: Long
)