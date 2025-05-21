package org.sopt.mcdonalds.data.cart.datasource

import javax.inject.Inject
import org.sopt.mcdonalds.data.cart.service.CartService

class CartDataSource @Inject constructor(
    private val cartService: CartService
) {
    suspend fun getCarts() = cartService.getCarts().data

    suspend fun updateCartAmount(
        cartItemId: Long,
        amount: Int
    ) = cartService.updateCartAmount(cartItemId, amount).data
}