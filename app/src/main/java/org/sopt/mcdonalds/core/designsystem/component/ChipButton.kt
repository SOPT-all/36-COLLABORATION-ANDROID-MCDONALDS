package org.sopt.mcdonalds.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.mcdonalds.core.common.util.noRippleClickable
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme
import org.sopt.mcdonalds.presentation.store.type.StoreType

@Composable
fun ChipButton(
    isSelected: Boolean,
    selectedType: StoreType,
    onSelect: (StoreType) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle.Default,
    paddingValues: PaddingValues = PaddingValues()
) {
    val (borderColor, backgroundColor) =
        if (isSelected) {
            McDonaldsTheme.colors.darkYellow to McDonaldsTheme.colors.yellow
        } else {
            McDonaldsTheme.colors.gray400 to McDonaldsTheme.colors.white
        }

    Text(
        text = stringResource(selectedType.title),
        style = textStyle,
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .border(Dp.Hairline, borderColor, RoundedCornerShape(20.dp))
            .background(backgroundColor)
            .padding(paddingValues)
            .noRippleClickable {
                onSelect(selectedType)
            }
    )
}

@Preview
@Composable
private fun ChipButtonPreview() {
    MCDONALDSTheme {
        Row {
            ChipButton(
                isSelected = true,
                selectedType = StoreType.GARAGE,
                onSelect = {},
                textStyle = McDonaldsTheme.typography.caption10r,
                paddingValues = PaddingValues(horizontal = 16.dp, vertical = 4.dp)
            )
            ChipButton(
                isSelected = false,
                selectedType = StoreType.OPEN_24_HOURS,
                onSelect = {},
                textStyle = McDonaldsTheme.typography.caption10r,
                paddingValues = PaddingValues(horizontal = 16.dp, vertical = 4.dp)
            )
        }
    }
}
