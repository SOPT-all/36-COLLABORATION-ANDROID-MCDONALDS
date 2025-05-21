package org.sopt.mcdonalds.domain.menu.usecase

import javax.inject.Inject
import org.sopt.mcdonalds.domain.menu.repository.MenuRepository

class GetMenusUseCase @Inject constructor(
    private val menuRepository: MenuRepository
) {
    suspend operator fun invoke() = menuRepository.getMenus()
}
