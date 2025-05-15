
package org.sopt.mcdonalds.presentation.history.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.mcdonalds.R
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme

/**
 * 주문내역 페이지 속에서 현재 매장을 보여주는 바
 *
 * @param store 바에 표시할 매장 이름입니다.
 * @param onStoreChangeClick 바 속 매장 변경 버튼 클릭 시 발생할 이벤트 함수입니다.
 * @param modifier 수정자
 */
@Composable
fun HistoryStoreBar(
    store: String,
    onStoreChangeClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(color = McDonaldsTheme.colors.white)
                .padding(start = 20.dp, end = 20.dp, top = 12.dp, bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_mcdonalds_location),
                    contentDescription = null,
                    tint = Color.Unspecified
                )
                Text(
                    text = store,
                    style = McDonaldsTheme.typography.body14b,
                    color = McDonaldsTheme.colors.black
                )
            }
            HistoryStoreChangeButton(
                text = stringResource(R.string.history_store_change),
                onClick = onStoreChangeClick
            )
        }
        HorizontalDivider(
            thickness = 1.dp,
            color = McDonaldsTheme.colors.gray300
        )
    }
}

@Preview
@Composable
private fun HistoryStoreBarPreview() {
    MCDONALDSTheme {
        Column {
            HistoryStoreBar(
                store = "양평SK DT",
                onStoreChangeClick = {},
                modifier = Modifier
            )
        }
    }
}
