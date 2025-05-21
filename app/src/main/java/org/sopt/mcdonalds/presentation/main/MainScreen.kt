package org.sopt.mcdonalds.presentation.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.sopt.mcdonalds.presentation.history.navigation.historyGraph
import org.sopt.mcdonalds.presentation.menu.navigation.menuListGraph
import org.sopt.mcdonalds.presentation.menu.navigation.navigateToMenuList
import org.sopt.mcdonalds.presentation.order.navigation.navigateToOrder
import org.sopt.mcdonalds.presentation.order.navigation.orderGraph
import org.sopt.mcdonalds.presentation.store.navigation.Store
import org.sopt.mcdonalds.presentation.store.navigation.storeGraph

@Composable
fun MainScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        MainNavHost(
            navController = rememberNavController(),
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
private fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
        navController = navController,
        startDestination = Store
    ) {
        storeGraph(
            onNavigateToMenuList = navController::navigateToMenuList,
            modifier = modifier
        )

        menuListGraph(
            onNavigateToUp = navController::navigateUp,
            onNavigateToOrder = {
                navController.navigateToOrder(it)
            },
            modifier = modifier
        )

        historyGraph(
            onNavigateToMenuList = navController::navigateToMenuList,
            onNavigateToOrder = { /* TODO */ },
            modifier = modifier
        )

        orderGraph(
            onNavigateToUp = navController::navigateUp,
            onNavigateToHistory = { /* TODO */ },
            onNavigateToMenuList = navController::navigateToMenuList,
            modifier = modifier,
        )
    }
}
