package org.sopt.mcdonalds.presentation.store.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.sopt.mcdonalds.core.common.navigation.Route
import org.sopt.mcdonalds.presentation.store.StoreRoute

fun NavController.navigateToStore(navOptions: NavOptions? = null) = navigate(Store, navOptions)

fun NavGraphBuilder.storeGraph(
    onNavigateToMenuList: () -> Unit,
    modifier: Modifier = Modifier
) {
    composable<Store> {
        StoreRoute(
            onNavigateToMenuList = onNavigateToMenuList,
            modifier = modifier
        )
    }
}

@Serializable
data object Store : Route
