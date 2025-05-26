package org.sopt.mcdonalds.data.order.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.sopt.mcdonalds.data.menu.dto.MenuDto

@Serializable
data class RecentOrderResponse(
    @SerialName("recentItems")
    val recentItems: List<RecentItem>
)

@Serializable
data class RecentItem(
    @SerialName("menuId")
    val id: Long,
    @SerialName("menuName")
    val name: String,
    @SerialName("menuImg")
    val img: String,
    @SerialName("menuPrice")
    val price: Int
)