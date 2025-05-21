package org.sopt.mcdonalds.domain.cart.repository

import org.sopt.mcdonalds.domain.cart.model.Cart

interface CartRepository {
    suspend fun getCarts(): Result<List<Cart>>

    suspend fun updateCartAmount(cartId: Long, amount: Int): Result<Unit>
}