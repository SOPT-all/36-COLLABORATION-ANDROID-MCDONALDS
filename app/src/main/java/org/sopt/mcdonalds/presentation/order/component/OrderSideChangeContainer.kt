package org.sopt.mcdonalds.presentation.order.component

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.mcdonalds.R
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme
import org.sopt.mcdonalds.presentation.order.model.Side

@Composable
fun SideChangeContainer(
    text: String,
    isExpanded: Boolean,
    toggle: () -> Unit,
    sideList: List<Side>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.clipToBounds(),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = text,
                style = McDonaldsTheme.typography.body14r,
                color = McDonaldsTheme.colors.black,
                modifier = Modifier.padding(start = 24.dp, top = 10.dp, bottom = 10.dp)
            )
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_down_chevron_20),
                contentDescription = null,
                tint = McDonaldsTheme.colors.gray800,
                modifier = Modifier
                    .padding(end = 16.dp, top = 10.dp, bottom = 10.dp)
                    .clickable(onClick = toggle)
            )
        }
        HorizontalDivider(color = McDonaldsTheme.colors.gray200, thickness = 1.dp)
        SideListContainer(
            isExpanded = isExpanded,
            sideList = sideList
        )
    }
}

@Composable
fun SideListContainer(
    isExpanded: Boolean,
    sideList: List<Side>,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.clipToBounds()) {
        AnimatedVisibility(
            visible = isExpanded,
            enter = slideInVertically(),
            exit = slideOutVertically()
        ) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Top
            ) {
                sideList.forEach { side ->
                    SideContainer(text = side.name, imageId = side.imageId)
                }
            }
        }
    }
}

@Composable
fun SideContainer(
    text: String,
    @DrawableRes imageId: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(imageId),
                contentDescription = "사이드 변경 이미지",
                modifier = Modifier
                    .padding(start = 24.dp, top = 4.dp, bottom = 4.dp)
                    .width(40.dp)
                    .height(40.dp)
            )
            Spacer(modifier = Modifier.width(32.dp))
            Text(
                text = text,
                style = McDonaldsTheme.typography.body12r,
                color = McDonaldsTheme.colors.black
            )
        }
        HorizontalDivider(color = McDonaldsTheme.colors.gray200, thickness = 1.dp)
    }
}

@Preview(showBackground = true)
@Composable
private fun SideChangeContainerPreview() {
    MCDONALDSTheme {
        var isExpanded by remember { mutableStateOf(false) }
        SideChangeContainer(
            text = stringResource(R.string.order_change_side_text),
            isExpanded = isExpanded,
            toggle = { isExpanded = !isExpanded },
            sideList = listOf(
                Side(
                    name = stringResource(R.string.order_side_coleslaw),
                    imageId = R.drawable.img_side_coleslaw
                )
            )
        )
    }
}