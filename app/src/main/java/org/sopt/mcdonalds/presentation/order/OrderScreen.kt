package org.sopt.mcdonalds.presentation.order

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import kotlinx.collections.immutable.persistentListOf
import org.sopt.mcdonalds.R
import org.sopt.mcdonalds.core.designsystem.component.BorderedNumberIncrementer
import org.sopt.mcdonalds.core.designsystem.component.DefaultTopBar
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme
import org.sopt.mcdonalds.presentation.order.component.OrderBurgerDetailContainer
import org.sopt.mcdonalds.presentation.order.component.OrderButton
import org.sopt.mcdonalds.presentation.order.component.OrderSetSelector
import org.sopt.mcdonalds.presentation.order.component.OrderSideDetailContainer
import org.sopt.mcdonalds.presentation.order.model.Ingredient
import org.sopt.mcdonalds.presentation.order.model.Side
import org.sopt.mcdonalds.presentation.order.state.OrderContract.OrderSideEffect.NavigateToHistory
import org.sopt.mcdonalds.presentation.order.state.OrderContract.OrderSideEffect.NavigateToMenuList
import org.sopt.mcdonalds.presentation.order.state.OrderContract.OrderState
import org.sopt.mcdonalds.presentation.order.type.OrderType
import org.sopt.mcdonalds.presentation.order.type.SetType

@Composable
fun OrderRoute(
    onBackClick: () -> Unit,
    onNavigateToHistory: () -> Unit,
    onNavigateToMenuList: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: OrderViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is NavigateToHistory -> onNavigateToHistory()
                    is NavigateToMenuList -> onNavigateToMenuList()
                }
            }
    }

    OrderScreen(
        uiState = uiState,
        updateSetType = viewModel::updateSetType,
        increaseBurgerCount = viewModel::increaseBurgerCount,
        decreaseBurgerCount = viewModel::decreaseBurgerCount,
        onBackClick = onBackClick,
        onClickOrderButton = viewModel::onClickOrderButton,
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
    onClickOrderButton: (OrderType) -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        DefaultTopBar(
            onBackClick = onBackClick,
            modifier = Modifier
                .fillMaxWidth(),
        )

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .verticalScroll(scrollState)
            ) {
                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = uiState.menuDetail.name,
                    style = McDonaldsTheme.typography.head34b,
                    color = McDonaldsTheme.colors.gray800
                )

                Spacer(modifier = Modifier.height(28.dp))

                OrderSetSelector(
                    menuDetail = uiState.menuDetail,
                    isSetSelected = uiState.setType == SetType.SET,
                    onSelect = { type ->
                        updateSetType(type)
                    }
                )

                Spacer(modifier = Modifier.height(24.dp))

                OrderBurgerDetailContainer(
                    name = uiState.menuDetail.name,
                    imageId = R.drawable.img_burger_single
                )

                if (uiState.setType == SetType.SET) {
                    Spacer(modifier = Modifier.height(16.dp))

                    OrderSideDetailContainer(
                        ingredientList = persistentListOf(
                            Ingredient(
                                name = "소금",
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

                    Spacer(modifier = Modifier.height(16.dp))

                    OrderSideDetailContainer(
                        ingredientList = persistentListOf(
                            Ingredient(
                                name = "얼음",
                                amount = remember { mutableStateOf(1) }
                            )
                        ),
                        sideList = persistentListOf(
                            Side(
                                name = stringResource(R.string.order_drink_sprite),
                                imageId = R.drawable.img_drink_sprite
                            ),
                            Side(
                                name = stringResource(R.string.order_drink_mango_ice_tea),
                                imageId = R.drawable.img_drink_mango_icetea
                            ),
                            Side(
                                name = stringResource(R.string.order_drink_peach_ice_tea),
                                imageId = R.drawable.img_drink_peach_icetea
                            ),
                            Side(
                                name = stringResource(R.string.order_drink_coke),
                                imageId = R.drawable.img_drink_coke
                            ),
                            Side(
                                name = stringResource(R.string.order_drink_fanta),
                                imageId = R.drawable.img_drink_fanta
                            ),
                            Side(
                                name = stringResource(R.string.order_drink_zero_coke),
                                imageId = R.drawable.img_drink_zero_coke
                            )
                        )
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                BorderedNumberIncrementer(
                    count = uiState.burgerCount,
                    onIncrementClick = increaseBurgerCount,
                    onDecrementClick = { if (uiState.burgerCount > 0) decreaseBurgerCount() },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(144.dp)
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
                        imageVector = ImageVector.vectorResource(R.drawable.ic_right_chevron),
                        contentDescription = null,
                        tint = McDonaldsTheme.colors.gray500
                    )
                }

                Spacer(modifier = Modifier.height(86.dp))
            }

            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .height(58.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OrderButton(
                    text = stringResource(R.string.order_order_button),
                    onClick = { onClickOrderButton(OrderType.ORDER_NOW) },
                    color = McDonaldsTheme.colors.white,
                    modifier = Modifier.weight(1f)
                )

                OrderButton(
                    text = stringResource(R.string.order_cart_button),
                    onClick = { onClickOrderButton(OrderType.ADD_TO_CART) },
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
    var count by remember { mutableStateOf(1) }
    MCDONALDSTheme {
        OrderScreen(
            uiState = OrderState(),
            updateSetType = {},
            increaseBurgerCount = { count++ },
            decreaseBurgerCount = { if (count > 0) count-- },
            onBackClick = {},
            onClickOrderButton = {},
            modifier = Modifier.background(McDonaldsTheme.colors.white)
        )
    }
}
