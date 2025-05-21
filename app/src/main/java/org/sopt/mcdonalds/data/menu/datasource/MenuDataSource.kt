package org.sopt.mcdonalds.data.menu.datasource

import javax.inject.Inject
import org.sopt.mcdonalds.data.menu.service.MenuService

class MenuDataSource @Inject constructor(
    private val menuService: MenuService
) {
    suspend fun getMenus() = menuService.getMenus().data

    suspend fun getMenuDetail(id: Long) = menuService.getMenuDetail(id).data
}
