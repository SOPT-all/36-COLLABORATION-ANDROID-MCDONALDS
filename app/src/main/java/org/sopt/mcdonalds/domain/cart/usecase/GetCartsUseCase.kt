package org.sopt.mcdonalds.domain.cart.usecase

import javax.inject.Inject
import org.sopt.mcdonalds.domain.cart.repository.CartRepository

class GetCartsUseCase @Inject constructor(
    private val cartRepository: CartRepository
) {
    suspend operator fun invoke() = cartRepository.getCarts()
}