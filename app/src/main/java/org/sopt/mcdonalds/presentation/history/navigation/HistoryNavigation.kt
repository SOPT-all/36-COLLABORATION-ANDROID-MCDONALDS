package org.sopt.mcdonalds.presentation.history.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.mcdonalds.core.common.navigation.Route
import org.sopt.mcdonalds.presentation.history.HistoryRoute

fun NavController.navigateToHistory(navOptions: NavOptions? = null){
    navigate(History, navOptions)
}

fun NavGraphBuilder.historyGraph(
    onNavigateToMenuList: () -> Unit,
    onNavigateToOrder: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    composable <History> {
        HistoryRoute(
            onNavigateToMenuList = onNavigateToMenuList,
            onNavigateToOrder = onNavigateToOrder,
            modifier = modifier
        )
    }
}

@Serializable
data object History: Route