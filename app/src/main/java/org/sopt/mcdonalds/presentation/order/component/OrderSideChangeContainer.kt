package org.sopt.mcdonalds.presentation.order.component

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.mcdonalds.R
import org.sopt.mcdonalds.core.common.util.noRippleClickable
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme
import org.sopt.mcdonalds.presentation.order.model.Side

/**
 * Side Change Container
 * 주문하기에서 사이드를 변경하는 컴포넌트
 *
 * @param text 컨테이너에 들어갈 텍스트
 * @param isExpanded 재료 리스트가 나오는지 여부
 * @param toggle 확장 여부
 * @param sideList 확장 시 보여줄 재료 리스트
 * @param onSelect 변경할 사이드를 선택할 때 실행되는 함수
 * @param modifier 수정자
 */

@Composable
fun SideChangeContainer(
    text: String,
    isExpanded: Boolean,
    toggle: () -> Unit,
    sideList: List<Side>,
    onSelect: (Side) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 16.dp, top = 10.dp, bottom = 10.dp)
                .noRippleClickable(toggle),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = text,
                style = McDonaldsTheme.typography.body14r,
                color = McDonaldsTheme.colors.black
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_down_chevron_20),
                contentDescription = null,
                tint = McDonaldsTheme.colors.gray800
            )
        }

        HorizontalDivider(color = McDonaldsTheme.colors.gray200, thickness = 1.dp)

        AnimatedVisibility(
            visible = isExpanded
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                sideList.forEach { side ->
                    SideContainer(
                        text = side.name,
                        imageId = side.imageId,
                        onClick = {
                            onSelect(side)
                        }
                    )
                }
            }
        }
    }
}

/**
 * Side Container
 * 사이드 변경에서 확장시 나오는 사이드 컴포넌트
 *
 * @param text 재료 이름
 * @param imageId 사이드 메뉴 이미지
 * @param onClick 선택될 때 실행되는 함수
 * @param modifier 수정자
 */

@Composable
private fun SideContainer(
    text: String,
    @DrawableRes imageId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() },
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(imageId),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 24.dp, top = 4.dp, bottom = 4.dp)
                    .width(40.dp)
                    .height(40.dp)
            )
            Spacer(modifier = Modifier.width(32.dp))
            Text(
                text = text,
                style = McDonaldsTheme.typography.body12r,
                color = McDonaldsTheme.colors.black
            )
        }
        HorizontalDivider(color = McDonaldsTheme.colors.gray200, thickness = 1.dp)
    }
}

@Preview(showBackground = true)
@Composable
private fun SideChangeContainerPreview() {
    MCDONALDSTheme {
        var isExpanded by remember { mutableStateOf(false) }
        SideChangeContainer(
            text = stringResource(R.string.order_change_side_text),
            isExpanded = isExpanded,
            toggle = { isExpanded = !isExpanded },
            sideList = listOf(
                Side(
                    name = stringResource(R.string.order_side_coleslaw),
                    imageId = R.drawable.img_side_coleslaw
                )
            ),
            onSelect = {}
        )
    }
}
