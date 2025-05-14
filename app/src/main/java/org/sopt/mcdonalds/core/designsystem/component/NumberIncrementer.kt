package org.sopt.mcdonalds.core.designsystem.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.mcdonalds.R.drawable.ic_minus_24
import org.sopt.mcdonalds.R.drawable.ic_plus_24
import org.sopt.mcdonalds.core.common.util.noRippleClickable
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme

/**
 * Number incrementer
 *
 * 메뉴 상세화면에서 사용되는 Border가 없는 NumberIncrementer
 *
 * @param count
 * @param onIncrementClick
 * @param onDecrementClick
 */
@Composable
fun NumberIncrementer(
    count: Int,
    onIncrementClick: () -> Unit,
    onDecrementClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(ic_minus_24),
            contentDescription = null,
            modifier = Modifier
                .size(16.dp)
                .noRippleClickable(onDecrementClick),
            tint = McDonaldsTheme.colors.gray400

        )

        Text(
            text = count.toString(),
            style = McDonaldsTheme.typography.body14m.copy(
                color = McDonaldsTheme.colors.black,
                textAlign = TextAlign.Center
            )
        )

        Icon(
            imageVector = ImageVector.vectorResource(ic_plus_24),
            contentDescription = null,
            modifier = Modifier
                .size(16.dp)
                .noRippleClickable(onIncrementClick),
            tint = McDonaldsTheme.colors.black

        )
    }
}

/**
 * Bordered number incrementer
 *
 * 메뉴 상세화면 외 주문내역 화면에서 공통으로 사용되는 Border가 있는 NumberIncrementer
 * 선택인자로 받는 값들은 메뉴 상세 화면에 맞춰져 있으니 주문내역 화면에 맞게 인자를 넘겨주시면 됩니다.
 *
 * @param count
 * @param onIncrementClick
 * @param onDecrementClick
 * @param textStyle
 * @param paddingValues
 */
@Composable
fun BorderedNumberIncrementer(
    count: Int,
    onIncrementClick: () -> Unit,
    onDecrementClick: () -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = McDonaldsTheme.typography.body18m,
    paddingValues: PaddingValues = PaddingValues(horizontal = 10.dp, vertical = 8.dp)
) {
    Row(
        modifier = modifier
            .border(Dp.Hairline, McDonaldsTheme.colors.gray200, RoundedCornerShape(8.dp))
            .padding(paddingValues),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(ic_minus_24),
            contentDescription = null,
            modifier = Modifier
                .noRippleClickable(onDecrementClick),
            tint = McDonaldsTheme.colors.gray400
        )

        Text(
            text = count.toString(),
            style = McDonaldsTheme.typography.body18m.copy(
                color = McDonaldsTheme.colors.black,
                textAlign = TextAlign.Center
            )
        )

        Icon(
            imageVector = ImageVector.vectorResource(ic_plus_24),
            contentDescription = null,
            modifier = Modifier
                .noRippleClickable(onIncrementClick),
            tint = McDonaldsTheme.colors.black
        )
    }
}

@Preview
@Composable
private fun NumberIncrementerPreview() {
    MCDONALDSTheme {
        var num1 by remember { mutableStateOf(0) }
        var num2 by remember { mutableStateOf(0) }

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            NumberIncrementer(
                count = num1,
                onIncrementClick = { num1++ },
                onDecrementClick = { num1-- },
                modifier = Modifier.width(70.dp)
            )

            BorderedNumberIncrementer(
                count = num2,
                onIncrementClick = { num2++ },
                onDecrementClick = { num2-- },
                modifier = Modifier.width(88.dp),
                textStyle = McDonaldsTheme.typography.body16sb,
                paddingValues = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
            )

            BorderedNumberIncrementer(
                count = num2,
                onIncrementClick = { num2++ },
                onDecrementClick = { num2-- },
                modifier = Modifier.width(144.dp)
            )
        }
    }
}
