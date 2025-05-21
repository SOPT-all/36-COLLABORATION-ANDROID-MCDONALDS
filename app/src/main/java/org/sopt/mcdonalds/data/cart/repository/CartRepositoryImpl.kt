package org.sopt.mcdonalds.data.cart.repository

import javax.inject.Inject
import org.sopt.mcdonalds.data.cart.datasource.CartDataSource
import org.sopt.mcdonalds.data.cart.toDomain
import org.sopt.mcdonalds.domain.cart.model.Cart
import org.sopt.mcdonalds.domain.cart.repository.CartRepository

class CartRepositoryImpl @Inject constructor(
    private val cartDataSource: CartDataSource
): CartRepository {
    override suspend fun getCarts(): Result<List<Cart>> = runCatching {
        cartDataSource.getCarts()
    }.mapCatching {
        it.toDomain()
    }

    override suspend fun updateCartAmount(cartId: Long, amount: Int): Result<Unit> = runCatching {
        cartDataSource.updateCartAmount(cartId, amount)
    }
}