package org.sopt.mcdonalds.presentation.history.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import org.sopt.mcdonalds.core.common.util.noRippleClickable
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme

/**
 * 주문내역 페이지 속에서 최근 주문한 메뉴 리스트의 아이템 뷰
 *
 * @param price 메뉴의 가격
 * @param imageUrl 메뉴의 이미지 URL
 * @param menuName 메뉴의 이름
 * @param onClick 뷰 클릭 시 이벤트
 * @param modifier 수정자
 */
@Composable
fun HistoryRecentBurgerItem(
    price: String,
    imageUrl: String,
    menuName: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 21.dp, vertical = 18.dp)
                .noRippleClickable(onClick),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .sizeIn(
                        maxWidth = 69.dp,
                        maxHeight = 54.dp
                    ),
                model = ImageRequest
                    .Builder(context = context)
                    .data(imageUrl)
                    .build(),
                contentDescription = null
            )
            Column(
                modifier = modifier
                    .padding(horizontal = 0.dp, vertical = 4.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = menuName,
                    style = McDonaldsTheme.typography.body14b,
                    color = McDonaldsTheme.colors.gray800
                )
                Text(
                    text = price,
                    style = McDonaldsTheme.typography.body14r,
                    color = McDonaldsTheme.colors.gray800
                )
            }
        }
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 0.5.dp,
            color = McDonaldsTheme.colors.gray200
        )
    }
}

@Preview
@Composable
private fun HistoryRecentBurgerItemPreview() {
    MCDONALDSTheme {
        HistoryRecentBurgerItem(
            price = "₩8,300 ~",
            imageUrl = "",
            menuName = "더블 1955® 버거",
            onClick = {}
        )
    }
}
