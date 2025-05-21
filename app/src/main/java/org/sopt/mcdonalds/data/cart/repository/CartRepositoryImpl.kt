package org.sopt.mcdonalds.data.cart.repository

import org.sopt.mcdonalds.data.cart.datasource.CartDataSource
import org.sopt.mcdonalds.data.cart.mapper.toData
import org.sopt.mcdonalds.domain.cart.model.CartDetail
import org.sopt.mcdonalds.domain.cart.repository.CartRepository
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val cartDataSource: CartDataSource
) : CartRepository {
    override suspend fun postCart(cartDetail: CartDetail): Result<Unit> =
        runCatching {
            cartDataSource.postCart(cartDetail.toData())
        }
}