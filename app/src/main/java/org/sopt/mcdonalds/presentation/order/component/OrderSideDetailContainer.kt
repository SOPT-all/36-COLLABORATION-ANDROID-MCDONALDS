package org.sopt.mcdonalds.presentation.order.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.mcdonalds.R
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme
import org.sopt.mcdonalds.presentation.order.model.Ingredient
import org.sopt.mcdonalds.presentation.order.model.Side

/**
 * Order Side Detail Container
 * 주문하기에서 사이드 상세 주문 컴포넌트
 *
 * @param ingredientList 재료 리스트
 * @param sideList 사이드 메뉴 리스트
 * @param modifier 수정자
 */

@Composable
fun OrderSideDetailContainer(
    ingredientList: ImmutableList<Ingredient>,
    sideList: ImmutableList<Side>,
    modifier: Modifier = Modifier
) {
    var sideExpanded by remember { mutableStateOf(false) }
    var ingredientExpanded by remember { mutableStateOf(false) }

    var selectedSide by remember { mutableStateOf(sideList.first()) }
    val remainSideList = sideList.filter { it != selectedSide }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(8.dp),
                color = McDonaldsTheme.colors.gray200
            )
            .clip(RoundedCornerShape(8.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Image(
                painter = painterResource(selectedSide.imageId),
                contentDescription = null,
                modifier = Modifier.width(76.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = selectedSide.name,
                style = McDonaldsTheme.typography.body14b,
                color = McDonaldsTheme.colors.black
            )
        }

        HorizontalDivider(color = McDonaldsTheme.colors.gray200, thickness = 1.dp)

        SideChangeContainer(
            text = stringResource(R.string.order_change_side_text),
            isExpanded = sideExpanded,
            toggle = { sideExpanded = !sideExpanded },
            sideList = remainSideList,
            onSelect = { selectedSide = it }
        )

        IngredientChangeContainer(
            text = stringResource(R.string.order_change_ingredient_text),
            isExpanded = ingredientExpanded,
            toggle = { ingredientExpanded = !ingredientExpanded },
            ingredientList = ingredientList
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun OrderSideDetailContainerPreview() {
    MCDONALDSTheme {
        OrderSideDetailContainer(
            ingredientList = persistentListOf(
                Ingredient(
                    name = stringResource(R.string.order_ingredient_salt),
                    amount = remember { mutableStateOf(1) }
                )
            ),
            sideList = persistentListOf(
                Side(
                    name = stringResource(R.string.order_side_french_fries),
                    imageId = R.drawable.img_side_fries
                ),
                Side(
                    name = stringResource(R.string.order_side_coleslaw),
                    imageId = R.drawable.img_side_coleslaw
                )
            )
        )
    }
}
