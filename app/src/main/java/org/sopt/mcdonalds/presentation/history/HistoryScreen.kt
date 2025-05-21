package org.sopt.mcdonalds.presentation.history

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import java.time.LocalDateTime
import org.sopt.mcdonalds.R
import org.sopt.mcdonalds.core.designsystem.component.DefaultTopBar
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme
import org.sopt.mcdonalds.presentation.history.component.HistoryCartItem
import org.sopt.mcdonalds.presentation.history.component.HistoryMenuAddButton
import org.sopt.mcdonalds.presentation.history.component.HistoryRecentBurgerItem
import org.sopt.mcdonalds.presentation.history.component.HistoryResultBar
import org.sopt.mcdonalds.presentation.history.component.HistorySquareButton
import org.sopt.mcdonalds.presentation.history.component.HistoryStoreBar
import org.sopt.mcdonalds.presentation.history.component.HistoryTimeBar
import org.sopt.mcdonalds.presentation.history.state.HistoryContract.HistoryState

@Composable
fun HistoryRoute(
    onNavigateToMenuList: () -> Unit,
    onNavigateToOrder: (Long) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HistoryViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    HistoryScreen(
        uiState = uiState,
        onNavigateToMenuList = onNavigateToMenuList,
        onNavigateToOrder = onNavigateToOrder,
        increaseCount = viewModel::increaseCount,
        decreaseCount = viewModel::decreaseCount,
        modifier = modifier
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HistoryScreen(
    uiState: HistoryState,
    onNavigateToMenuList: () -> Unit,
    onNavigateToOrder: (Long) -> Unit,
    increaseCount: (Int) -> Unit,
    decreaseCount: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val store = stringResource(R.string.store_title)
    val density = LocalDensity.current
    var footerHeightDp by remember { mutableStateOf(0.dp) }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            userScrollEnabled = true
        ) {
            stickyHeader {
                DefaultTopBar(
                    onBackClick = onNavigateToMenuList,
                    title = stringResource(R.string.history_title),
                    modifier = Modifier.background(color = McDonaldsTheme.colors.white).fillMaxWidth()
                )
                HistoryStoreBar(
                    store = store,
                    onStoreChangeClick = { /*구현 안함*/ }
                )
            }
            item {
                HistoryTimeBar(
                    endTime = LocalDateTime.now()
                )
            }
            if (uiState.cartList.isEmpty()) {
                item {
                    Spacer(
                        modifier = Modifier.height(50.dp)
                    )
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_hamburger),
                        contentDescription = null,
                        modifier = Modifier.size(94.dp)
                    )
                    Spacer(
                        modifier = Modifier.height(21.dp)
                    )
                    Text(
                        text = stringResource(R.string.history_empty_notice),
                        color = McDonaldsTheme.colors.black,
                        style = McDonaldsTheme.typography.body14b
                    )
                }
            } else {
                itemsIndexed(
                    items = uiState.cartList,
                    key = { index, cart -> cart.cartId }
                ) { index, cart ->
                    HistoryCartItem(
                        price = cart.price,
                        count = cart.amount,
                        isSet = cart.isSet,
                        imageUrl = cart.imageUrl,
                        menuName = cart.menuName,
                        onIncrementClick = {
                            increaseCount(index)
                        },
                        onDecrementClick = {
                            decreaseCount(index)
                        },
                        onEditClick = { /*TODO*/ },
                        onDeleteClick = { /*구현 안함*/ }
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(30.dp))
                HistoryMenuAddButton(
                    text = stringResource(R.string.history_add_menu_button),
                    onClick = onNavigateToMenuList,
                    modifier = Modifier.align(Alignment.Center)
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
            if (uiState.cartList.isEmpty()) {
                item {
                    Spacer(modifier = Modifier.height(30.dp))
                    Box(modifier = Modifier.fillMaxWidth().align(Alignment.CenterStart)) {
                        Text(
                            modifier = Modifier.padding(start = 25.dp),
                            text = stringResource(R.string.history_recent_burger_title),
                            color = McDonaldsTheme.colors.black,
                            style = McDonaldsTheme.typography.body14b
                        )
                    }
                }
                itemsIndexed(
                    items = uiState.recentBurgerList,
                    key = { _, recentBurger -> recentBurger.menuId }
                ) { _, recentBurger ->
                    HistoryRecentBurgerItem(
                        price = recentBurger.menuPrice,
                        imageUrl = recentBurger.menuImage,
                        menuName = recentBurger.menuName,
                        onClick = { onNavigateToOrder(recentBurger.menuId) }
                    )
                }
            }
            item { Spacer(modifier = Modifier.height(footerHeightDp)) }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    footerHeightDp = with(density) { coordinates.size.height.toDp() }
                }
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                if (uiState.cartList.isNotEmpty()) {
                    HistoryResultBar(
                        text = stringResource(R.string.history_sum_title),
                        price = uiState.priceSum
                    )
                }
                HistorySquareButton(
                    text = stringResource(R.string.history_order_button),
                    onClick = { /*TODO*/ }
                )
            }
        }
    }
}

@Preview
@Composable
private fun HistoryScreenPreview() {
    MCDONALDSTheme {
        HistoryScreen(
            uiState = HistoryState(),
            onNavigateToMenuList = {},
            onNavigateToOrder = {},
            increaseCount = {},
            decreaseCount = {},
            modifier = Modifier.background(McDonaldsTheme.colors.white)
        )
    }
}
