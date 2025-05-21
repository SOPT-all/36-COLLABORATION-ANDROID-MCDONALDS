package org.sopt.mcdonalds.data.menu.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuListResponse(
    @SerialName("menuList")
    val menus: List<MenuDto>
)

@Serializable
data class MenuDto(
    @SerialName("menuId")
    val id: Long,
    @SerialName("menuName")
    val name: String,
    @SerialName("menuImg")
    val img: String,
    @SerialName("menuPrice")
    val price: String
)
