package org.sopt.mcdonalds.presentation.store.type

import androidx.annotation.StringRes
import org.sopt.mcdonalds.R.string.garage
import org.sopt.mcdonalds.R.string.mc_drive
import org.sopt.mcdonalds.R.string.open_24_hours

enum class StoreType(
    @StringRes val title: Int
) {
    MCDRIVE(title = mc_drive),
    OPEN_24_HOURS(title = open_24_hours),
    GARAGE(title = garage);
}
