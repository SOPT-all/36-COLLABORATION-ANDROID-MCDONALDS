package org.sopt.mcdonalds.data.cart.repository

import javax.inject.Inject
import kotlinx.serialization.SerializationException
import org.sopt.mcdonalds.data.cart.datasource.CartDataSource
import org.sopt.mcdonalds.data.cart.mapper.toDomain
import org.sopt.mcdonalds.data.cart.mapper.toUpdateCartAmountRequest
import org.sopt.mcdonalds.domain.cart.model.Cart
import org.sopt.mcdonalds.data.cart.mapper.toData
import org.sopt.mcdonalds.domain.cart.model.CartDetail
import org.sopt.mcdonalds.domain.cart.repository.CartRepository

class CartRepositoryImpl @Inject constructor(
    private val cartDataSource: CartDataSource
) : CartRepository {
    override suspend fun getCarts(): Result<List<Cart>> = runCatching {
        cartDataSource.getCarts()
    }.mapCatching {
        it.toDomain()
    }

    override suspend fun updateCartAmount(cartId: Long, amount: Int): Result<Unit> = runCatching {
        cartDataSource.updateCartAmount(cartId, amount.toUpdateCartAmountRequest())
    }.recoverCatching { e ->
        if (e is SerializationException) {
            Unit
        } else {
            throw e
        }
    }

    override suspend fun postCart(cartDetail: CartDetail): Result<Unit> =
        runCatching {
            cartDataSource.postCart(cartDetail.toData())
        }
}