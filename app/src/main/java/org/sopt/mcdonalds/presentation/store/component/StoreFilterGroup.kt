package org.sopt.mcdonalds.presentation.store.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.sopt.mcdonalds.R.drawable.ic_menu_20
import org.sopt.mcdonalds.core.designsystem.component.ChipButton
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme
import org.sopt.mcdonalds.presentation.store.type.StoreType

@Composable
fun StoreFilterGroup(
    selectedStoreType: StoreType,
    storeTypes: ImmutableList<StoreType>,
    onStoreTypeSelect: (StoreType) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier
            .padding(horizontal = 20.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        item {
            Icon(
                imageVector = ImageVector.vectorResource(ic_menu_20),
                contentDescription = null,
                modifier = Modifier,
                tint = McDonaldsTheme.colors.black
            )
        }

        itemsIndexed(
            items = storeTypes,
            key = { _, storeType -> storeType.title },
        ) { _, storeType ->
            ChipButton(
                isSelected = selectedStoreType == storeType,
                selectedType = storeType,
                onSelect = onStoreTypeSelect,
                textStyle = McDonaldsTheme.typography.body12r,
                paddingValues = PaddingValues(horizontal = 16.dp, vertical = 4.dp),
            )
        }
    }
}

@Preview
@Composable
private fun StoreFilterGroupPreview() {
    MCDONALDSTheme {
        StoreFilterGroup(
            selectedStoreType = StoreType.OPEN_24_HOURS,
            storeTypes = StoreType.entries.toImmutableList(),
            onStoreTypeSelect = {},
        )
    }
}
