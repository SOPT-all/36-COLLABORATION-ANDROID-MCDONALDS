package org.sopt.mcdonalds.presentation.store.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.mcdonalds.R.drawable.ic_close_24
import org.sopt.mcdonalds.R.drawable.ic_search_24
import org.sopt.mcdonalds.R.string.store_find_title
import org.sopt.mcdonalds.core.common.util.noRippleClickable
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme

@Composable
fun StoreTopBar(
    onCloseClick: () -> Unit,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(ic_close_24),
            contentDescription = null,
            modifier = Modifier
                .noRippleClickable(onCloseClick),
            tint = McDonaldsTheme.colors.black
        )

        Text(
            text = stringResource(store_find_title),
            style = McDonaldsTheme.typography.head18b.copy(
                color = McDonaldsTheme.colors.black
            )
        )

        Icon(
            imageVector = ImageVector.vectorResource(ic_search_24),
            contentDescription = null,
            modifier = Modifier
                .noRippleClickable(onSearchClick),
            tint = McDonaldsTheme.colors.black
        )
    }
}

@Preview
@Composable
private fun StoreTopBarPreview() {
    MCDONALDSTheme {
        StoreTopBar(
            onCloseClick = {},
            onSearchClick = {}
        )
    }
}
