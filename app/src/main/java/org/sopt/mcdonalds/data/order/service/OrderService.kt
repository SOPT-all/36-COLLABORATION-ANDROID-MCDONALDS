package org.sopt.mcdonalds.data.order.service

import org.sopt.mcdonalds.core.network.BaseResponse
import org.sopt.mcdonalds.data.order.dto.RecentOrderResponse
import retrofit2.http.GET
import retrofit2.http.POST

interface OrderService {
    @GET("order/recent")
    suspend fun getRecentOrder(): BaseResponse<RecentOrderResponse>

    @POST("order")
    suspend fun postOrder(): BaseResponse<Unit>
}
