package org.sopt.mcdonalds.presentation.order.state

import androidx.compose.runtime.Immutable
import org.sopt.mcdonalds.domain.menu.model.MenuDetail
import org.sopt.mcdonalds.presentation.order.type.SetType

class OrderContract {
    @Immutable
    data class OrderState(
        val menuDetail: MenuDetail = MenuDetail(
            id = -1L,
            name = "",
            singleImg = "",
            singlePrice = "",
            setImg = "",
            setPrice = ""
        ),
        val burgerCount: Int = 1,
        val setType: SetType = SetType.SET
    )

    sealed class OrderSideEffect {
        data object NavigateToMenuList : OrderSideEffect()
        data object NavigateToHistory : OrderSideEffect()
    }
}
