package org.sopt.mcdonalds.presentation.order.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.mcdonalds.core.common.navigation.Route
import org.sopt.mcdonalds.presentation.order.OrderRoute

fun NavController.navigateToOrder(navOptions: NavOptions? = null) {
    navigate(Order, navOptions)
}

fun NavGraphBuilder.orderGraph(
    onNavigateToUp: () -> Unit,
    onNavigateToHistory: () -> Unit,
    modifier: Modifier = Modifier
) {
    composable<Order> {
        OrderRoute(
            onBackClick = onNavigateToUp,
            onNavigateToHistory = onNavigateToHistory,
            modifier = modifier
        )
    }
}

@Serializable
data object Order : Route