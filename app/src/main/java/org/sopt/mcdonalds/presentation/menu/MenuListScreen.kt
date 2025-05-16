package org.sopt.mcdonalds.presentation.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme
import org.sopt.mcdonalds.presentation.menu.component.MenuListContent
import org.sopt.mcdonalds.presentation.menu.component.MenuListFilterGroup
import org.sopt.mcdonalds.presentation.menu.component.MenuListTopBar
import org.sopt.mcdonalds.presentation.menu.type.MenuType

@Composable
fun MenuListRoute(
    modifier: Modifier = Modifier
) {
    MenuListScreen(
        modifier = modifier
    )
}

@Composable
private fun MenuListScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        MenuListTopBar(
            onBackClick = { /* TODO */ }
        )

        Spacer(modifier = Modifier.height(16.dp))

        MenuListFilterGroup(
            selectedMenuType = MenuType.NEW,
            menuTypes = MenuType.entries.toPersistentList(),
            onMenuTypeSelect = { /* TODO */ }
        )

        Spacer(modifier = Modifier.height(16.dp))

        MenuListContent(
            menus = persistentListOf(),
            modifier = modifier
        )
    }
}

@Preview
@Composable
private fun MenuListScreenPreview() {
    MCDONALDSTheme {
        MenuListScreen(
            modifier = Modifier.background(McDonaldsTheme.colors.white)
        )
    }
}
