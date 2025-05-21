package org.sopt.mcdonalds.data.cart.service

import org.sopt.mcdonalds.core.network.BaseResponse
import org.sopt.mcdonalds.data.cart.dto.CartPostRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface CartService {
    @POST("cart")
    suspend fun postCart(
        @Body cartPostRequest: CartPostRequest
    ): BaseResponse<Unit>
}