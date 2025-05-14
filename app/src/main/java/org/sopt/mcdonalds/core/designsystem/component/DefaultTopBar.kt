package org.sopt.mcdonalds.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme
import org.sopt.mcdonalds.R.drawable.ic_back_24
import org.sopt.mcdonalds.core.common.util.noRippleClickable
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme

/**
 * Underlined top bar
 *
 * 첫 화면을 제외한 모든 화면에서 공통으로 사용되는 TopBar
 *
 * @param onBackClick
 * @param modifier
 * @param title: 제목이 없을 경우엔 비워두시면 됩니다.
 */
@Composable
fun DefaultTopBar(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    title: String = "",
) {
    Column {
        Row(
            modifier = modifier
                .padding(start = 16.dp, top = 8.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(ic_back_24),
                contentDescription = null,
                modifier = Modifier
                    .noRippleClickable(onBackClick),
                tint = McDonaldsTheme.colors.gray600,
            )

            Text(
                text = title,
                style = McDonaldsTheme.typography.head18b.copy(
                    color = McDonaldsTheme.colors.gray750
                )
            )
        }

        HorizontalDivider(
            thickness = 1.dp,
            color = McDonaldsTheme.colors.gray200
        )
    }
}

@Preview
@Composable
private fun TopBarPreview() {
    MCDONALDSTheme {
        Column(
            modifier = Modifier
                .background(color = McDonaldsTheme.colors.white),
        ) {
            DefaultTopBar(
                onBackClick = { },
            )

            DefaultTopBar(
                onBackClick = { },
                title = "버거 & 세트"
            )
        }
    }
}
