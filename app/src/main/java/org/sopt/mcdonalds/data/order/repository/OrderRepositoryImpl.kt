package org.sopt.mcdonalds.data.order.repository

import org.sopt.mcdonalds.data.order.datasource.OrderDataSource
import org.sopt.mcdonalds.data.order.mapper.toDomain
import org.sopt.mcdonalds.domain.order.repository.OrderRepository
import org.sopt.mcdonalds.domain.menu.model.Menu
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val orderDataSource: OrderDataSource
) : OrderRepository {
    override suspend fun getRecentOrder(): Result<List<Menu>> = runCatching {
        orderDataSource.getRecentOrder()
    }.mapCatching {
        it.toDomain()
    }

    override suspend fun postOrder(): Result<Unit> = runCatching {
        orderDataSource.postOrder()
    }
}
