package org.sopt.mcdonalds.presentation.order

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.persistentListOf
import org.sopt.mcdonalds.R
import org.sopt.mcdonalds.core.designsystem.component.BorderedNumberIncrementer
import org.sopt.mcdonalds.core.designsystem.component.DefaultTopBar
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme
import org.sopt.mcdonalds.presentation.order.component.OrderBurgerDetailContainer
import org.sopt.mcdonalds.presentation.order.component.OrderButton
import org.sopt.mcdonalds.presentation.order.component.OrderSetSelectButton
import org.sopt.mcdonalds.presentation.order.component.OrderSideDetailContainer
import org.sopt.mcdonalds.presentation.order.model.Side
import org.sopt.mcdonalds.presentation.order.type.OrderType

@Composable
fun OrderRoute(
    modifier: Modifier = Modifier
) {
    OrderScreen(
        modifier = modifier
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun OrderScreen(
    modifier: Modifier = Modifier
) {
    var setType by remember { mutableStateOf(OrderType.SET) }
    var burgerCount by remember { mutableStateOf(1) }

    Scaffold(
        modifier = modifier,
        topBar = {
            DefaultTopBar(
                onBackClick = {/* TODO */ }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "더블 1955® 버거",/* TODO: 나중에 수정 */
                    style = McDonaldsTheme.typography.head34b,
                    color = McDonaldsTheme.colors.gray800,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(28.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OrderSetSelectButton(
                        text = stringResource(R.string.order_change_set),
                        price = "",
                        isSelected = setType == OrderType.SET,
                        imageURL = "",
                        onSelect = { setType = OrderType.SET }
                    )
                    OrderSetSelectButton(
                        text = stringResource(R.string.order_change_single),
                        price = "",
                        isSelected = setType == OrderType.SINGLE,
                        imageURL = "",
                        onSelect = { setType = OrderType.SINGLE }
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                OrderBurgerDetailContainer(
                    name = "",
                    imageId = R.drawable.img_burger_single,
                    ingredientList = persistentListOf(),
                )
                Spacer(modifier = Modifier.height(16.dp))
                OrderSideDetailContainer(
                    ingredientList = persistentListOf(),
                    sideList = persistentListOf(
                        Side(
                            name = stringResource(R.string.order_side_french_fries),
                            imageId = R.drawable.img_side_fries
                        ),
                        Side(
                            name = stringResource(R.string.order_side_coleslaw),
                            imageId = R.drawable.img_side_coleslaw
                        )
                    ),
                )
                Spacer(modifier = Modifier.height(16.dp))
                OrderSideDetailContainer(
                    ingredientList = persistentListOf(),
                    sideList = persistentListOf(
                        Side(
                            name = stringResource(R.string.order_drink_sprite),
                            imageId = R.drawable.img_drink_sprite
                        ),
                        Side(
                            name = stringResource(R.string.order_drink_coke),
                            imageId = R.drawable.img_drink_coke
                        ),
                        Side(
                            name = stringResource(R.string.order_drink_zero_coke),
                            imageId = R.drawable.img_drink_zero_coke
                        ),
                    ),
                )
                Spacer(modifier = Modifier.height(24.dp))
                BorderedNumberIncrementer(
                    count = burgerCount,
                    onIncrementClick = { burgerCount++ },
                    onDecrementClick = { if (burgerCount > 0) burgerCount-- },
                    modifier = Modifier
                        .width(145.dp)
                        .height(40.dp)
                )
                Spacer(modifier = Modifier.height(34.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.order_product_info),
                        style = McDonaldsTheme.typography.body14r,
                        color = McDonaldsTheme.colors.gray500
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Icon(
                        painter = painterResource(R.drawable.ic_right_chevron),
                        contentDescription = null,
                        tint = McDonaldsTheme.colors.gray500
                    )
                }
            }
            Spacer(modifier = Modifier.height(36.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                OrderButton(
                    text = stringResource(R.string.order_order_button),
                    onClick = { /* TODO */ },
                    color = McDonaldsTheme.colors.white,
                    modifier = Modifier.weight(1f)
                )
                OrderButton(
                    text = stringResource(R.string.order_cart_button),
                    onClick = { /* TODO */ },
                    color = McDonaldsTheme.colors.yellow,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Preview
@Composable
private fun OrderScreenPreview() {
    MCDONALDSTheme {
        OrderScreen(modifier = Modifier.background(McDonaldsTheme.colors.white))
    }
}