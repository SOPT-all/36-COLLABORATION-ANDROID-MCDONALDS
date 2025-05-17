package org.sopt.mcdonalds.presentation.order.model

import androidx.annotation.DrawableRes

data class Side(
    val name: String,
    @DrawableRes val imageId: Int
)
