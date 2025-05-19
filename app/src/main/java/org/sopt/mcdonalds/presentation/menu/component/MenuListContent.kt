package org.sopt.mcdonalds.presentation.menu.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toPersistentList
import org.sopt.mcdonalds.core.common.util.noRippleClickable
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme
import org.sopt.mcdonalds.domain.menu.model.Menu

@Composable
fun MenuListContent(
    menus: ImmutableList<Menu>,
    onMenuClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        itemsIndexed(
            items = menus,
            key = { _, menu -> menu.id }
        ) { _, menu ->
            MenuListItem(
                imageUrl = menu.imageUrl,
                menuName = menu.name,
                menuPrice = menu.price,
                modifier = Modifier.noRippleClickable {
                    onMenuClick(menu.id)
                }
            )
        }
    }
}

@Composable
private fun MenuListItem(
    imageUrl: String,
    menuName: String,
    menuPrice: String,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest
                    .Builder(context)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = modifier
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = menuName,
                    style = McDonaldsTheme.typography.body14b.copy(
                        color = McDonaldsTheme.colors.gray800
                    )
                )

                Text(
                    text = menuPrice,
                    style = McDonaldsTheme.typography.body14r.copy(
                        color = McDonaldsTheme.colors.gray800
                    )
                )
            }
        }

        HorizontalDivider(
            thickness = 1.dp,
            color = McDonaldsTheme.colors.gray200
        )
    }
}

@Preview
@Composable
private fun MenuListContentPreview() {
    MCDONALDSTheme {
        MenuListContent(
            menus = listOf(
                Menu(
                    id = 1,
                    name = "더블 1955® 버거",
                    price = "₩9,500 ~",
                    imageUrl = "https://example.com/bigmac.jpg"
                ),
                Menu(
                    id = 2,
                    name = "더블 맥스파이시® 상하이 버거",
                    price = "₩8,900 ~",
                    imageUrl = "https://example.com/mcchicken.jpg"
                )
            ).toPersistentList(),
            onMenuClick = {},
            modifier = Modifier.background(McDonaldsTheme.colors.white)
        )
    }
}
