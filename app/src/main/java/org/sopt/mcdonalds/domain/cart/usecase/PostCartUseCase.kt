package org.sopt.mcdonalds.domain.cart.usecase

import org.sopt.mcdonalds.domain.cart.model.CartDetail
import org.sopt.mcdonalds.domain.cart.repository.CartRepository
import javax.inject.Inject

class PostCartUseCase @Inject constructor(
    private val cartRepository: CartRepository
) {
    suspend operator fun invoke(cartDetail: CartDetail) = cartRepository.postCart(cartDetail)
}