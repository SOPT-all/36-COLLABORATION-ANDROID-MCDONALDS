package org.sopt.mcdonalds.data.cart.datasource

import javax.inject.Inject
import org.sopt.mcdonalds.data.cart.dto.CartPostRequest
import org.sopt.mcdonalds.data.cart.dto.UpdateCartAmountRequest
import org.sopt.mcdonalds.data.cart.service.CartService

class CartDataSource @Inject constructor(
    private val cartService: CartService
) {
    suspend fun getCarts() = cartService.getCarts().data

    suspend fun updateCartAmount(
        cartItemId: Long,
        request: UpdateCartAmountRequest
    ) = cartService.updateCartAmount(cartItemId, request).data

    suspend fun postCart(cartPostRequest: CartPostRequest) =
        cartService.postCart(cartPostRequest)
}
