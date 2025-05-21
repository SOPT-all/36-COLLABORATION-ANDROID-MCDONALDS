package org.sopt.mcdonalds.data.menu.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuDetailResponse(
    @SerialName("menuId")
    val id: Long,
    @SerialName("menuName")
    val name: String,
    @SerialName("singleImg")
    val singleImg: String,
    @SerialName("singlePrice")
    val singlePrice: String,
    @SerialName("setImg")
    val setImg: String,
    @SerialName("setPrice")
    val setPrice: String
)
