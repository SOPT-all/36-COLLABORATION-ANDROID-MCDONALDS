package org.sopt.mcdonalds.presentation.menu.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.mcdonalds.core.common.navigation.Route
import org.sopt.mcdonalds.presentation.menu.MenuListRoute

fun NavController.navigateToMenuList(navOptions: NavOptions? = null) =
    navigate(MenuList, navOptions)

fun NavGraphBuilder.menuListGraph(
    onNavigateToUp: () -> Unit,
    onNavigateToOrder: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    composable<MenuList> {
        MenuListRoute(
            onBackClick = onNavigateToUp,
            onNavigateToOrder = onNavigateToOrder,
            modifier = modifier
        )
    }
}

@Serializable
data object MenuList : Route
