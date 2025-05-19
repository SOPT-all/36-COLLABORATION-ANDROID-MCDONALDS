package org.sopt.mcdonalds.presentation.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.collections.immutable.toPersistentList
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme
import org.sopt.mcdonalds.presentation.menu.component.MenuListContent
import org.sopt.mcdonalds.presentation.menu.component.MenuListFilterGroup
import org.sopt.mcdonalds.presentation.menu.component.MenuListTopBar
import org.sopt.mcdonalds.presentation.menu.state.MenuListContract.MenuListState
import org.sopt.mcdonalds.presentation.menu.type.MenuType

@Composable
fun MenuListRoute(
    onBackClick: () -> Unit,
    onNavigateToOrder: (Long) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: MenuListViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    MenuListScreen(
        uiState = uiState,
        onBackClick = onBackClick,
        onMenuClick = onNavigateToOrder,
        modifier = modifier
    )
}

@Composable
private fun MenuListScreen(
    uiState: MenuListState,
    onBackClick: () -> Unit,
    onMenuClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    var menuType by remember { mutableStateOf(MenuType.NEW) }

    Column(
        modifier = modifier
    ) {
        MenuListTopBar(
            onBackClick = onBackClick
        )

        Spacer(modifier = Modifier.height(16.dp))

        MenuListFilterGroup(
            selectedMenuType = menuType,
            menuTypes = MenuType.entries.toPersistentList(),
            onMenuTypeSelect = {
                menuType = it
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        MenuListContent(
            menus = uiState.menuList,
            onMenuClick = onMenuClick,
            modifier = modifier
        )
    }
}

@Preview
@Composable
private fun MenuListScreenPreview() {
    MCDONALDSTheme {
        MenuListScreen(
            uiState = MenuListState(),
            onBackClick = {},
            onMenuClick = {},
            modifier = Modifier.background(McDonaldsTheme.colors.white)
        )
    }
}
