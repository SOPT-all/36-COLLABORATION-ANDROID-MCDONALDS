package org.sopt.mcdonalds.domain.cart.usecase

import javax.inject.Inject
import org.sopt.mcdonalds.domain.cart.repository.CartRepository

class UpdateCartAmountUseCase @Inject constructor(
    private val cartRepository: CartRepository
) {
    suspend operator fun invoke(cartId: Long, amount: Int) = cartRepository.updateCartAmount(
        cartId,
        amount
    )
}
