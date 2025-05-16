package org.sopt.mcdonalds.presentation.order.component

import android.icu.text.DecimalFormat
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
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(150.dp)
            .height(204.dp)
            .background(
                color = if (isSelected) {
                    McDonaldsTheme.colors.lightYellow
                } else {
                    McDonaldsTheme.colors.white
                },
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                color = if (isSelected) {
                    McDonaldsTheme.colors.yellow
                } else {
                    McDonaldsTheme.colors.gray200
                },
                width = 1.dp,
                shape = RoundedCornerShape(8.dp)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        AsyncImage(
            model = imageURL,
            contentDescription = "햄버거 세트",
            modifier = Modifier
                .padding(top = 15.dp, start = 15.dp, end = 15.dp)
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
    }
}

@Preview(showBackground = true)
@Composable
fun OrderSetSelectButtonPreview() {
    Column {
        Row {
            OrderSetSelectButton(
                "단품",
                "₩10,000",
                false,
                ""
            )
            Spacer(modifier = Modifier.width(8.dp))
            OrderSetSelectButton(
                "단품",
                "₩10,000",
                true,
                ""
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            OrderSetSelectButton(
                "세트",
                "₩10,000",
                false,
                ""
            )
            Spacer(modifier = Modifier.width(8.dp))
            OrderSetSelectButton(
                "세트",
                "₩10,000",
                true,
                ""
            )
        }
    }
}
