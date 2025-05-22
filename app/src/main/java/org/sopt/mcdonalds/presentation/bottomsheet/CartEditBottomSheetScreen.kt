package org.sopt.mcdonalds.presentation.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.persistentListOf
import org.sopt.mcdonalds.R
import org.sopt.mcdonalds.R.drawable.ic_close_24
import org.sopt.mcdonalds.core.common.util.noRippleClickable
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme
import org.sopt.mcdonalds.domain.cart.model.Cart
import org.sopt.mcdonalds.presentation.order.component.OrderBurgerDetailContainer
import org.sopt.mcdonalds.presentation.order.component.OrderSideDetailContainer
import org.sopt.mcdonalds.presentation.order.model.Side

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartEditBottomSheetScreen(
    cart: Cart,
    onDismiss: () -> Unit,
    sheetState: SheetState,
    modifier: Modifier = Modifier
) {
    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        dragHandle = null
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(color = McDonaldsTheme.colors.white)
                .padding(25.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = if (cart.isSet) "${cart.menuName} - 세트" else cart.menuName,
                    style = McDonaldsTheme.typography.body14b,
                    color = McDonaldsTheme.colors.black
                )
                Icon(
                    imageVector = ImageVector.vectorResource(ic_close_24),
                    contentDescription = null,
                    modifier = Modifier
                        .noRippleClickable(onDismiss),
                    tint = McDonaldsTheme.colors.black
                )
            }
            Spacer(modifier = Modifier.height(17.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OrderBurgerDetailContainer(
                    name = cart.menuName,
                    imageId = R.drawable.img_burger_single
                )
                if (cart.isSet) {
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
                        )
                    )
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
                            )
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = McDonaldsTheme.colors.yellow,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(vertical = 12.dp)
                    .noRippleClickable(onDismiss),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.bottom_sheet_confirm_button),
                    style = McDonaldsTheme.typography.body14r.copy(
                        color = McDonaldsTheme.colors.gray800
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun CartEditBottomSheetScreenPreview() {
    MCDONALDSTheme {
        CartEditBottomSheetScreen(
            cart = Cart(
                id = 1,
                amount = 1,
                price = 11500,
                menuName = "더블 1955® 버거",
                imageUrl = "",
                isSet = true
            ),
            onDismiss = {},
            sheetState = SheetState(
                skipPartiallyExpanded = true,
                initialValue = SheetValue.Expanded,
                confirmValueChange = { true },
                skipHiddenState = false
            )
        )
    }
}
