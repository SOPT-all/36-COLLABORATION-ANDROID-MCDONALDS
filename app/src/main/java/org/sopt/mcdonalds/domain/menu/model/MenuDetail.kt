package org.sopt.mcdonalds.domain.menu.model

data class MenuDetail(
    val id: Long,
    val name: String,
    val singleImg: String,
    val singlePrice: String,
    val setImg: String,
    val setPrice: String
)
