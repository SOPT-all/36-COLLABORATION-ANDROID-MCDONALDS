package org.sopt.mcdonalds.presentation.history

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.LocalDateTime
import kotlinx.collections.immutable.persistentListOf
import org.sopt.mcdonalds.R
import org.sopt.mcdonalds.core.designsystem.component.DefaultTopBar
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme
import org.sopt.mcdonalds.presentation.history.component.HistoryMenuAddButton
import org.sopt.mcdonalds.presentation.history.component.HistoryResultBar
import org.sopt.mcdonalds.presentation.history.component.HistorySquareButton
import org.sopt.mcdonalds.presentation.history.component.HistoryStoreBar
import org.sopt.mcdonalds.presentation.history.component.HistoryTimeBar

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
    modifier: Modifier = Modifier
) {
    val store = "양평SK DT"
    var priceSum by remember { mutableStateOf(0) }
    val carts = persistentListOf<String>();
    Box(
        modifier = modifier
            .background(color = McDonaldsTheme.colors.white)
    ){
        LazyColumn(
            modifier = modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            stickyHeader {
                DefaultTopBar(
                    onBackClick = {/*TODO*/},
                    title = "주문내역"
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

            }

            item {
                Spacer(
                    modifier = Modifier.height(30.dp)
                )
                HistoryMenuAddButton(
                    text = "메뉴 추가",
                    onClick = {/*TODO*/},
                    modifier = Modifier.align(Alignment.Center)
                )
            }

        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ){
            Column (
                modifier = Modifier.fillMaxWidth()
            ) {
                HistoryResultBar(
                    text = "주문 금액",
                    price = priceSum
                )
                HistorySquareButton(
                    text = "제품 수령 장소 선택",
                    onClick = {/*TODO*/}
                )
            }
        }
    }
}

@Preview(widthDp = 360, heightDp = 824)
@Composable
fun HistoryScreenPreview(){
    MCDONALDSTheme {
        HistoryScreen(

        )
    }
}