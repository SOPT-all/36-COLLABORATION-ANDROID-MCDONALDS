package org.sopt.mcdonalds.domain.cart.repository

import org.sopt.mcdonalds.domain.cart.model.Cart
import org.sopt.mcdonalds.domain.cart.model.CartDetail

interface CartRepository {
    suspend fun getCarts(): Result<List<Cart>>

    suspend fun updateCartAmount(cartId: Long, amount: Int): Result<Unit>

    suspend fun postCart(cartDetail: CartDetail): Result<Unit>
}