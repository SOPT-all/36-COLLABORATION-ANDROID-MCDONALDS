package org.sopt.mcdonalds.presentation.order.state

import org.sopt.mcdonalds.domain.menu.model.MenuDetail
import org.sopt.mcdonalds.presentation.order.type.SetType

class OrderContract {
    data class OrderState(
        val menuDetail: MenuDetail,
        val burgerCount: Int = 1,
        val setType: SetType = SetType.SET,
    )
}