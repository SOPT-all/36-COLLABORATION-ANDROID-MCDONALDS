package org.sopt.mcdonalds.data.cart.service

import org.sopt.mcdonalds.core.network.BaseResponse
import org.sopt.mcdonalds.data.cart.dto.CartListResponse
import org.sopt.mcdonalds.data.cart.dto.UpdateCartAmountRequest
import org.sopt.mcdonalds.core.network.BaseResponseWithNull
import org.sopt.mcdonalds.data.cart.dto.CartPostRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.POST

interface CartService {
    @GET("cart")
    suspend fun getCarts(): BaseResponse<CartListResponse>

    @PATCH("cart/{cartItemId}")
    suspend fun updateCartAmount(
        @Path("cartItemId") cartItemId: Long,
        @Body request: UpdateCartAmountRequest
    ): BaseResponse<Unit>

    @POST("cart")
    suspend fun postCart(
        @Body cartPostRequest: CartPostRequest
    ): BaseResponseWithNull
}