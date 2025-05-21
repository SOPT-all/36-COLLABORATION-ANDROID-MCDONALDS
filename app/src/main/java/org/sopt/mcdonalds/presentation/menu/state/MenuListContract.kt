package org.sopt.mcdonalds.presentation.menu.state

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.mcdonalds.domain.menu.model.Menu

class MenuListContract {
    @Immutable
    data class MenuListState(
        val menuList: ImmutableList<Menu> = persistentListOf()
    )
}
