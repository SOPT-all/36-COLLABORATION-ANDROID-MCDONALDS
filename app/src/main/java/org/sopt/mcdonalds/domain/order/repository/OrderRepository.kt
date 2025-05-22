package org.sopt.mcdonalds.domain.order.repository

import org.sopt.mcdonalds.domain.menu.model.Menu

interface OrderRepository {
    suspend fun getRecentOrder(): Result<List<Menu>>

    suspend fun postOrder(): Result<Unit>
}