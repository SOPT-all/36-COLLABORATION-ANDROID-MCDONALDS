package org.sopt.mcdonalds.data.order.datasource

import org.sopt.mcdonalds.data.order.service.OrderService
import javax.inject.Inject

class OrderDataSource @Inject constructor(
    private val orderService: OrderService
) {
    suspend fun getRecentOrder() = orderService.getRecentOrder().data

    suspend fun postOrder() = orderService.postOrder().data
}
