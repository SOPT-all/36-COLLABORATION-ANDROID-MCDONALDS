package org.sopt.mcdonalds.presentation.history.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.mcdonalds.core.common.util.NoRippleInteractionSource
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme

/**
 * 주문내역 페이지 속에서 주문을 위해 사용하는 버튼
 *
 * @param text 버튼에 표시할 텍스트입니다.
 * @param onClick 버튼 클릭 시 발생할 이벤트 함수입니다.
 * @param modifier 수정자
 * @param enabled 버튼의 활성화 여부
 */
@Composable
fun HistorySquareButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(McDonaldsTheme.colors.yellow),
        shape = RectangleShape,
        interactionSource = NoRippleInteractionSource
    ) {
        Text(
            text = text,
            style = McDonaldsTheme.typography.body16m,
            color = McDonaldsTheme.colors.gray800,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun HistorySquareButtonPreview() {
    MCDONALDSTheme {
        HistorySquareButton(
            text = "제품 수령 장소 선택",
            onClick = {},
            enabled = true
        )
    }
}
