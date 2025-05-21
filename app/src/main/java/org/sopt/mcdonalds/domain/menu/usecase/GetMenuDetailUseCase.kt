package org.sopt.mcdonalds.domain.menu.usecase

import org.sopt.mcdonalds.domain.menu.repository.MenuRepository
import javax.inject.Inject

class GetMenuDetailUseCase @Inject constructor(
    private val menuRepository: MenuRepository,
) {
    suspend operator fun invoke(menuId: Long) = menuRepository.getMenuDetail(menuId)
}
