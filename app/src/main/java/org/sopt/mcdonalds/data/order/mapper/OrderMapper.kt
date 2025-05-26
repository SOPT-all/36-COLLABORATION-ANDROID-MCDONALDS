package org.sopt.mcdonalds.data.order.mapper

import org.sopt.mcdonalds.data.order.dto.RecentOrderResponse
import org.sopt.mcdonalds.domain.menu.model.Menu

fun RecentOrderResponse.toDomain() = this.recentItems.map {
    Menu(
        id = it.id,
        name = it.name,
        imageUrl = it.img,
        price = it.price.toString()
    )
}
