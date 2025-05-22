package org.sopt.mcdonalds.domain.cart.usecase

import javax.inject.Inject
import org.sopt.mcdonalds.domain.cart.model.CartDetail
import org.sopt.mcdonalds.domain.cart.repository.CartRepository

class PostCartUseCase @Inject constructor(
    private val cartRepository: CartRepository
) {
    suspend operator fun invoke(cartDetail: CartDetail) = cartRepository.postCart(cartDetail)
}
