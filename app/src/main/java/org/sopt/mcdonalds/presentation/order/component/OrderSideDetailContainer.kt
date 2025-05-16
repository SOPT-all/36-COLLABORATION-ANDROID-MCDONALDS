package org.sopt.mcdonalds.presentation.order.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.mcdonalds.R
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme
import org.sopt.mcdonalds.presentation.order.model.Ingredient
import org.sopt.mcdonalds.presentation.order.model.Side

@Composable
fun OrderSideDetailContainer(
    text: String,
    @DrawableRes imageId: Int,
    modifier: Modifier = Modifier,
    ingredientList: List<Ingredient>,
    sideList: List<Side>,
) {
    var sideExpanded by remember { mutableStateOf(false) }
    var ingredientExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(8.dp),
                color = McDonaldsTheme.colors.gray200
            )
            .clip(RoundedCornerShape(8.dp)),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(imageId),
                contentDescription = null,
                modifier = Modifier
                    .width(76.dp)
                    .height(72.dp)
                    .padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
            )
            Spacer(modifier = Modifier.width(14.dp))
            Text(
                text = text,
                style = McDonaldsTheme.typography.body14b,
                color = McDonaldsTheme.colors.black
            )
        }
        HorizontalDivider(color = McDonaldsTheme.colors.gray200, thickness = 1.dp)
        SideChangeContainer(
            text = stringResource(R.string.order_change_side_text),
            isExpanded = sideExpanded,
            toggle = { sideExpanded = !sideExpanded },
            sideList = sideList
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
            "후렌치 후라이",
            R.drawable.img_side_fries,
            ingredientList = listOf(
                Ingredient(
                    name = "소금",
                    amount = remember { mutableStateOf(1) }
                )
            ),
            sideList = listOf(
                Side(
                    name = "코울슬로",
                    imageId = R.drawable.img_side_coleslaw
                )
            )
        )
    }
}