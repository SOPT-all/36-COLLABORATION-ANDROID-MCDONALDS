package org.sopt.mcdonalds.presentation.menu.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import org.sopt.mcdonalds.core.designsystem.component.ChipButton
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme
import org.sopt.mcdonalds.presentation.menu.type.MenuType

@Composable
fun MenuListFilterGroup(
    selectedMenuType: MenuType,
    menuTypes: ImmutableList<MenuType>,
    onMenuTypeSelect: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        itemsIndexed(
            items = menuTypes,
            key = { _, menuType -> menuType.title }
        ) { index, menuType ->
            val padStart = if (index == 0) 20.dp else 0.dp
            val padEnd = if (index == menuTypes.lastIndex) 20.dp else 0.dp

            ChipButton(
                isSelected = selectedMenuType == menuType,
                title = menuType.title,
                onSelect = onMenuTypeSelect,
                modifier = Modifier.padding(start = padStart, end = padEnd),
                textStyle = McDonaldsTheme.typography.body12r.copy(
                    color = McDonaldsTheme.colors.black
                ),
                paddingValues = PaddingValues(horizontal = 16.dp, vertical = 4.dp)
            )
        }
    }
}

@Preview
@Composable
private fun MenuListFilterGroupPreview() {
    MCDONALDSTheme {
        MenuListFilterGroup(
            selectedMenuType = MenuType.NEW,
            menuTypes = MenuType.entries.toPersistentList(),
            onMenuTypeSelect = {}
        )
    }
}
