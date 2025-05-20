package org.sopt.mcdonalds.presentation.history.state

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.mcdonalds.presentation.history.model.Cart
import org.sopt.mcdonalds.presentation.history.model.RecentBurger

class HistoryContract {
    data class HistoryState(
        val cartList: ImmutableList<Cart> = persistentListOf(),
        val recentBurgerList: ImmutableList<RecentBurger> = persistentListOf()
    )
}