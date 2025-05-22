package org.sopt.mcdonalds.data.cart.mapper

import org.sopt.mcdonalds.data.cart.dto.CartListResponse
import org.sopt.mcdonalds.data.cart.dto.UpdateCartAmountRequest
import org.sopt.mcdonalds.domain.cart.model.Cart
import org.sopt.mcdonalds.data.cart.dto.CartPostRequest
import org.sopt.mcdonalds.domain.cart.model.CartDetail
import org.sopt.mcdonalds.presentation.order.type.SetType

fun CartListResponse.toDomain() = this.carts.map {
    Cart(
        id = it.cartItemId,
        amount = it.amount,
        isSet = it.isSet,
        price = it.price,
        menuName = it.menuName,
        imageUrl = it.imageUrl
    )
}

fun Int.toUpdateCartAmountRequest() = UpdateCartAmountRequest(amount = this)

fun CartDetail.toData() = CartPostRequest(
    isSet = isSet,
    amount = amount,
    menuId = menuId,
)