package org.sopt.mcdonalds.presentation.store

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.toPersistentList
import org.sopt.mcdonalds.R.drawable.ic_map_location_64
import org.sopt.mcdonalds.R.drawable.img_map
import org.sopt.mcdonalds.core.common.util.noRippleClickable
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme
import org.sopt.mcdonalds.presentation.store.component.StoreFilterGroup
import org.sopt.mcdonalds.presentation.store.component.StoreInformationCard
import org.sopt.mcdonalds.presentation.store.component.StoreLocationFab
import org.sopt.mcdonalds.presentation.store.component.StoreTopBar
import org.sopt.mcdonalds.presentation.store.type.StoreType
import kotlin.random.Random

@Composable
fun StoreRoute(
    onNavigateToMenuList: () -> Unit,
    modifier: Modifier = Modifier
) {
    StoreScreen(
        onSelectStoreClick = onNavigateToMenuList,
        modifier = modifier
    )
}

@Composable
private fun StoreScreen(
    onSelectStoreClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isSelected by remember { mutableStateOf(false) }
    var storeTab by remember { mutableStateOf(StoreType.MCDRIVE) }
    val isBusy = Random.nextInt(2) == 1

    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .background(McDonaldsTheme.colors.white)
        ) {
            StoreTopBar(
                onCloseClick = { /* 첫 화면이기에 빈 함수 유지 */ },
                onSearchClick = { /* 추가 Action 없음 */ }
            )

            StoreFilterGroup(
                selectedStoreType = storeTab,
                storeTypes = StoreType.entries.toPersistentList(),
                onStoreTypeSelect = {
                    storeTab = it
                }
            )

            Image(
                painter = painterResource(img_map),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .noRippleClickable {
                        isSelected = true
                    },
                contentScale = ContentScale.FillHeight
            )
        }

        if (isSelected) {
            Icon(
                imageVector = ImageVector.vectorResource(ic_map_location_64),
                contentDescription = null,
                modifier = Modifier.align(Alignment.Center),
                tint = Color.Unspecified
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            StoreLocationFab(
                onClick = {},
                modifier = Modifier.padding(8.dp)
            )

            AnimatedVisibility(
                visible = isSelected,
                enter = EnterTransition.None,
                exit = ExitTransition.None
            ) {
                StoreInformationCard(
                    isBusy = isBusy,
                    onCloseClick = {
                        isSelected = false
                    },
                    onSelectStoreClick = onSelectStoreClick,
                    modifier = Modifier
                        .padding(start = 12.dp, end = 12.dp, bottom = 16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun StoreScreenPreview() {
    MCDONALDSTheme {
        StoreScreen(
            onSelectStoreClick = {},
        )
    }
}
