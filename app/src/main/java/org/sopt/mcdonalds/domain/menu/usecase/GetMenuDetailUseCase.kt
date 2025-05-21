package org.sopt.mcdonalds.domain.menu.usecase

import javax.inject.Inject
import org.sopt.mcdonalds.domain.menu.repository.MenuRepository

class GetMenuDetailUseCase @Inject constructor(
    private val menuRepository: MenuRepository
) {
    suspend operator fun invoke(menuId: Long) = menuRepository.getMenuDetail(menuId)
}
