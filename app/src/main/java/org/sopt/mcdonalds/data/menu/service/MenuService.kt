package org.sopt.mcdonalds.data.menu.service

import org.sopt.mcdonalds.core.network.BaseResponse
import org.sopt.mcdonalds.data.menu.dto.MenuListResponse
import org.sopt.mcdonalds.data.menu.dto.MenuDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MenuService {
    @GET("menu")
    suspend fun getMenus(): BaseResponse<MenuListResponse>

    @GET("menu/{menuId}")
    suspend fun getMenuDetail(
        @Path("menuId") menuId: Long
    ): BaseResponse<MenuDetailResponse>
}
