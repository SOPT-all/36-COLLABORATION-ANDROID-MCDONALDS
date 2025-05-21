package org.sopt.mcdonalds.data.menu.repository

import javax.inject.Inject
import org.sopt.mcdonalds.data.menu.datasource.MenuDataSource
import org.sopt.mcdonalds.data.menu.mapper.toDomain
import org.sopt.mcdonalds.domain.menu.model.Menu
import org.sopt.mcdonalds.domain.menu.model.MenuDetail
import org.sopt.mcdonalds.domain.menu.repository.MenuRepository

class MenuRepositoryImpl @Inject constructor(
    private val menuDataSource: MenuDataSource
) : MenuRepository {
    override suspend fun getMenus(): Result<List<Menu>> = runCatching {
        menuDataSource.getMenus()
    }.mapCatching {
        it.toDomain()
    }

    override suspend fun getMenuDetail(menuId: Long): Result<MenuDetail> = runCatching {
        menuDataSource.getMenuDetail(menuId)
    }.mapCatching {
        it.toDomain()
    }
}
