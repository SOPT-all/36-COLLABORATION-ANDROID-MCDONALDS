package org.sopt.mcdonalds.data.menu.datasource

import org.sopt.mcdonalds.data.menu.service.MenuService
import javax.inject.Inject

class MenuDataSource @Inject constructor(
    private val menuService: MenuService
) {
    suspend fun getMenus() = menuService.getMenus().data

    suspend fun getMenuDetail(id: Long) = menuService.getMenuDetail(id).data
}