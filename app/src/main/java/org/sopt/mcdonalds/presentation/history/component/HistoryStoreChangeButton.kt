package org.sopt.mcdonalds.presentation.history.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.mcdonalds.core.common.util.noRippleClickable
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme

/**
 * 주문내역 페이지 속에서 매장 변경을 위해 사용하는 버튼
 *
 * @param text 버튼에 표시할 텍스트입니다.
 * @param onClick 버튼 클릭 시 발생할 이벤트 함수입니다.
 * @param modifier 수정자
 */
@Composable
fun HistoryStoreChangeButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier
            .background(
                color = McDonaldsTheme.colors.white,
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = 0.5.dp,
                color = McDonaldsTheme.colors.blue,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
            .noRippleClickable(onClick),
        text = text,
        style = McDonaldsTheme.typography.caption10r,
        color = McDonaldsTheme.colors.blue,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview
@Composable
fun HistoryStoreChangeButtonPreview() {
    MCDONALDSTheme {
        HistoryStoreChangeButton(
            text = "매장 변경",
            onClick = {},
            modifier = Modifier
        )
    }
}
