package org.sopt.mcdonalds.presentation.menu.type

import androidx.annotation.StringRes
import org.sopt.mcdonalds.R.string.menu_type_bulgogi
import org.sopt.mcdonalds.R.string.menu_type_cheese
import org.sopt.mcdonalds.R.string.menu_type_mccrispy
import org.sopt.mcdonalds.R.string.menu_type_new
import org.sopt.mcdonalds.R.string.menu_type_recommend

enum class MenuType(
    @StringRes val title: Int
) {
    NEW(title = menu_type_new),
    RECOMMEND(title = menu_type_recommend),
    MCCRISPY(title = menu_type_mccrispy),
    BULGOGI(title = menu_type_bulgogi),
    CHEESE(title = menu_type_cheese);
}
