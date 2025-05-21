package org.sopt.mcdonalds.domain.menu.usecase

import org.sopt.mcdonalds.domain.menu.repository.MenuRepository
import javax.inject.Inject

class GetMenusUseCase @Inject constructor(
    private val menuRepository: MenuRepository,
) {
    suspend operator fun invoke() = menuRepository.getMenus()
}
