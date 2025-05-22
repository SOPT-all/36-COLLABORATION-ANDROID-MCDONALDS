package org.sopt.mcdonalds.presentation.history.state

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.mcdonalds.domain.cart.model.Cart
import org.sopt.mcdonalds.domain.menu.model.Menu

class HistoryContract {
    @Immutable
    data class HistoryState(
        val cartList: ImmutableList<Cart> = persistentListOf(),
        val recentBurgerList: ImmutableList<Menu> = persistentListOf(),
        val priceSum: Int = 0
    )
}
