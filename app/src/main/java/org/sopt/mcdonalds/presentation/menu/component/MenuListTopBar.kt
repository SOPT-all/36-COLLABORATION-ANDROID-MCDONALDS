package org.sopt.mcdonalds.presentation.menu.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.mcdonalds.core.designsystem.component.DefaultTopBar
import org.sopt.mcdonalds.R.string.menu_list_title
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme

@Composable
fun MenuListTopBar(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    DefaultTopBar(
        onBackClick = onBackClick,
        modifier = modifier,
        title = stringResource(menu_list_title),
    )
}

@Preview
@Composable
private fun MenuListTopBarPreview() {
    MCDONALDSTheme {
        MenuListTopBar(
            onBackClick = {},
        )
    }
}
