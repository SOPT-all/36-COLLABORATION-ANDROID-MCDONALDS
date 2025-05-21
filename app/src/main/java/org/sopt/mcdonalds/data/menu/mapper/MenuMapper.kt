package org.sopt.mcdonalds.data.menu.mapper

import org.sopt.mcdonalds.data.menu.dto.MenuDetailResponse
import org.sopt.mcdonalds.data.menu.dto.MenuListResponse
import org.sopt.mcdonalds.domain.menu.model.Menu
import org.sopt.mcdonalds.domain.menu.model.MenuDetail

fun MenuListResponse.toDomain() = this.menus.map {
    Menu(
        id = it.id,
        name = it.name,
        imageUrl = it.img,
        price = it.price
    )
}

fun MenuDetailResponse.toDomain() = MenuDetail(
    id = this.id,
    name = this.name,
    singleImg = this.singleImg,
    singlePrice = this.singlePrice,
    setImg = this.setImg,
    setPrice = this.setPrice
)
