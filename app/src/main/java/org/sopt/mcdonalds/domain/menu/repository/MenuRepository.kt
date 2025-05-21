package org.sopt.mcdonalds.domain.menu.repository

import org.sopt.mcdonalds.domain.menu.model.Menu
import org.sopt.mcdonalds.domain.menu.model.MenuDetail

interface MenuRepository {
    suspend fun getMenus(): Result<List<Menu>>

    suspend fun getMenuDetail(menuId: Long): Result<MenuDetail>
}
