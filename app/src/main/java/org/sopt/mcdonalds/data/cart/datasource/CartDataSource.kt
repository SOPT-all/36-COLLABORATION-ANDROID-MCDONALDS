package org.sopt.mcdonalds.data.cart.datasource

import org.sopt.mcdonalds.data.cart.dto.CartPostRequest
import org.sopt.mcdonalds.data.cart.service.CartService
import javax.inject.Inject

class CartDataSource @Inject constructor(
    private val cartService: CartService
) {
    suspend fun postCart(cartPostRequest: CartPostRequest) =
        cartService.postCart(cartPostRequest)
}