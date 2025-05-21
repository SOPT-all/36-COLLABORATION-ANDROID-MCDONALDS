package org.sopt.mcdonalds.domain.cart.repository

import org.sopt.mcdonalds.core.network.BaseResponse
import org.sopt.mcdonalds.domain.cart.model.CartDetail

interface CartRepository {
    suspend fun postCart(cartDetail: CartDetail): Result<BaseResponse<Unit>>
}