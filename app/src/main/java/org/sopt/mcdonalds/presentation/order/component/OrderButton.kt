package org.sopt.mcdonalds.presentation.order.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.mcdonalds.R
import org.sopt.mcdonalds.core.common.util.NoRippleInteractionSource
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme

/**
 * 더미 사용자 데이터를 보여주기 위한 컴포넌트
 *
 * @param text 버튼에 들어갈 텍스트
 * @param onClick 버튼을 누를 때 실행되는 함수
 * @param color 버튼의 색깔
 * @param modifier 수정자
 */

@Composable
fun OrderButton(
    text: String,
    onClick: () -> Unit,
    color: Color,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(),
        contentPadding = PaddingValues(vertical = 19.dp, horizontal = 57.dp),
        colors = ButtonDefaults.buttonColors(color),
        shape = RoundedCornerShape(0.dp),
        interactionSource = NoRippleInteractionSource,
    ) {
        Text(
            text = text,
            style = McDonaldsTheme.typography.body12r,
            color = McDonaldsTheme.colors.gray800
        )
    }
}

@Preview
@Composable
private fun OrderButtonsPreview() {
    MCDONALDSTheme {
        Column {
            OrderButton(
                stringResource(R.string.order_order_button),
                {},
                McDonaldsTheme.colors.white
            )
            Spacer(modifier = Modifier.height(8.dp))
            OrderButton(
                stringResource(R.string.order_cart_button),
                {},
                McDonaldsTheme.colors.yellow
            )
        }
    }
}