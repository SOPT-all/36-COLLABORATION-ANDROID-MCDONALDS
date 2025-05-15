package org.sopt.mcdonalds.presentation.history.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.mcdonalds.core.common.util.NoRippleInteractionSource
import org.sopt.mcdonalds.core.designsystem.theme.MCDONALDSTheme
import org.sopt.mcdonalds.core.designsystem.theme.McDonaldsTheme

@Composable
fun HistoryMenuAddButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .padding(10.dp),
        enabled = enabled,
        border = BorderStroke(1.dp, McDonaldsTheme.colors.gray400),
        colors = ButtonDefaults.buttonColors(McDonaldsTheme.colors.white),
        shape = RoundedCornerShape(20.dp),
        contentPadding = PaddingValues(0.dp),
        interactionSource = NoRippleInteractionSource,
    ) {
        Text(
            text = text,
            style = McDonaldsTheme.typography.body12r,
            color = McDonaldsTheme.colors.black,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview
@Composable
fun HistoryMenuAddButtonPreview(
){
    MCDONALDSTheme {
        HistoryMenuAddButton(
            text = "+ 메뉴 추가",
            onClick = {},
            modifier = Modifier.size(width = 106.dp, height = 38.dp),
            enabled = true,
        )
    }
}