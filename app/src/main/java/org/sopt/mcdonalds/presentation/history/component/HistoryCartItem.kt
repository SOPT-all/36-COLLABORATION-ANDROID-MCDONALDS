package org.sopt.mcdonalds.presentation.history.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import java.text.DecimalFormat
import org.sopt.mcdonalds.R
import org.sopt.mcdonalds.core.common.util.noRippleClickable
import org.sopt.mcdonalds.core.designsystem.component.BorderedNumberIncrementer
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme

/**
 * 주문내역 페이지 속에서 장바구니 리스트의 아이템 뷰
 *
 * @param price 메뉴의 가격
 * @param count 메뉴의 개수
 * @param isSet 메뉴의 세트 여뷰
 * @param imageUrl 메뉴의 이미지 URL
 * @param menuName 메뉴의 이름
 * @param onIncrementClick + 클릭 시 이벤트
 * @param onDecrementClick - 클릭 시 이벤트
 * @param onEditClick 수정 버튼 클릭 시 이벤트
 * @param onDeleteClick 삭제 버튼 클릭 시 이벤트
 * @param modifier 수정자
 */
@Composable
fun HistoryCartItem(
    price: Int,
    count: Int,
    isSet: Boolean,
    imageUrl: String,
    menuName: String,
    onIncrementClick: () -> Unit,
    onDecrementClick: () -> Unit,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(17.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(19.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = if (isSet) "$menuName - 세트" else menuName,
                            style = McDonaldsTheme.typography.body14b,
                            color = McDonaldsTheme.colors.black
                        )
                        Column {
                            Text(
                                text = menuName,
                                style = McDonaldsTheme.typography.body14r,
                                color = McDonaldsTheme.colors.gray600
                            )
                            if (isSet) {
                                Text(
                                    text = stringResource(R.string.history_fries_default_option),
                                    style = McDonaldsTheme.typography.body14r,
                                    color = McDonaldsTheme.colors.gray600
                                )
                                Text(
                                    text = stringResource(R.string.history_drink_default_option),
                                    style = McDonaldsTheme.typography.body14r,
                                    color = McDonaldsTheme.colors.gray600
                                )
                                Text(
                                    text = stringResource(
                                        R.string.history_ingredient_default_option
                                    ),
                                    style = McDonaldsTheme.typography.body14r,
                                    color = McDonaldsTheme.colors.gray600
                                )
                            }
                        }
                    }
                    AsyncImage(
                        modifier = Modifier
                            .sizeIn(
                                maxWidth = 100.dp,
                                maxHeight = 100.dp
                            ),
                        model = ImageRequest
                            .Builder(context = context)
                            .data(imageUrl)
                            .crossfade(true)
                            .build(),
                        contentDescription = null
                    )
                }
                Text(
                    text = "₩" + DecimalFormat("#,###").format(price),
                    style = McDonaldsTheme.typography.body14r,
                    color = McDonaldsTheme.colors.black
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BorderedNumberIncrementer(
                    count = count,
                    onIncrementClick = onIncrementClick,
                    onDecrementClick = onDecrementClick,
                    modifier = Modifier.width(88.dp),
                    textStyle = McDonaldsTheme.typography.body16sb,
                    paddingValues = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    HistoryCircleButton(
                        icon = R.drawable.ic_edit_28,
                        onClick = onEditClick
                    )
                    HistoryCircleButton(
                        icon = R.drawable.ic_delete_28,
                        onClick = onDeleteClick
                    )
                }
            }
        }
        HorizontalDivider(
            thickness = 1.dp,
            color = McDonaldsTheme.colors.gray200
        )
    }
}

@Composable
private fun HistoryCircleButton(
    @DrawableRes icon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(width = 42.dp, height = 42.dp)
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(percent = 100)
            )
            .border(
                width = 1.dp,
                color = McDonaldsTheme.colors.gray200,
                shape = RoundedCornerShape(percent = 100)
            )
            .noRippleClickable(onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = null,
            tint = McDonaldsTheme.colors.black
        )
    }
}

@Preview
@Composable
private fun HistoryCartItemPreview() {
    var num1 by remember { mutableStateOf(0) }

    MCDONALDSTheme {
        HistoryCartItem(
            price = 11500,
            count = num1,
            isSet = true,
            imageUrl = "",
            menuName = "더블 1955® 버거",
            onIncrementClick = { num1++ },
            onDecrementClick = { num1-- },
            onEditClick = {},
            onDeleteClick = {}
        )
    }
}
