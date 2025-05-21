package org.sopt.mcdonalds.data.cart.mapper

import org.sopt.mcdonalds.data.cart.dto.CartPostRequest
import org.sopt.mcdonalds.domain.cart.model.CartDetail
import org.sopt.mcdonalds.presentation.order.type.SetType

fun CartDetail.toData() = CartPostRequest(
    isSet = setType == SetType.SET,
    amount = amount,
    menuId = menuId,
)