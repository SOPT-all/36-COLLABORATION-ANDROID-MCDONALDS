package org.sopt.mcdonalds.domain.order.usecase

import org.sopt.mcdonalds.domain.order.repository.OrderRepository
import javax.inject.Inject

class GetRecentOrderUseCase @Inject constructor(
    private val orderRepository: OrderRepository
) {
    suspend operator fun invoke() = orderRepository.getRecentOrder()
}
