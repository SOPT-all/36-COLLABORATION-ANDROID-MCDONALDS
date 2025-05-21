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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.collections.immutable.persistentListOf
import org.sopt.mcdonalds.R
import org.sopt.mcdonalds.core.designsystem.component.BorderedNumberIncrementer
import org.sopt.mcdonalds.core.designsystem.component.DefaultTopBar
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme
import org.sopt.mcdonalds.domain.menu.model.MenuDetail
import org.sopt.mcdonalds.presentation.order.component.OrderBurgerDetailContainer
import org.sopt.mcdonalds.presentation.order.component.OrderButton
import org.sopt.mcdonalds.presentation.order.component.OrderSetSelectButton
import org.sopt.mcdonalds.presentation.order.component.OrderSideDetailContainer
import org.sopt.mcdonalds.presentation.order.model.Side
import org.sopt.mcdonalds.presentation.order.state.OrderContract.OrderState
import org.sopt.mcdonalds.presentation.order.type.SetType

@Composable
fun OrderRoute(
    onBackClick: () -> Unit,
    onNavigateToHistory: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: OrderViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    OrderScreen(
        uiState = uiState,
        updateSetType = viewModel::updateSetType,
        increaseBurgerCount = viewModel::increaseBurgerCount,
        decreaseBurgerCount = viewModel::decreaseBurgerCount,
        onBackClick = onBackClick,
        onNavigateToHistory = onNavigateToHistory,
        modifier = modifier
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun OrderScreen(
    uiState: OrderState,
    updateSetType: (SetType) -> Unit,
    increaseBurgerCount: () -> Unit,
    decreaseBurgerCount: () -> Unit,
    onBackClick: () -> Unit,
    onNavigateToHistory: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
    ) {
        DefaultTopBar(
            onBackClick = onBackClick
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = uiState.menuDetail.name,
                style = McDonaldsTheme.typography.head34b,
                color = McDonaldsTheme.colors.gray800,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(28.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OrderSetSelectButton(
                    text = stringResource(R.string.order_change_set),
                    price = "",
                    isSelected = uiState.setType == SetType.SET,
                    imageURL = "",
                    onSelect = { updateSetType(SetType.SET) }
                )
                OrderSetSelectButton(
                    text = stringResource(R.string.order_change_single),
                    price = "",
                    isSelected = uiState.setType == SetType.SINGLE,
                    imageURL = "",
                    onSelect = { updateSetType(SetType.SINGLE) }
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            OrderBurgerDetailContainer(
                name = "",
                imageId = R.drawable.img_burger_single,
                ingredientList = persistentListOf(),
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            )
            if (uiState.setType == SetType.SET) {
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
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
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
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            BorderedNumberIncrementer(
                count = uiState.burgerCount,
                onIncrementClick = { increaseBurgerCount() },
                onDecrementClick = { if (uiState.burgerCount > 0) decreaseBurgerCount() },
                modifier = Modifier
                    .width(145.dp)
                    .height(40.dp)
            )
            Spacer(modifier = Modifier.height(34.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
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
private fun OrderScreenPreview(
) {
    var count by remember { mutableStateOf(1) }
    MCDONALDSTheme {
        OrderScreen(
            uiState = OrderState(
                menuDetail = MenuDetail(
                    id = 0,
                    name = "",
                    singleImg = "",
                    singlePrice = "",
                    setImg = "",
                    setPrice = ""
                )
            ),
            updateSetType = {},
            increaseBurgerCount = { count++ },
            decreaseBurgerCount = { if (count > 0) count-- },
            onBackClick = {},
            onNavigateToHistory = {},
            modifier = Modifier.background(McDonaldsTheme.colors.white)
        )
    }
}