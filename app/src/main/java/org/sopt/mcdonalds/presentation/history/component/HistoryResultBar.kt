package org.sopt.mcdonalds.presentation.history.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.DecimalFormat
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme

/**
 * 주문내역 페이지 속에서 최종 금액 표시를 위한 바
 *
 * @param text 바에 표시할 텍스트입니다.
 * @param price 바에 표시할 최종 금액입니다.
 * @param modifier 수정자
 */
@Composable
fun HistoryResultBar(
    text: String,
    price: Int,
    modifier: Modifier = Modifier
) {
    TopShadow(
        modifier = Modifier
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(color = McDonaldsTheme.colors.white)
                .padding(start = 20.dp, end = 20.dp, top = 25.dp, bottom = 25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = text,
                style = McDonaldsTheme.typography.body16sb,
                color = McDonaldsTheme.colors.black
            )
            Text(
                text = "₩" + DecimalFormat("#,###").format(price),
                style = McDonaldsTheme.typography.body18m,
                color = McDonaldsTheme.colors.black
            )
        }
    }
}

@Composable
private fun TopShadow(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.1f))
                    )
                )
        )
        content()
    }
}

@Preview
@Composable
private fun HistoryResultBarPreview() {
    MCDONALDSTheme {
        Column {
            HistoryResultBar(
                text = "주문 금액",
                price = 11500,
                modifier = Modifier
            )
        }
    }
}
