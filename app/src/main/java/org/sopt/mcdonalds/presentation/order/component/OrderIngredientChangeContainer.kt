package org.sopt.mcdonalds.presentation.order.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.mcdonalds.R
import org.sopt.mcdonalds.core.designsystem.component.NumberIncrementer
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme
import org.sopt.mcdonalds.presentation.order.model.Ingredient

/**
 * Ingredient Change Container
 * 주문하기에서 버거나 사이드의 재료를 변경하는 컴포넌트
 *
 * @param text 컨테이너에 들어갈 텍스트
 * @param isExpanded 재료 리스트가 나오는지 여부
 * @param toggle 확장 여부
 * @param ingredientList 확장 시 보여줄 재료 리스트
 * @param modifier 수정자
 */

@Composable
fun IngredientChangeContainer(
    text: String,
    isExpanded: Boolean,
    toggle: () -> Unit,
    ingredientList: List<Ingredient>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.clipToBounds(),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = text,
                style = McDonaldsTheme.typography.body14r,
                color = McDonaldsTheme.colors.black,
                modifier = Modifier.padding(start = 24.dp, top = 10.dp, bottom = 10.dp)
            )
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_down_chevron_20),
                contentDescription = null,
                tint = McDonaldsTheme.colors.gray800,
                modifier = Modifier
                    .padding(end = 16.dp, top = 10.dp, bottom = 10.dp)
                    .clickable(onClick = toggle)
            )
        }
        HorizontalDivider(color = McDonaldsTheme.colors.gray200, thickness = 1.dp)
        IngredientListContainer(
            isExpanded = isExpanded,
            ingredientList = ingredientList
        )
    }
}

/**
 * Ingredient List Container
 * 재료 변경에서 확장시 나오는 재료리스트 컴포넌트
 *
 * @param isExpanded 확장 여부
 * @param ingredientList 재료 리스트
 * @param modifier 수정자
 */

@Composable
fun IngredientListContainer(
    isExpanded: Boolean,
    ingredientList: List<Ingredient>,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.clipToBounds()) {
        AnimatedVisibility(
            visible = isExpanded,
            enter = slideInVertically(initialOffsetY = { -it }),
            exit = slideOutVertically(targetOffsetY = { -it })
        ) {
            Column {
                ingredientList.forEach { ingredient ->
                    IngredientContainer(
                        text = ingredient.name,
                        amount = ingredient.amount
                    )
                }
            }
        }
    }
}

/**
 * Ingredient Container
 * 재료 변경에서 확장시 나오는 재료 컴포넌트
 *
 * @param text 재료 이름
 * @param amount 재료 양
 * @param modifier 수정자
 */

@Composable
fun IngredientContainer(
    text: String,
    amount: MutableState<Int>,
    modifier: Modifier = Modifier
) {
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = text,
                style = McDonaldsTheme.typography.body12r,
                color = McDonaldsTheme.colors.black,
                modifier = Modifier.padding(start = 24.dp, top = 9.dp, bottom = 9.dp)
            )
            NumberIncrementer(
                count = amount.value,
                onIncrementClick = { if (amount.value in 0..9) amount.value++ },
                onDecrementClick = { if (amount.value in 1..10) amount.value-- },
                modifier = Modifier
                    .width(70.dp)
                    .padding(end = 20.dp, top = 9.dp, bottom = 9.dp)
            )
        }
        HorizontalDivider(color = McDonaldsTheme.colors.gray200, thickness = 1.dp)
    }
}

@Preview(showBackground = false)
@Composable
private fun IngredientChangeContainerPreview() {
    MCDONALDSTheme {
        var isExpanded by remember { mutableStateOf(false) }
        IngredientChangeContainer(
            text = stringResource(R.string.order_change_ingredient_text),
            isExpanded = isExpanded,
            toggle = { isExpanded = !isExpanded },
            ingredientList = listOf(
                Ingredient(
                    name = stringResource(R.string.order_ingredient_onion),
                    amount = remember { mutableStateOf(1) }
                )
            )
        )
    }
}