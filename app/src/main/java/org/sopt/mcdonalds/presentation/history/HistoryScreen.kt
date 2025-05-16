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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime
import kotlinx.collections.immutable.persistentListOf
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
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
import org.sopt.mcdonalds.presentation.history.model.Cart
import org.sopt.mcdonalds.presentation.history.model.RecentBurger

@Composable
fun HistoryRoute(
    modifier: Modifier = Modifier
){
    HistoryScreen(
        modifier = modifier
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HistoryScreen (
    modifier: Modifier = Modifier,
    carts: List<Cart> = persistentListOf<Cart>(),
    recentBurgers: List<RecentBurger> = persistentListOf<RecentBurger>()
) {
    val store = "양평SK DT"
    var priceSum by remember { mutableStateOf(0) }
    var cartList by remember { mutableStateOf(carts.toMutableList()) }
    val density = LocalDensity.current
    var footerHeightDp by remember { mutableStateOf(0.dp) }

    LaunchedEffect (cartList) {
        priceSum = cartList.sumOf { it.price * it.amount }
    }

    Box(
        modifier = modifier.fillMaxSize()
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            userScrollEnabled = true
        ) {
            stickyHeader {
                DefaultTopBar(
                    onBackClick = {/*TODO*/},
                    title = "주문내역",
                    modifier = Modifier.background(color = McDonaldsTheme.colors.white).fillMaxWidth()
                )
                HistoryStoreBar(
                    store = store,
                    onStoreChangeClick = {/*TODO*/}
                )
            }
            item {
                HistoryTimeBar(
                    endTime = LocalDateTime.now()
                )
            }
            if(carts.isEmpty()){
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
                        text = "장바구니가 비었어요.",
                        color = McDonaldsTheme.colors.black,
                        style = McDonaldsTheme.typography.body14b
                    )
                }
            }
            else{
                itemsIndexed(
                    items = cartList,
                    key = { index, cart -> cart.cartId }
                ) { index, cart ->
                    HistoryCartItem(
                        price = cart.price,//TODO 서버 요청해야함
                        count = cart.amount,
                        isSet = cart.isSet,
                        imageUrl = cart.imageUrl,
                        menuName = cart.menuName,
                        onIncrementClick = {
                            cartList = cartList.toMutableList().also {
                                it[index] = it[index].copy(amount = it[index].amount + 1)
                            }
                        },
                        onDecrementClick = {
                            cartList = cartList.toMutableList().also {
                                it[index] = it[index].copy(amount = maxOf(1, it[index].amount - 1))
                            }
                        },
                        onEditClick = {/*TODO*/},
                        onDeleteClick = {/*TODO*/},
                    )
                }
            }
            item {
                Spacer(modifier = Modifier.height(30.dp))
                HistoryMenuAddButton(
                    text = "메뉴 추가",
                    onClick = {/*TODO*/},
                    modifier = Modifier.align(Alignment.Center)
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
            if(carts.isEmpty()){
                item{
                    Spacer(modifier = Modifier.height(30.dp))
                    Box(modifier = Modifier.fillMaxWidth().align(Alignment.CenterStart)){
                        Text(modifier = Modifier.padding(start = 25.dp), text = "최근에 주문한 버거", color = McDonaldsTheme.colors.black, style = McDonaldsTheme.typography.body14b)
                    }
                }
                itemsIndexed(
                    items = recentBurgers,
                    key = { _, recentBurger -> recentBurger.menuId }
                ) { _, recentBurger ->
                    HistoryRecentBurgerItem(
                        price = recentBurger.menuPrice,
                        imageUrl = recentBurger.menuImage,
                        menuName = recentBurger.menuName,
                        onClick = {/*TODO*/},
                    )
                }
            }
            item{ Spacer(modifier = Modifier.height(footerHeightDp)) }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    footerHeightDp = with(density) { coordinates.size.height.toDp() }
                }
        ){
            Column (
                modifier = Modifier.fillMaxWidth()
            ) {
                if(carts.isNotEmpty()) {
                    HistoryResultBar(
                        text = "주문 금액",
                        price = priceSum
                    )
                }
                HistorySquareButton(
                    text = "제품 수령 장소 선택",
                    onClick = {/*TODO*/}
                )
            }
        }

    }
}

@Preview
@Composable
private fun HistoryScreenEmptyPreview(){
    MCDONALDSTheme {
        HistoryScreen(
            modifier = Modifier.background(McDonaldsTheme.colors.white),
            recentBurgers = listOf(
                RecentBurger(menuId = 1, menuName = "더블 1995® 버거", menuPrice = "₩8,300 ~", menuImage = ""),
                RecentBurger(menuId = 2, menuName = "더블 1995® 버거", menuPrice = "₩8,300 ~", menuImage = ""),
                RecentBurger(menuId = 3, menuName = "더블 1995® 버거", menuPrice = "₩8,300 ~", menuImage = ""),
                RecentBurger(menuId = 4, menuName = "더블 1995® 버거", menuPrice = "₩8,300 ~", menuImage = ""),
                RecentBurger(menuId = 5, menuName = "더블 1995® 버거", menuPrice = "₩8,300 ~", menuImage = ""),
            )
        )
    }
}

@Preview
@Composable
private fun HistoryScreenNotEmptyPreview(){
    MCDONALDSTheme {
        HistoryScreen(
            modifier = Modifier.background(McDonaldsTheme.colors.white),
            carts = listOf(
                Cart(cartId = 1, menuName = "더블 1995® 버거", amount = 2, price = 5500, isSet = true, imageUrl = ""),
                Cart(cartId = 2, menuName = "더블 1995® 버거", amount = 2, price = 5500, isSet = true, imageUrl = ""),
                Cart(cartId = 3, menuName = "더블 1995® 버거", amount = 2, price = 5500, isSet = true, imageUrl = ""),
                Cart(cartId = 4, menuName = "더블 1995® 버거", amount = 1, price = 3500, isSet = false, imageUrl = "")
            )
        )
    }
}