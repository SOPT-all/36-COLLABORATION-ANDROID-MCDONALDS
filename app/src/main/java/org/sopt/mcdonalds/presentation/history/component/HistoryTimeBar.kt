package org.sopt.mcdonalds.presentation.history.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import org.sopt.mcdonalds.R
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme

/**
 * 주문내역 페이지 속에서 마감 시간을 보여주는 바
 *
 * @param endTime 바에 표시할 매장 마감 시간입니다.
 * @param modifier 수정자
 */
@Composable
fun HistoryTimeBar(
    endTime: LocalDateTime,
    modifier: Modifier = Modifier
) {
    val formatter = DateTimeFormatter.ofPattern("HH:mm")
    Column {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = McDonaldsTheme.colors.gray200)
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(color = McDonaldsTheme.colors.gray100)
                .padding(start = 24.dp, end = 24.dp, top = 7.dp, bottom = 7.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_warning_20),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Text(
                text = stringResource(R.string.history_time_notice, endTime.format(formatter)),
                style = McDonaldsTheme.typography.body14r,
                color = McDonaldsTheme.colors.black
            )
        }
    }
}

@Preview
@Composable
private fun HistoryTimeBarPreview() {
    MCDONALDSTheme {
        Column {
            HistoryTimeBar(
                endTime = LocalDateTime.now(),
                modifier = Modifier
            )
        }
    }
}
