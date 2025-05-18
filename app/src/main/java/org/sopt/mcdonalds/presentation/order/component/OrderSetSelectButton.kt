package org.sopt.mcdonalds.presentation.order.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.sopt.mcdonalds.core.common.util.noRippleClickable
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme

/**
 * 주문하기에서 단품/세트 선택하는 버튼
 *
 * @param text 세트 / 단품 텍스트
 * @param price 가격
 * @param isSelected 선택 여부
 * @param imageURL 이미지 URL
 * @param modifier 수정자
 */

@Composable
fun OrderSetSelectButton(
    text: String,
    price: String,
    isSelected: Boolean,
    imageURL: String,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (isSelected) {
        McDonaldsTheme.colors.lightYellow
    } else {
        McDonaldsTheme.colors.white
    }
    val borderColor = if (isSelected) {
        McDonaldsTheme.colors.yellow
    } else {
        McDonaldsTheme.colors.gray200
    }
    Column(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                color = borderColor,
                width = 1.dp,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(15.dp)
            .noRippleClickable { onSelect() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        AsyncImage(
            model = imageURL,
            contentDescription = "햄버거 세트",
            modifier = Modifier
                .width(120.dp)
                .height(104.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = text,
            style = McDonaldsTheme.typography.head18b,
            color = McDonaldsTheme.colors.black
        )
        Text(
            text = price,
            style = McDonaldsTheme.typography.body14r,
            color = McDonaldsTheme.colors.gray800
        )
        Spacer(modifier = Modifier.height(5.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun OrderSetSelectButtonPreview() {
    MCDONALDSTheme {
        Column {
            Row {
                OrderSetSelectButton(
                    text = "단품",
                    price = "₩10,000",
                    isSelected = false,
                    imageURL = "",
                    onSelect = {}
                )
                Spacer(modifier = Modifier.width(8.dp))
                OrderSetSelectButton(
                    text = "단품",
                    price = "₩10,000",
                    isSelected = true,
                    imageURL = "",
                    onSelect = {}
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                OrderSetSelectButton(
                    text = "세트",
                    price = "₩10,000",
                    isSelected = false,
                    imageURL = "",
                    onSelect = {}
                )
                Spacer(modifier = Modifier.width(8.dp))
                OrderSetSelectButton(
                    text = "세트",
                    price = "₩10,000",
                    isSelected = true,
                    imageURL = "",
                    onSelect = {}
                )
            }
        }
    }
}
